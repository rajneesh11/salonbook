package com.salonbook.controller;

import com.salonbook.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/booking")
public class BookingsController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getTodayBookingCount() {
        Date date = new Date();
        String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return bookingService.todayBookingCount(todayDate);
    }
}
