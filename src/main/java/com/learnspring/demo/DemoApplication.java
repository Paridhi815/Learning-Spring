package com.learnspring.demo;

import com.jayway.jsonpath.JsonPath;
import com.learnspring.demo.DTO.QuoteResponse;
import com.learnspring.demo.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        // way 1 - the old java way
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // hacking way 1 to make it modern -- can ignore
        List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());

//        List<Integer> intList = new ArrayList<Integer>();
//        for (int i : arr)
//        {
//            intList.add(i);
//        }
        // way 2 - the modern way
        List<Integer> numbersAgain = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> doubledNumbersAgain = numbers.stream().map(i -> i * 2).collect(Collectors.toList());

        for (int i = 0; i < doubledNumbersAgain.size(); i++) {
            System.out.println(doubledNumbersAgain.get(i));
        }

        RestTemplate restTemplate = new RestTemplate();
        QuoteResponse r1 = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", QuoteResponse.class); //need to make DTOs for this
        String r2 = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class); //This is equivalent to JSON.stringify()
        String quote = JsonPath.read(r2, "$.value.quote");
        SpringApplication.run(DemoApplication.class, args);
    }

}

