package com.farkas.jobsearch.controller;

import com.farkas.jobsearch.dto.PastJobDTO;
import com.farkas.jobsearch.dto.PastSchoolDTO;
import com.farkas.jobsearch.dto.PastSchoolsAndJobs;
import com.farkas.jobsearch.service.PastInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/info")
@CrossOrigin
public class PastInfoController {

    private PastInfoService pastInfoService;

    public PastInfoController(PastInfoService pastInfoService) {
        this.pastInfoService = pastInfoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PastSchoolsAndJobs> findPastInfo(@PathVariable Long id) {
        PastSchoolsAndJobs response = pastInfoService.findPastInfo(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/add/school")
    public ResponseEntity<?> addPastSchool(@RequestBody PastSchoolDTO school) {
        pastInfoService.addPastSchool(school);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/add/job")
    public ResponseEntity<?> addPastJob(@RequestBody PastJobDTO job) {
        pastInfoService.addPastJob(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/school/{id}")
    public ResponseEntity<?> deletePastSchool(@PathVariable Long id) {
        pastInfoService.deletePastSchool(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/job/{id}")
    public ResponseEntity<?> deletePastJob(@PathVariable Long id) {
        pastInfoService.deletePastJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
