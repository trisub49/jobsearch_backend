package com.farkas.jobsearch.repository;

import com.farkas.jobsearch.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findAll();
}
