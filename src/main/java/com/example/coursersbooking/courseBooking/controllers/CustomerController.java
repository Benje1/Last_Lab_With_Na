package com.example.coursersbooking.courseBooking.controllers;

import com.example.coursersbooking.courseBooking.models.Customer;
import com.example.coursersbooking.courseBooking.repository.BookingRepository;
import com.example.coursersbooking.courseBooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/course")
    public ResponseEntity<List<Customer>> getCustomersByCourse(@RequestParam(name = "course") String  course){
        return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/coursetown")
    public ResponseEntity<List<Customer>> getCustomerByCourseTown(@RequestParam(name = "coursename") String coursename, @RequestParam(name = "town") String town){
        return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCaseAndBookingsCourseTownIgnoreCase(coursename, town), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/complicated")
    public ResponseEntity<List<Customer>> getCustomerByShitTonOfInfo(@RequestParam(name = "age") int age, @RequestParam(name = "coursename") String coursename, @RequestParam(name = "town")String town){
        return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndBookingsCourseNameIgnoreCaseAndBookingsCourseTownIgnoreCase(age, coursename, town), HttpStatus.OK);
    }




}
