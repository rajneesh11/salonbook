package com.salonbook.service;

import com.salonbook.entity.dto.BookingUserDto;

import java.util.List;

public interface BookingService {
    int todayBookingCount(String todayDate);
    List<BookingUserDto> retrieveBookings(int id, String bookingsData);
}
