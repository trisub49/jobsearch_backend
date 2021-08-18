package com.farkas.jobsearch.controller;

import com.farkas.jobsearch.authentication.AuthenticationError;
import com.farkas.jobsearch.authentication.LoginData;
import com.farkas.jobsearch.domain.Employee;
import com.farkas.jobsearch.domain.Employer;
import com.farkas.jobsearch.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/register-employee")
    @CrossOrigin
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) {

        Object response = profileService.registerEmployee(employee);

        if(response instanceof AuthenticationError) {
            return new ResponseEntity<>(response, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/register-employer")
    @CrossOrigin
    public ResponseEntity<?> registerEmployer(@RequestBody Employer employer) {

        Object response = profileService.registerEmployer(employer);

        if(response instanceof AuthenticationError) {
            return new ResponseEntity<>(response, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody LoginData loginData) {

        Object response = profileService.login(loginData);

        if(response instanceof AuthenticationError) {
            return new ResponseEntity<>(response, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/edit-employee")
    @CrossOrigin
    public ResponseEntity<?> editEmployee(@RequestBody Employee employee) {

        profileService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/edit-employer")
    @CrossOrigin
    public ResponseEntity<?> editEmployer(@RequestBody Employer employer) {

        Object response = profileService.editEmployer(employer);
        if(response instanceof AuthenticationError) {
            return new ResponseEntity<>(response, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/employee/{id}/{registryId}")
    @CrossOrigin
    public ResponseEntity<?> getEmployeeForEmployer(@PathVariable Long id, @PathVariable Long registryId) {

        Object response = profileService.getEmployeeForEmployer(id, registryId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
