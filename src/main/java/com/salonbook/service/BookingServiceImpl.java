package com.salonbook.service;

import com.salonbook.entity.Bookings;
import com.salonbook.entity.dto.BookingUserDto;
import com.salonbook.repository.BookingRepository;
import com.salonbook.responsepojo.BookingResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public int todayUserBookingCount(int id, String todayDate) {
        return bookingRepository.findTodayUserBookingCount(id, todayDate);
    }
@Override
    public int todayAllBookingCount(String todayDate) {
        return bookingRepository.findTodayBookingCount(todayDate);
    }

    @Override
    public List<BookingUserDto> retrieveUserTodayBookings(int id, String todayDate) {
        return bookingRepository.findTodayBookingsByUser(id, todayDate);
    }

    @Override
    public List<BookingUserDto> retrieveUserOldBookings(int id, String todayDate) {
        return bookingRepository.findOldBookingsByUser(id, todayDate);
    }

    @Override
    public List<BookingUserDto> retrieveAllTodayBookings(String todayDate) {
        return bookingRepository.findTodayBookingsForSalonOwner(todayDate);
    }

    @Override
    public List<BookingUserDto> retrieveAllOldBookings(String todayDate) {
        return bookingRepository.findOldBookingsForSalonOwner(todayDate);
    }

    @Override
    public BookingResp createBooking(Bookings booking) {
        Bookings o = bookingRepository.save(booking);
        if (o != null) {
            return new BookingResp(true, "Booking slot created");
        } else {
            return new BookingResp(true, "Unable to create booking Slot");
        }
    }

    @Override
    public BookingResp deleteBooking(int id) {
        bookingRepository.deleteById(id);
        return null;
    }
}
