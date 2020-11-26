package com.codeclan.example.course_booking_system;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.BookingRepository;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void createTests(){
//		Course course = new Course("Software Development", "Glasgow", 4.98);
//		courseRepository.save(course);
//
//		Customer customer = new Customer("TJ", "Glasgow", 34);
//		customerRepository.save(customer);
//
//		Booking booking = new Booking("31-08-20", customer, course);
//		bookingRepository.save(booking);
//	}

	@Test
	public void canGetCourseByRating(){
		List<Course> foundCourses = courseRepository.findCoursesByRating(4.75);
		assertEquals(2, foundCourses.size());
	}

	@Test
	public void canGetCustomerByCourseName(){
		List<Customer> foundCustomers = customerRepository.findCustomersByBookingsCourseName("Software Development");
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canGetCourseByCustomerName(){
		List<Course> foundCourses = courseRepository.findCoursesByBookingsCustomerName("Craig");
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canGetBookingsByDate(){
		List<Booking> foundBookings = bookingRepository.findBookingsByDate("31-08-20");
		assertEquals(3, foundBookings.size());
	}

}
