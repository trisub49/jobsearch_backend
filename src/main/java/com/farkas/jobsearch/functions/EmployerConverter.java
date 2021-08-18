package com.farkas.jobsearch.functions;

import com.farkas.jobsearch.domain.Employer;
import com.farkas.jobsearch.dto.EmployerDTO;
import com.farkas.jobsearch.service.PictureService;
import org.apache.tomcat.util.codec.binary.Base64;

public class EmployerConverter {

    public static EmployerDTO employer(Employer employer) {
        EmployerDTO convertedEmployer = new EmployerDTO();
        convertedEmployer.setId(employer.getId());
        convertedEmployer.setCompany(employer.getCompany());
        convertedEmployer.setName(employer.getName());
        convertedEmployer.setSettlement(employer.getSettlement());
        convertedEmployer.setPhoneNumber(employer.getPhoneNumber());
        convertedEmployer.setDescription(employer.getDescription());
        convertedEmployer.setPictureName(employer.getPicture());
        String picture = Base64.encodeBase64String(PictureService.getEmployerPicture(employer.getPicture()));
        if(picture != null) {
            convertedEmployer.setPicture("data:image/jpg;base64, " + picture);
        }
        return convertedEmployer;
    }
}
