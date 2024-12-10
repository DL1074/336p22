package com.example.demo.repository;

import com.example.demo.model.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MortgageRepository extends JpaRepository<Mortgage, String> {

    @Query("SELECT m FROM Mortgage m WHERE " +
           "(:county IS NULL OR m.countyName = :county) AND " +
           "(:loanType IS NULL OR m.loanType = :loanType)")
    List<Mortgage> findWithFilters(@Param("county") String county, @Param("loanType") String loanType);
}
