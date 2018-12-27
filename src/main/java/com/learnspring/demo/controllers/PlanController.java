package com.learnspring.demo.controllers;

import com.learnspring.demo.models.Plan;
import com.learnspring.demo.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PlanController {

    @Autowired
    PlanRepository planRepository;

    @RequestMapping(path = "/api/plans/", method = RequestMethod.GET)
    public List<Plan> getAllPlans() {
        List<Plan> plans = planRepository.findAll();
        return plans;
    }

    @RequestMapping(path = "/api/plans/", method = RequestMethod.POST)
    public Plan savePlan(@RequestBody Plan plan) {
        return planRepository.save(plan);
    }

    @RequestMapping(path = "/api/plans/repo", method = RequestMethod.GET)
    public List<Plan> getPlanByTypeWithRepo(@RequestParam String type) {
        return planRepository.findAllByType(type);
    }

    @RequestMapping(path = "/api/plans/list", method = RequestMethod.GET)
    public List<Plan> getPlanByTypeWithList(@RequestParam String type) {
        List<Plan> plans = planRepository.findAll();
        List<Plan> filteredPlans = plans.stream().filter(plan -> plan.getType().equals(type)).collect(Collectors.toList());
        return filteredPlans;
    }

}
