package com.farkas.jobsearch.service;

import com.farkas.jobsearch.authentication.AuthenticationError;
import com.farkas.jobsearch.authentication.LoginData;
import com.farkas.jobsearch.domain.Employee;
import com.farkas.jobsearch.domain.Employer;
import com.farkas.jobsearch.dto.EmployeeWithInfoDTO;
import com.farkas.jobsearch.dto.PastSchoolsAndJobs;
import com.farkas.jobsearch.functions.EmployeeConverter;
import com.farkas.jobsearch.functions.EmployerConverter;
import com.farkas.jobsearch.repository.EmployeeRepository;
import com.farkas.jobsearch.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.farkas.jobsearch.functions.CryptWithMD5.cryptWithMD5;

@Service
public class ProfileService {

    private EmployeeRepository employeeRepository;
    private EmployerRepository employerRepository;
    private PastInfoService pastInfoService;

    @Autowired
    public ProfileService(EmployeeRepository employeeRepository, EmployerRepository employerRepository, PastInfoService pastInfoService) {
        this.employeeRepository = employeeRepository;
        this.employerRepository = employerRepository;
        this.pastInfoService = pastInfoService;
    }

    public Object registerEmployee(Employee employee) {

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            return new AuthenticationError("email");
        }

        Date actualDate = new Date();
        employee.setPassword(cryptWithMD5(employee.getPassword()));
        employee.setRegisterDate(actualDate);
        employee.setLastLoginDate(actualDate);
        employee.setPhoneNumber("");
        employee.setSettlement("");
        employeeRepository.save(employee);
        employee.setPassword(null);
        return employee;
    }

    public Object registerEmployer(Employer employer) {

        if (employerRepository.existsByEmail(employer.getEmail())) {
            return new AuthenticationError("email");
        }

        if(employerRepository.existsByCompany(employer.getCompany())) {
            return new AuthenticationError("company");
        }

        Date actualDate = new Date();
        employer.setPassword(cryptWithMD5(employer.getPassword()));
        employer.setRegisterDate(actualDate);
        employer.setLastLoginDate(actualDate);
        employer.setDescription("");
        employerRepository.save(employer);
        return EmployerConverter.employer(employer);
    }

    public Object login(LoginData loginData) {

        if (!loginData.getType()) {
            return loginEmployee(loginData);
        } else {
            return loginEmployer(loginData);
        }
    }

    private Object loginEmployer(LoginData loginData) {

        if (!employerRepository.existsByEmail(loginData.getEmail())) {
            return new AuthenticationError("!registered");
        }

        Employer employer = employerRepository.getByEmail(loginData.getEmail());
        if (!employer.getPassword().equals(cryptWithMD5(loginData.getPassword()))) {
            return new AuthenticationError("password");
        }

        employerRepository.updateLastLoginDate(employer.getId(), new java.sql.Date(new Date().getTime()));
        return EmployerConverter.employer(employer);
    }

    private Object loginEmployee(LoginData loginData) {

        if (!employeeRepository.existsByEmail(loginData.getEmail())) {
            return new AuthenticationError("!registered");
        }

        Employee employee = employeeRepository.getByEmail(loginData.getEmail());
        if (!employee.getPassword().equals(cryptWithMD5(loginData.getPassword()))) {
            return new AuthenticationError("password");
        }

        employeeRepository.updateLastLoginDate(employee.getId(), new java.sql.Date(new Date().getTime()));
        return EmployeeConverter.employee(employee);
    }

    public void editEmployee(Employee employee) {

        Employee actual = employeeRepository.getById(employee.getId());
        actual.setName(employee.getName());
        actual.setSettlement(employee.getSettlement());
        actual.setPhoneNumber(employee.getPhoneNumber());
        employeeRepository.save(actual);
    }

    public Object editEmployer(Employer employer) {

        Employer inspect = employerRepository.getByCompany(employer.getCompany());
        if (inspect != null && !inspect.getId().equals(employer.getId())) {
            return new AuthenticationError("company");
        }

        Employer actual = employerRepository.getById(employer.getId());
        actual.setName(employer.getName());
        actual.setSettlement(employer.getSettlement());
        actual.setDescription(employer.getDescription());
        employerRepository.save(actual);
        return null;
    }

    public EmployeeWithInfoDTO getEmployeeForEmployer(Long id, Long registryId) {
        Employee employee = employeeRepository.getById(id);
        PastSchoolsAndJobs pastInfo = pastInfoService.findPastInfo(id);
        return EmployeeConverter.employeeWithInfo(employee, pastInfo, registryId);
    }
}