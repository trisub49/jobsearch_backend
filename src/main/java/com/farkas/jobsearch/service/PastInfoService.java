package com.farkas.jobsearch.service;

import com.farkas.jobsearch.domain.PastJob;
import com.farkas.jobsearch.domain.PastSchool;
import com.farkas.jobsearch.dto.PastJobDTO;
import com.farkas.jobsearch.dto.PastSchoolDTO;
import com.farkas.jobsearch.dto.PastSchoolsAndJobs;
import com.farkas.jobsearch.functions.PastInfoConverter;
import com.farkas.jobsearch.repository.PastJobRepository;
import com.farkas.jobsearch.repository.PastSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastInfoService {

    private PastJobRepository pastJobRepository;
    private PastSchoolRepository pastSchoolRepository;

    @Autowired
    public PastInfoService(PastJobRepository pastJobRepository, PastSchoolRepository pastSchoolRepository) {
        this.pastJobRepository = pastJobRepository;
        this.pastSchoolRepository = pastSchoolRepository;
    }

    public PastSchoolsAndJobs findPastInfo(Long id) {

        PastSchoolsAndJobs all = new PastSchoolsAndJobs();
        all.setJobList(PastInfoConverter.pastJobList(pastJobRepository.findAllByEmployeeId(id)));
        all.setSchoolList(PastInfoConverter.pastSchoolList(pastSchoolRepository.findAllByEmployeeId(id)));
        return all;
    }

    public List<PastSchool> findPastSchools(Long id) {
        return pastSchoolRepository.findAllByEmployeeId(id);
    }

    public List<PastJob> findPastJobs(Long id) {
        return pastJobRepository.findAllByEmployeeId(id);
    }

    public void deletePastSchool(Long id) {
        pastSchoolRepository.deleteById(id);
    }

    public void deletePastJob(Long id) {
        pastJobRepository.deleteById(id);
    }

    public void addPastSchool(PastSchoolDTO school) {
        pastSchoolRepository.save(school);
    }

    public void addPastJob(PastJobDTO job) {
        pastJobRepository.save(job);
    }
}
