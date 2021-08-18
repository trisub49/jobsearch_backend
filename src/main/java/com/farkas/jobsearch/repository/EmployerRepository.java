package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.Employer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Long> {

    boolean existsByEmail(String email);
    boolean existsByCompany(String company);
    Employer getByEmail(String email);
    Employer getById(Long id);
    Employer getByCompany(String company);

    @Transactional
    @Modifying
    @Query("UPDATE Employer e SET e.lastLoginDate = :date WHERE e.id = :id")
    void updateLastLoginDate(@Param("id") Long id, @Param("date") Date date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employers SET picture = :filename WHERE id = :id", nativeQuery = true)
    void setPicture(@Param("id") Long id, @Param("filename") String fileName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employers SET picture = null WHERE picture = :filename", nativeQuery = true)
    void deletePicture(@Param("filename") String fileName);
}
