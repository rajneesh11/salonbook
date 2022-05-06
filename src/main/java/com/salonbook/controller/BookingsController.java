package com.salonbook.controller;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.salonbook.entity.Bookings;
import com.salonbook.entity.dto.BookingUserDto;
import com.salonbook.repository.BookingRepository;
import com.salonbook.responsepojo.BookingResp;
import com.salonbook.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/count/{id}", method = RequestMethod.GET)
    public BookingResp getTodayUserBookingCount(@PathVariable int id) {
        return new BookingResp(true, String.valueOf(bookingService.todayUserBookingCount(id, getTodayDate())));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public BookingResp getTodayBookingCount() {
        return new BookingResp(true, String.valueOf(bookingService.todayAllBookingCount(getTodayDate())));
    }

    @RequestMapping(value = "/today/{id}", method = RequestMethod.GET)
    public BookingResp getTodayBookingsForUser(@PathVariable int id) throws JsonEOFException {
        try {
            List<BookingUserDto> list = bookingService.retrieveUserTodayBookings(id, getTodayDate());

            if (list.isEmpty())
                return new BookingResp(false, "No Bookings Found!");
            return new BookingResp(true, list);
        } catch (Exception e) {
            return new BookingResp(false, "Error getting bookings");
        }
    }

    @RequestMapping(value = "/old/{id}", method = RequestMethod.GET)
    public BookingResp getOldBookingsForUser(@PathVariable int id) throws JsonEOFException {
        try {
            List<BookingUserDto> list = bookingService.retrieveUserOldBookings(id, getTodayDate());

            if (list.isEmpty())
                return new BookingResp(false, "No Bookings Found!");
            return new BookingResp(true, list);
        } catch (Exception e) {
            return new BookingResp(false, "Error getting bookings");
        }
    }

    @RequestMapping(value = "/allToday")
    public BookingResp getTodayBookingsForOwner() {
        List<BookingUserDto> list = bookingService.retrieveAllTodayBookings(getTodayDate());

        if (list.isEmpty())
            return new BookingResp(false, "No Bookings Found!");
        return new BookingResp(true, list);
    }

    @RequestMapping(value = "/allOld")
    public BookingResp getOldBookingsForOwner() {
        List<BookingUserDto> list = bookingService.retrieveAllOldBookings(getTodayDate());

        if (list.isEmpty())
            return new BookingResp(false, "No Bookings Found!");
        return new BookingResp(true, list);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public BookingResp createBooking(@RequestBody Bookings booking) {
        bookingRepository.save(booking);
        return new BookingResp(true, "Booking slot created successfully");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public BookingResp deleteBooking(@PathVariable int id) {
        bookingRepository.deleteById(id);
        return new BookingResp(true, "Booking slot deleted successfully");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public BookingResp updateBooking(@RequestBody Bookings bookings) {
        bookingRepository.save(bookings);
        return new BookingResp(true, "Booking slot updated successfully");
    }

    private String getTodayDate() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
