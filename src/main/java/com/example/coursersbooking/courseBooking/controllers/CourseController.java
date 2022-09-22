package com.example.coursersbooking.courseBooking.controllers;

import com.example.coursersbooking.courseBooking.models.Course;
import com.example.coursersbooking.courseBooking.repository.CourseRepository;
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
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/rating")
    public ResponseEntity<List<Course>> getCourseByRating(@RequestParam(name = "rating") int rating){
        return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
    }
    //localhost:8080/courses/rating?rating=3

    @GetMapping(value = "/courses/customer")
    public ResponseEntity<List<Course>> getCoursesByCustomer(@RequestParam(name = "customer") String customer){
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(customer), HttpStatus.OK);
    }
    //localhost:8080/courses/customer?customer=bob


}
