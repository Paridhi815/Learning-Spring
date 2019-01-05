package com.learnspring.demo;

import com.jayway.jsonpath.JsonPath;
import com.learnspring.demo.DTO.QuoteResponse;
import com.learnspring.demo.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        QuoteResponse r1 = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", QuoteResponse.class); //need to make DTOs for this
        String r2 = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class); //This is equivalent to JSON.stringify()
        String quote = JsonPath.read(r2, "$.value.quote");
        SpringApplication.run(DemoApplication.class, args);
    }

}

