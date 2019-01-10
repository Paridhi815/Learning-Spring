package com.learnspring.demo.services;

import com.learnspring.demo.DTO.UnderwritingSection;
import com.learnspring.demo.DTO.Eligibility;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibilityFinder {
    @Autowired
    private KieContainer kieContainer;


    public Eligibility checkEligibility(UnderwritingSection underwritingSection, Eligibility eligibility) {
        KieSession kieSession = kieContainer.newKieSession();
        eligibility.setStatus(true);
        kieSession.setGlobal("eligibility", eligibility);
        kieSession.insert(underwritingSection);
        kieSession.fireAllRules();
        kieSession.dispose();
        return eligibility;
    }
}
