package com.salonbook.controller;

import com.salonbook.entity.Bookings;
import com.salonbook.entity.dto.BookingUserDto;
import com.salonbook.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping("/booking")
public class BookingsController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getTodayBookingCount() {
        return bookingService.todayBookingCount(getTodayDate());
    }

    @RequestMapping(value = "/bookings/{id}", method = RequestMethod.GET)
    public List<BookingUserDto> getBookings(@PathVariable int id) {
        return bookingService.retrieveBookings(id, getTodayDate());
    }

    private String getTodayDate(){
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
