package com.codeclan.example.course_booking_system.repositories;

import com.codeclan.example.course_booking_system.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByRating(Double rating);
    List<Course> findCoursesByBookingsCustomerNameIgnoreCase(String name);
}
