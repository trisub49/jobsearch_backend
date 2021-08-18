package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.PastJob;
import com.farkas.jobsearch.dto.PastJobDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PastJobRepository extends CrudRepository<PastJob, Long> {

    List<PastJob> findAllByEmployeeId(Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO past_jobs (employee_id, job, date, scope) " +
            "VALUES(:#{#job.employeeId}, :#{#job.job}, :#{#job.date}, :#{#job.scope})", nativeQuery = true)
    void save(@Param("job") PastJobDTO job);
}