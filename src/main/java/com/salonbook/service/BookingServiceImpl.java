package com.salonbook.service;

import com.salonbook.entity.dto.BookingUserDto;
import com.salonbook.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public int todayBookingCount(String todayDate) {
        return bookingRepository.findTodayBookingCount(todayDate);
    }

    @Override
    public List<BookingUserDto> retrieveBookings(int id, String todayDate) {
        return bookingRepository.findOldBookingsByUser(id, todayDate);
    }
}
