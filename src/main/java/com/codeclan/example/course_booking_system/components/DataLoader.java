package com.codeclan.example.course_booking_system.components;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.BookingRepository;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Software Development", "Glasgow", 4.98);
        courseRepository.save(course1);

        Course course2 = new Course("Data Analysis", "Edinburgh", 4.75);
        courseRepository.save(course2);

        Course course3 = new Course("Web Development", "Inverness", 4.75);
        courseRepository.save(course3);

        Customer customer1 = new Customer("TJ", "Glasgow", 34);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Craig", "Glasgow", 36);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Wolverine", "Westchester", 137);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("31-08-20", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("31-08-20", customer2, course1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("31-08-20", customer3, course2);
        bookingRepository.save(booking3);
    }
}
