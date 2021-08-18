package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.Registry;
import com.farkas.jobsearch.dto.RegistryDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RegistryRepository extends CrudRepository<Registry, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM registries WHERE employee_id = :#{#reg.employeeId} AND job_id = :#{#reg.jobId}",
    nativeQuery = true)
    void delete(@Param("reg") RegistryDTO registry);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO registries (job_id, employee_id, status)" +
            "VALUES(:#{#reg.jobId}, :#{#reg.employeeId}, :#{#reg.status})", nativeQuery = true)
    void save(@Param("reg") RegistryDTO registry);

    @Query(value = "SELECT * FROM registries WHERE job_id = :#{#reg.jobId} AND employee_id = :#{#reg.employeeId}",
    nativeQuery = true)
    Registry hasRegistry(@Param("reg") RegistryDTO registry);

    @Transactional
    @Modifying
    @Query(value = "UPDATE registries SET status = :status WHERE id = :id", nativeQuery = true)
    void setStatus(@Param("id") Long id, @Param("status") int status);

    List<Registry> findByEmployeeId(Long employeeId);
    List<Registry> findByJobId(Long jobId);
}
