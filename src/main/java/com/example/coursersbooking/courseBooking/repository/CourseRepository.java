package com.example.coursersbooking.courseBooking.repository;

import com.example.coursersbooking.courseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(int rating);
    List<Course> findByBookingsCustomerNameIgnoreCase(String name);
//    List<Course> findByCustomerId(Long id);
}
