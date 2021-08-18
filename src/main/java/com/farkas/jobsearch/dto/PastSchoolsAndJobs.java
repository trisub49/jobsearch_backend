package com.farkas.jobsearch.dto;

import com.farkas.jobsearch.domain.PastJob;
import com.farkas.jobsearch.domain.PastSchool;

import java.util.ArrayList;
import java.util.List;

public class PastSchoolsAndJobs {

    List<PastSchoolDTO> schoolList = new ArrayList<>();
    List<PastJobDTO> jobList = new ArrayList<>();
    
    public PastSchoolsAndJobs() {
    }

    public List<PastSchoolDTO> getSchoolList() {
        return schoolList;
    }
    public void setSchoolList(List<PastSchoolDTO> schoolList) {
        this.schoolList = schoolList;
    }

    public List<PastJobDTO> getJobList() {
        return jobList;
    }
    public void setJobList(List<PastJobDTO> jobList) {
        this.jobList = jobList;
    }

    public void addSchool(PastSchoolDTO school) {
        schoolList.add(school);
    }
    public void addJob(PastJobDTO job) {
        jobList.add(job);
    }
}
