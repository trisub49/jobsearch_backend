package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.Settlement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettlementRepository extends CrudRepository<Settlement, Integer> {

    @Query("SELECT s FROM Settlement s GROUP BY s.name")
    List<Settlement> findAll();
}
