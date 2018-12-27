package com.learnspring.demo.controllers;

import com.learnspring.demo.models.Customer;
import com.learnspring.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //Get all customers
    @RequestMapping(method = RequestMethod.GET, path = "/customer")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //Get customers of a specific id
    @RequestMapping(method = RequestMethod.GET, path = "/customer/{id}")
    public Customer getCustomersById(@PathVariable("id") Long id){
        return customerRepository.findById(id).get();
    }

    //Create new customers
    @RequestMapping(method = RequestMethod.POST, path = "/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    //Update old customers od a specific id to new values
    @RequestMapping(method = RequestMethod.PUT, path = "/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){
        customer.setId(id);

//        //for specific changes
//        Customer oldCustomer = customerRepository.findById(id).get();
//        oldCustomer.setDob(customer.getDob());

        return customerRepository.save(customer);
    }

    //Delete customers with a specific id
    @RequestMapping(method = RequestMethod.DELETE, path = "/customer/{id}")
    public String removeCustomersById(@PathVariable("id") Long id){
         customerRepository.deleteById(id);
         return "User Deleted!";
    }
}
