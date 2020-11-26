package com.codeclan.example.course_booking_system.repositories;

import com.codeclan.example.course_booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomersByBookingsCourseNameIgnoreCase(String name);
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String name);
    List<Customer> findCustomersByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(int age, String town, String name);
}
