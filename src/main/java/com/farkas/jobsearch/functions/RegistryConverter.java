package com.farkas.jobsearch.functions;

import com.farkas.jobsearch.domain.Registry;
import com.farkas.jobsearch.dto.RegistryDTO;
import com.farkas.jobsearch.dto.RegistryWithJobDataDTO;
import com.farkas.jobsearch.service.PictureService;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.ArrayList;
import java.util.List;

public class RegistryConverter {

    public static List<RegistryDTO> registriesWithEmployeeData(List<Registry> registries) {

        List<RegistryDTO> convertedRegistries = new ArrayList<>();
        for (Registry registry: registries) {
            convertedRegistries.add(registryWithEmployeeData(registry));
        }
        return convertedRegistries;
    }

    public static List<RegistryWithJobDataDTO> registriesWithJobData(List<Registry> registries) {

        List<RegistryWithJobDataDTO> convertedRegistries = new ArrayList<>();
        for (Registry registry: registries) {
            convertedRegistries.add(registryWithJobData(registry));
        }
        return convertedRegistries;
    }

    private static RegistryDTO registryWithEmployeeData(Registry registry) {

        RegistryDTO convertedRegistry = new RegistryDTO();
        convertedRegistry.setId(registry.getId());
        convertedRegistry.setEmployeeId(registry.getEmployee().getId());
        convertedRegistry.setStatus(registry.getStatus());
        convertedRegistry.setJobId(registry.getJob().getId());
        convertedRegistry.setEmployeeName(registry.getEmployee().getName());
        convertedRegistry.setEmployeeBirthDate(registry.getEmployee().getBirthDate());
        convertedRegistry.setEmployeePhoneNumber(registry.getEmployee().getPhoneNumber());
        convertedRegistry.setEmployeeSettlement(registry.getEmployee().getSettlement());
        String picture = Base64.encodeBase64String(PictureService.getEmployeePicture(registry.getEmployee().getPicture()));
        if(picture != null) {
            convertedRegistry.setEmployeePicture("data:image/jpg;base64, " + picture);
        }
        return convertedRegistry;
    }

    private static RegistryWithJobDataDTO registryWithJobData(Registry registry) {

        RegistryWithJobDataDTO convertedRegistry = new RegistryWithJobDataDTO();
        convertedRegistry.setId(registry.getId());
        convertedRegistry.setEmployeeId(registry.getEmployee().getId());
        convertedRegistry.setStatus(registry.getStatus());
        convertedRegistry.setJobId(registry.getJob().getId());
        convertedRegistry.setJobName(registry.getJob().getScope());
        convertedRegistry.setJobCompany(registry.getJob().getEmployer().getCompany());
        convertedRegistry.setJobSettlement(registry.getJob().getSettlement());
        return convertedRegistry;
    }
}
