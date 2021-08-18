package com.farkas.jobsearch.functions;

import com.farkas.jobsearch.domain.Job;
import com.farkas.jobsearch.dto.JobWithCompanyAndRegistriesDTO;
import com.farkas.jobsearch.dto.JobWithCompanyDTO;
import com.farkas.jobsearch.service.PictureService;
import org.apache.tomcat.util.codec.binary.Base64;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class JobConverter {

    public static JobWithCompanyDTO jobWithCompany(Job job) {

        JobWithCompanyDTO convertedJob = new JobWithCompanyDTO();
        convertedJob.setId(job.getId());
        convertedJob.setCompany(job.getEmployer().getCompany());
        convertedJob.setEmployerId(job.getEmployer().getId());
        convertedJob.setAdDate(job.getAdDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        convertedJob.setSettlement(job.getSettlement());
        convertedJob.setAdText(job.getAdText());
        convertedJob.setCategory(job.getCategory());
        convertedJob.setDeadline(job.getDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        convertedJob.setScope(job.getScope());
        convertedJob.setStatus(job.getStatus());
        String picture = Base64.encodeBase64String(PictureService.getEmployerPicture(job.getEmployer().getPicture()));
        if(picture != null) {
            convertedJob.setPicture("data:image/jpg;base64, " + picture);
        }
        return convertedJob;
    }

    public static List<JobWithCompanyDTO> jobWithCompanyList(List<Job> jobs) {

        List<JobWithCompanyDTO> convertedJobs = new ArrayList<>();
        for (Job job: jobs) {
            convertedJobs.add(jobWithCompany(job));
        }
        return convertedJobs;
    }

    public static JobWithCompanyAndRegistriesDTO jobWithCompanyAndRegistries(Job job) {

        JobWithCompanyAndRegistriesDTO convertedJob = new JobWithCompanyAndRegistriesDTO();
        convertedJob.setId(job.getId());
        convertedJob.setCompany(job.getEmployer().getCompany());
        convertedJob.setEmployerId(job.getEmployer().getId());
        convertedJob.setAdDate(job.getAdDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        convertedJob.setSettlement(job.getSettlement());
        convertedJob.setAdText(job.getAdText());
        convertedJob.setCategory(job.getCategory());
        convertedJob.setDeadline(job.getDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        convertedJob.setScope(job.getScope());
        convertedJob.setStatus(job.getStatus());
        convertedJob.setRegistries(RegistryConverter.registriesWithEmployeeData(job.getRegistries()));
        return convertedJob;
    }

    public static List<JobWithCompanyAndRegistriesDTO> jobWithCompanyAndRegistriesList(List<Job> jobs) {

        List<JobWithCompanyAndRegistriesDTO> convertedJobs = new ArrayList<>();
        for (Job job: jobs) {
            convertedJobs.add(jobWithCompanyAndRegistries(job));
        }
        return convertedJobs;
    }
}
