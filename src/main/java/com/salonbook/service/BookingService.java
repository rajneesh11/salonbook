package com.salonbook.service;

import com.salonbook.entity.Bookings;

import java.util.List;

public interface BookingService {
    int todayBookingCount(String todayDate);
    List<Bookings> retrieveBookings(String bookingsData);
}
