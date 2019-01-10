package com.learnspring.demo.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleEngineConfiguration {

    @Value("${drl.premiumRule}")
    String premiumDrl;
    //Just give the drl file name here
    private static final String drlFile2 = "UNDERWRITING_SECTION_ELIGIBILITY.drl";

    //The following is constant in-built code.no need to see and understand :P :D
    @Bean
    public KieContainer kieContainer() {
        System.out.println(premiumDrl);
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(premiumDrl + ".drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile2));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }
}
