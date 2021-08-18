package com.farkas.jobsearch.functions;

import com.farkas.jobsearch.domain.PastJob;
import com.farkas.jobsearch.domain.PastSchool;
import com.farkas.jobsearch.dto.PastJobDTO;
import com.farkas.jobsearch.dto.PastSchoolDTO;

import java.util.ArrayList;
import java.util.List;

public class PastInfoConverter {

    public static PastJobDTO pastJob(PastJob pastJob) {

        PastJobDTO convertedPastJob = new PastJobDTO();
        convertedPastJob.setId(pastJob.getId());
        convertedPastJob.setJob(pastJob.getJob());
        convertedPastJob.setDate(pastJob.getDate());
        convertedPastJob.setScope(pastJob.getScope());
        convertedPastJob.setEmployeeId(pastJob.getEmployee().getId());
        return convertedPastJob;
    }
    public static List<PastJobDTO> pastJobList(List<PastJob> pastJobs) {
        List<PastJobDTO> convertedPastJobs = new ArrayList<>();
        for (PastJob school: pastJobs) {
            convertedPastJobs.add(pastJob(school));
        }
        return convertedPastJobs;
    }

    public static PastSchoolDTO pastSchool(PastSchool pastSchool) {

        PastSchoolDTO convertedPastSchool = new PastSchoolDTO();
        convertedPastSchool.setId(pastSchool.getId());
        convertedPastSchool.setSchool(pastSchool.getSchool());
        convertedPastSchool.setDate(pastSchool.getDate());
        convertedPastSchool.setEducation(pastSchool.getEducation());
        convertedPastSchool.setEmployeeId(pastSchool.getEmployee().getId());
        return convertedPastSchool;
    }

    public static List<PastSchoolDTO> pastSchoolList(List<PastSchool> pastSchools) {
        List<PastSchoolDTO> convertedPastSchools = new ArrayList<>();
        for (PastSchool school: pastSchools) {
            convertedPastSchools.add(pastSchool(school));
        }
        return convertedPastSchools;
    }
}
