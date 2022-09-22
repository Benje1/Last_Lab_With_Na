package com.example.coursersbooking.courseBooking.controllers;

import com.example.coursersbooking.courseBooking.models.Booking;
import com.example.coursersbooking.courseBooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBooking(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/date")
    public ResponseEntity<List<Booking>> getBookingByDate(@RequestParam(name = "year")int year, @RequestParam(name = "month")int month, @RequestParam(name = "day")int day){
        return new ResponseEntity<>(bookingRepository.findByDate(LocalDate.of(year, month, day)), HttpStatus.OK);
    }


}
