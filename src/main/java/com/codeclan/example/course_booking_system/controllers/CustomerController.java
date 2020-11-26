package com.codeclan.example.course_booking_system.controllers;

import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(name = "name", required = false) String name,
                                                       @RequestParam(name = "town", required = false) String town,
                                                       @RequestParam(name = "age", required = false) Integer age) {
        if(age != null && town != null && name != null) {
            return new ResponseEntity(customerRepository.findCustomersByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, name), HttpStatus.OK);
        }
        if(town != null && name != null){
            return new ResponseEntity(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, name), HttpStatus.OK);
        }
        if (name != null) {
            return new ResponseEntity(customerRepository.findCustomersByBookingsCourseNameIgnoreCase(name), HttpStatus.OK);
        }
        {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }
}

