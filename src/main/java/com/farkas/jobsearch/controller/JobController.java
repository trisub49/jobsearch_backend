package com.farkas.jobsearch.controller;

import com.farkas.jobsearch.domain.Job;
import com.farkas.jobsearch.dto.JobDTO;
import com.farkas.jobsearch.dto.JobWithCompanyAndRegistriesDTO;
import com.farkas.jobsearch.dto.JobWithCompanyDTO;
import com.farkas.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
@CrossOrigin
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("")
    public ResponseEntity<List<JobWithCompanyDTO>> findAllJob() {

        List<JobWithCompanyDTO> jobs = jobService.findAllJob();
        if(jobs.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobWithCompanyDTO> findJobById(@PathVariable Long id) {

        JobWithCompanyDTO job = jobService.findJobById(id);
        if(job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobById(@PathVariable Long id) {
        jobService.deleteJobById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<List<JobWithCompanyAndRegistriesDTO>> findJobsByEmployerId(@PathVariable Long id) {

        List<JobWithCompanyAndRegistriesDTO> jobs = jobService.findJobsByEmployerId(id);
        if(jobs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{settlement}/{category}/{scope}")
    public ResponseEntity<List<JobWithCompanyDTO>> findJobsByAttributes(@PathVariable String settlement, @PathVariable String category, @PathVariable String scope) {

        if(settlement.length() == 0) settlement = "empty";
        if(category.length() == 0) category = "empty";
        if(scope.length() == 0) scope = "empty";
        List<JobWithCompanyDTO> jobs = jobService.findJobsByAttributes(settlement, category, scope);
        if(jobs == null || jobs.size() == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveJob(@RequestBody JobDTO job) {
        jobService.saveJob(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editJob(@RequestBody JobDTO job) {
        jobService.editJob(job);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
