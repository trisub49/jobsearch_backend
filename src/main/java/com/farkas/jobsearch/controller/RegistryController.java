package com.farkas.jobsearch.controller;

import com.farkas.jobsearch.dto.RegistryDTO;
import com.farkas.jobsearch.dto.RegistryWithJobDataDTO;
import com.farkas.jobsearch.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/sign")
public class RegistryController {

    RegistryService registryService;

    @Autowired
    public RegistryController(RegistryService registryService) {
        this.registryService = registryService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getRegistries(@PathVariable Long employeeId) {

        List<RegistryWithJobDataDTO> registries = registryService.findByEmployeeId(employeeId);
        if(registries != null && registries.size() != 0) {
            return new ResponseEntity<>(registries, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<?> getRegistriesByJobId(@PathVariable Long jobId) {

        List<RegistryDTO> registries = registryService.findByJobId(jobId);
        if(registries != null && registries.size() != 0) {
            return new ResponseEntity<>(registries, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRegistry(@RequestBody RegistryDTO registry) {
        registryService.addRegistry(registry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/hasregistry")
    public ResponseEntity<?> hasRegistry(@RequestBody RegistryDTO registry) {

        if(!registryService.hasRegistry(registry)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteRegistry(@RequestBody RegistryDTO registry) {
        registryService.deleteRegistry(registry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity<?> setStatus(@RequestBody RegistryDTO registry) {
        registryService.setStatus(registry);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
