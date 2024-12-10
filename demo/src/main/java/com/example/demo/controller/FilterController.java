package com.example.demo.controller;

import com.example.demo.model.Mortgage;
import com.example.demo.repository.MortgageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filters")
public class FilterController {

    @Autowired
    private MortgageRepository mortgageRepository;

    // Initialize activeFilters
    private List<String> activeFilters = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<String>> getActiveFilters() {
        return ResponseEntity.ok(activeFilters);
    }

    @PostMapping
    public ResponseEntity<String> addFilter(@RequestBody String filter) {
        activeFilters.add(filter);
        return ResponseEntity.ok("Filter added: " + filter);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFilter(@RequestParam(required = false) String filterName) {
        if (filterName == null) {
            activeFilters.clear();
            return ResponseEntity.ok("All filters cleared.");
        } else {
            activeFilters.remove(filterName);
            return ResponseEntity.ok("Filter removed: " + filterName);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<Mortgage>> searchMortgages() {
        // Extract filter values (assume filter format: "Key = Value")
        String county = null;
        String loanType = null;

        for (String filter : activeFilters) {
            if (filter.startsWith("County =")) {
                county = filter.split("=")[1].trim();
            } else if (filter.startsWith("Loan Type =")) {
                loanType = filter.split("=")[1].trim();
            }
        }

        // Query database using extracted parameters
        List<Mortgage> results = mortgageRepository.findWithFilters(county, loanType);
        return ResponseEntity.ok(results);
    }
}
