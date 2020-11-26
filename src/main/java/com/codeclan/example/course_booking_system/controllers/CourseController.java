package com.codeclan.example.course_booking_system.controllers;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourses(@RequestParam(name = "rating", required = false) Double rating,
                                                   @RequestParam(name = "name", required = false) String name) {
        if (rating != null) {
            return new ResponseEntity(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
        }
        if(name != null) {
            return new ResponseEntity(courseRepository.findCoursesByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
        }
        {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        }
    }

    // List<Course> findCoursesByBookingsCustomerName(String name);

}
