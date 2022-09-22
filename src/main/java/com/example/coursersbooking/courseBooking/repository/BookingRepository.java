package com.example.coursersbooking.courseBooking.repository;

import com.example.coursersbooking.courseBooking.models.Booking;
import com.example.coursersbooking.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    List<Booking> findByDate(LocalDate date);
}
