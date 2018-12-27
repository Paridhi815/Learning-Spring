package com.learnspring.demo.repository;

import com.learnspring.demo.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
  Plan findByName(String name);
  List<Plan> findAllByType(String type);
}
