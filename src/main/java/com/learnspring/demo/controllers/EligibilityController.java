package com.learnspring.demo.controllers;

import com.learnspring.demo.DTO.Eligibility;
import com.learnspring.demo.DTO.UnderwritingSection;
import com.learnspring.demo.services.EligibilityFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EligibilityController {
    @Autowired
    EligibilityFinder eligibilityFinder;

    @RequestMapping(method = RequestMethod.POST, path = "/underwriting")
    public Eligibility setEligibility(@RequestBody UnderwritingSection underwritingSection){
        Eligibility eligibility = new Eligibility();
        Eligibility checkEligibity = eligibilityFinder.checkEligibility(underwritingSection, eligibility);
        return checkEligibity;
    }
}
