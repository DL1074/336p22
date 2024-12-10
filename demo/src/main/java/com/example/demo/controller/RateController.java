package com.example.demo.controller;

import com.example.demo.model.Mortgage;
import com.example.demo.repository.MortgageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rates")
public class RateController {

    @Autowired
    private MortgageRepository mortgageRepository;

    @PostMapping("/calculate")
    public ResponseEntity<RateCalculationResponse> calculateRates(@RequestBody List<String> filters) {
        // Extract filters
        String county = null;
        String loanType = null;

        for (String filter : filters) {
            if (filter.startsWith("County =")) {
                county = filter.split("=")[1].trim();
            } else if (filter.startsWith("Loan Type =")) {
                loanType = filter.split("=")[1].trim();
            }
        }

        // Query database for mortgages matching filters
        List<Mortgage> mortgages = mortgageRepository.findWithFilters(county, loanType);

        double totalWeightedSum = 0;
        double totalLoanAmount = 0;
        double baseRate = 2.33;

        for (Mortgage mortgage : mortgages) {
            double rateSpread = (mortgage.getRateSpread() != null && !mortgage.getRateSpread().isEmpty())
                    ? Double.parseDouble(mortgage.getRateSpread())
                    : -1; // Use -1 for missing rate spread

            double loanAmount = Double.parseDouble(mortgage.getLoanAmount000s()) * 1000; // Convert 000s to actual value
            double rate;

            if (rateSpread == -1) {
                // Handle missing rate spread based on lien status
                if (mortgage.getLienStatus().equals("1")) {
                    rate = baseRate + 1.5;
                } else if (mortgage.getLienStatus().equals("2")) {
                    rate = baseRate + 3.5;
                } else {
                    rate = baseRate; // Default fallback
                }
            } else {
                rate = baseRate + rateSpread;
            }

            // Calculate weighted contribution
            totalWeightedSum += rate * loanAmount;
            totalLoanAmount += loanAmount;
        }

        double averageRate = totalLoanAmount > 0 ? totalWeightedSum / totalLoanAmount : 0;

        // Return response
        RateCalculationResponse response = new RateCalculationResponse(averageRate, totalLoanAmount);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/accept")
    public ResponseEntity<String> acceptRate() {
        // Example logic for accepting rates and updating database
        return ResponseEntity.ok("Rate accepted and mortgages updated.");
    }

    // Response class (if not already defined)
    static class RateCalculationResponse {
        private double averageRate;
        private double totalCost;

        public RateCalculationResponse(double averageRate, double totalCost) {
            this.averageRate = averageRate;
            this.totalCost = totalCost;
        }

        public double getAverageRate() {
            return averageRate;
        }

        public double getTotalCost() {
            return totalCost;
        }
    }
}
