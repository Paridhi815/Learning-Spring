package com.learnspring.demo.services;

import com.learnspring.demo.models.Customer;
import com.learnspring.demo.models.FinancialDetails;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumCalculatorService {

    @Autowired
    private KieContainer kieContainer;


    public FinancialDetails calculatePremiumAmount(Customer customer, FinancialDetails financialDetails) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("financialDetails", financialDetails);
        kieSession.insert(customer);
        kieSession.fireAllRules();
        kieSession.dispose();
        return financialDetails;
    }
}