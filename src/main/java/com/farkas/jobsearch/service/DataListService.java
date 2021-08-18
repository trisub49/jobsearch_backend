package com.farkas.jobsearch.service;

import com.farkas.jobsearch.domain.Category;
import com.farkas.jobsearch.domain.Settlement;
import com.farkas.jobsearch.repository.CategoryRepository;
import com.farkas.jobsearch.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataListService {

    CategoryRepository categoryRepository;
    SettlementRepository settlementRepository;

    @Autowired
    public DataListService(CategoryRepository categoryRepository, SettlementRepository settlementRepository) {
        this.categoryRepository = categoryRepository;
        this.settlementRepository = settlementRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Settlement> getSettlements() {
        return settlementRepository.findAll();
    }
}
