package com.example.coursersbooking.courseBooking.repository;

import com.example.coursersbooking.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);
//    List<Customer> findBookingsByCourseId(Long id);
    List<Customer> findByBookingsCourseNameIgnoreCaseAndBookingsCourseTownIgnoreCase(String courseName, String town);
    List<Customer> findByAgeGreaterThanAndBookingsCourseNameIgnoreCaseAndBookingsCourseTownIgnoreCase( int age, String courseName, String town);
}
