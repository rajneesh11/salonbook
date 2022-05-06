package com.salonbook.service;

import com.salonbook.entity.Bookings;
import com.salonbook.entity.dto.BookingUserDto;
import com.salonbook.responsepojo.BookingResp;

import java.util.List;

public interface BookingService {
    int todayUserBookingCount(int id, String todayDate);
    int todayAllBookingCount(String todayDate);
    List<BookingUserDto> retrieveUserTodayBookings(int id, String todayDate);
    List<BookingUserDto> retrieveUserOldBookings(int id, String todayDate);
    List<BookingUserDto> retrieveAllTodayBookings(String todayDate);
    List<BookingUserDto> retrieveAllOldBookings(String todayDate);
    BookingResp createBooking(Bookings booking);
    BookingResp deleteBooking(int id);
}
