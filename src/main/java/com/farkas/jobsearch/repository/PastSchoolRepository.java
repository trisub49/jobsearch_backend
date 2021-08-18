package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.PastSchool;
import com.farkas.jobsearch.dto.PastJobDTO;
import com.farkas.jobsearch.dto.PastSchoolDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PastSchoolRepository extends CrudRepository<PastSchool, Long> {

    List<PastSchool> findAllByEmployeeId(Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO past_schools (employee_id, school, date, education) " +
            "VALUES(:#{#school.employeeId}, :#{#school.school}, :#{#school.date}, :#{#school.education})", nativeQuery = true)
    void save(@Param("school") PastSchoolDTO school);
}
