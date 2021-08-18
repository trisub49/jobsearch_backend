package com.farkas.jobsearch.service;

import com.farkas.jobsearch.domain.Registry;
import com.farkas.jobsearch.dto.RegistryDTO;
import com.farkas.jobsearch.dto.RegistryWithJobDataDTO;
import com.farkas.jobsearch.functions.RegistryConverter;
import com.farkas.jobsearch.repository.RegistryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistryService {

    RegistryRepository registryRepository;

    public RegistryService(RegistryRepository registryRepository) {
        this.registryRepository = registryRepository;
    }

    public void addRegistry(RegistryDTO registry) {
        registryRepository.save(registry);
    }

    public void deleteRegistry(RegistryDTO registry) {
        registryRepository.delete(registry);
    }

    public boolean hasRegistry(RegistryDTO registry) {

        if(registryRepository.hasRegistry(registry) != null) {
            return true;
        }
        return false;
    }

    public void setStatus(RegistryDTO registry) {
        registryRepository.setStatus(registry.getId(), registry.getStatus());
    }

    public List<RegistryWithJobDataDTO> findByEmployeeId(Long employeeId) {
        return RegistryConverter.registriesWithJobData(registryRepository.findByEmployeeId(employeeId));
    }

    public List<RegistryDTO> findByJobId(Long jobId) {
        return RegistryConverter.registriesWithEmployeeData(registryRepository.findByJobId(jobId));
    }
}
