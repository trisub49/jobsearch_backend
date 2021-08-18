package com.farkas.jobsearch.service;

import com.farkas.jobsearch.domain.Job;
import com.farkas.jobsearch.dto.JobDTO;
import com.farkas.jobsearch.dto.JobWithCompanyAndRegistriesDTO;
import com.farkas.jobsearch.dto.JobWithCompanyDTO;
import com.farkas.jobsearch.functions.JobConverter;
import com.farkas.jobsearch.repository.EmployerRepository;
import com.farkas.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;
    private EmployerRepository employerRepository;

    @Autowired
    public JobService(JobRepository jobRepository, EmployerRepository employerRepository) {
        this.jobRepository = jobRepository;
        this.employerRepository = employerRepository;
    }

    public List<JobWithCompanyDTO> findAllJob() {

        List<JobWithCompanyDTO> convertedJobs = new ArrayList<>();
        List<Job> jobEntities = jobRepository.findAll();
        for (Job job: jobEntities) {
            convertedJobs.add(JobConverter.jobWithCompany(job));
        }
        return convertedJobs;
    }

    public JobWithCompanyDTO findJobById(Long id) {
        return JobConverter.jobWithCompany(jobRepository.getById(id));
    }

    public List<JobWithCompanyDTO> findJobsByAttributes(String settlement, String category, String scope) {

        if(settlement.isEmpty() || settlement.equals("0")) settlement = "empty";
        if(category.isEmpty() || category.equals("0")) category = "empty";
        if(scope.isEmpty() || scope.equals("0")) scope = "empty";

        if(settlement.equals("empty")) {

            if(category.equals("empty") && !scope.equals("empty")) {
                return JobConverter.jobWithCompanyList(jobRepository.findByScopeContaining(scope));
            } else if(scope.equals("empty") && !category.equals("empty")) {
                return JobConverter.jobWithCompanyList(jobRepository.findByCategory(category));
            } else if(scope.equals("empty")) {
                return null;
            } else {
                return JobConverter.jobWithCompanyList(jobRepository.findByCategoryAndScopeContaining(category, scope));
            }
        } else {

            if(category.equals("empty") && !scope.equals("empty")) {
                return JobConverter.jobWithCompanyList(jobRepository.findBySettlementAndScopeContaining(settlement, scope));
            } else if(scope.equals("empty") && !category.equals("empty")) {
                return JobConverter.jobWithCompanyList(jobRepository.findBySettlementAndCategory(settlement, category));
            } else if(scope.equals("empty")) {
                return JobConverter.jobWithCompanyList(jobRepository.findBySettlement(settlement));
            } else {
                return JobConverter.jobWithCompanyList(jobRepository.findBySettlementAndCategoryAndScopeContaining(settlement, category, scope));
            }
        }
    }

    public void saveJob(JobDTO job) {
        job.setAdDate(new Date());
        job.setStatus(0);
        jobRepository.saveFirst(job);
    }

    public void editJob(JobDTO job) {
        jobRepository.edit(job);
    }

    public List<JobWithCompanyAndRegistriesDTO> findJobsByEmployerId(Long id) {

        List<JobWithCompanyAndRegistriesDTO> convertedJobs;
        convertedJobs = JobConverter.jobWithCompanyAndRegistriesList(jobRepository.findByEmployerId(id));
        return convertedJobs;
    }

    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }
}
