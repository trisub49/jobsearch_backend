package com.farkas.jobsearch.functions;

import com.farkas.jobsearch.domain.Employee;
import com.farkas.jobsearch.dto.EmployeeDTO;
import com.farkas.jobsearch.dto.EmployeeWithInfoDTO;
import com.farkas.jobsearch.dto.PastSchoolsAndJobs;
import com.farkas.jobsearch.service.PictureService;
import org.apache.tomcat.util.codec.binary.Base64;

public class EmployeeConverter {

    public static EmployeeDTO employee(Employee employee) {
        EmployeeDTO convertedEmployee = new EmployeeDTO();
        convertedEmployee.setId(employee.getId());
        convertedEmployee.setStatus(employee.getStatus());
        convertedEmployee.setName(employee.getName());
        convertedEmployee.setSettlement(employee.getSettlement());
        convertedEmployee.setPhoneNumber(employee.getPhoneNumber());
        convertedEmployee.setPictureName(employee.getPicture());
        convertedEmployee.setBirthDate(employee.getBirthDate());
        String picture = Base64.encodeBase64String(PictureService.getEmployeePicture(employee.getPicture()));
        if(picture != null) {
            convertedEmployee.setPicture("data:image/jpg;base64, " + picture);
        }
        return convertedEmployee;
    }

    public static EmployeeWithInfoDTO employeeWithInfo(Employee employee, PastSchoolsAndJobs pastSchoolsAndJobs, Long registryId) {
        EmployeeWithInfoDTO convertedEmployee = new EmployeeWithInfoDTO();
        convertedEmployee.setId(employee.getId());
        convertedEmployee.setRegistryId(registryId);
        convertedEmployee.setStatus(employee.getStatus());
        convertedEmployee.setName(employee.getName());
        convertedEmployee.setSettlement(employee.getSettlement());
        convertedEmployee.setPhoneNumber(employee.getPhoneNumber());
        convertedEmployee.setBirthDate(employee.getBirthDate());
        convertedEmployee.setPastJobs(pastSchoolsAndJobs.getJobList());
        convertedEmployee.setPastSchools(pastSchoolsAndJobs.getSchoolList());
        String picture = Base64.encodeBase64String(PictureService.getEmployeePicture(employee.getPicture()));
        if(picture != null) {
            convertedEmployee.setPicture("data:image/jpg;base64, " + picture);
        }
        return convertedEmployee;
    }
}
