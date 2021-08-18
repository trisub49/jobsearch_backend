package com.farkas.jobsearch.controller;

import com.farkas.jobsearch.domain.Category;
import com.farkas.jobsearch.domain.Settlement;
import com.farkas.jobsearch.service.DataListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@CrossOrigin
public class DataListController {

    DataListService dataListService;

    @Autowired
    public DataListController(DataListService dataListService) {
        this.dataListService = dataListService;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        List<Category> categories = dataListService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/settlements")
    public ResponseEntity<?> getSettlements() {
        List<Settlement> settlements = dataListService.getSettlements();
        return new ResponseEntity<>(settlements, HttpStatus.OK);
    }
}
