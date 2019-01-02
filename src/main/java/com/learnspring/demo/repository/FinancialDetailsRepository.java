package com.learnspring.demo.repository;

import com.learnspring.demo.models.FinancialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialDetailsRepository extends JpaRepository<FinancialDetails, Integer> {
}
