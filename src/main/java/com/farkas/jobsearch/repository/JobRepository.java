package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.Job;
import com.farkas.jobsearch.dto.JobDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

    @Query(value = "SELECT * FROM jobs ORDER BY ad_date DESC", nativeQuery = true)
    List<Job> findAll();


    List<Job> findBySettlementAndCategoryAndScopeContaining(String settlement, String category, String scope);
    List<Job> findByScopeContaining(String scope);
    List<Job> findByCategoryAndScopeContaining(String category, String scope);
    List<Job> findBySettlementAndScopeContaining(String settlement, String scope);
    List<Job> findByCategory(String category);
    List<Job> findBySettlementAndCategory(String settlement, String category);
    List<Job> findBySettlement(String settlement);

    Job getById(Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO jobs (ad_text, employer_id, status, scope, category, ad_date, deadline, settlement)" +
            "VALUES(:#{#job.adText}, :#{#job.employerId}, :#{#job.status}, :#{#job.scope}, :#{#job.category}, :#{#job.adDate}, :#{#job.deadline}, :#{#job.settlement})", nativeQuery = true)
    void saveFirst(@Param("job") JobDTO job);

    @Query(value = "SELECT * FROM jobs WHERE employer_id = :id", nativeQuery = true)
    List<Job> findByEmployerId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE jobs SET scope = :#{#job.scope}, category = :#{#job.category}, ad_text = :#{#job.adText}, settlement = :#{#job.settlement}, deadline = :#{#job.deadline} " +
            "WHERE id = :#{#job.id}", nativeQuery = true)
    void edit(@Param("job") JobDTO job);
}
