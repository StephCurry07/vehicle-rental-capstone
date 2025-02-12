package com.rental.controllers;

import com.rental.entity.Booking;
import com.rental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get a booking by ID
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") String id) {
        return bookingService.getBookingById(id);
    }

    // Create a new booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}
