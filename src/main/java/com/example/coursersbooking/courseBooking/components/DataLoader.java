package com.example.coursersbooking.courseBooking.components;

import com.example.coursersbooking.courseBooking.models.Booking;
import com.example.coursersbooking.courseBooking.models.Course;
import com.example.coursersbooking.courseBooking.models.Customer;
import com.example.coursersbooking.courseBooking.repository.BookingRepository;
import com.example.coursersbooking.courseBooking.repository.CourseRepository;
import com.example.coursersbooking.courseBooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class DataLoader implements ApplicationRunner {

    public DataLoader() {
    }

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CourseRepository courseRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("Bob", "Twon", 40);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Phill", "City", 30);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Steve", "Somewhere", 48);
        customerRepository.save(customer3);

        Course course = new Course("Intro to this thing", "There", 3);
        courseRepository.save(course);
        Course course2 = new Course("Intro to this other thing", "Other place", 2);
        courseRepository.save(course2);
        Course course3 = new Course("Advanced this brand new thing", "Edinburgh", 4);
        courseRepository.save(course3);

        Booking booking = new Booking(course, customer1, LocalDate.of(2020, 10, 10));
        bookingRepository.save(booking);
        Booking booking2 = new Booking(course2, customer1,  LocalDate.of(2020, 10, 10));
        bookingRepository.save(booking2);
        Booking booking3 = new Booking(course3, customer2, LocalDate.of(2020, 10, 10));
        bookingRepository.save(booking3);
        Booking booking4 = new Booking(course, customer2, LocalDate.of(2020, 10, 10));
        bookingRepository.save(booking4);
        Booking booking5 = new Booking(course3, customer3, LocalDate.of(2020, 10, 10));
        bookingRepository.save(booking5);

    }
}
