package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    boolean existsByEmail(String email);
    Employee getByEmail(String email);
    Employee getById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees SET last_login_date = :date WHERE id = :id", nativeQuery = true)
    void updateLastLoginDate(@Param("id") Long id, @Param("date") Date date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees SET picture = :filename WHERE id = :id", nativeQuery = true)
    void setPicture(@Param("id") Long id, @Param("filename") String fileName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees SET picture = null WHERE picture = :filename", nativeQuery = true)
    void deletePicture(@Param("filename") String fileName);
}
