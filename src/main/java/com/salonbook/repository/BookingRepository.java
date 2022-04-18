package com.salonbook.repository;

import com.salonbook.entity.Bookings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Bookings, Integer> {

    @Query("select count(b.id) from Bookings b where b.booked_date = :todayDate")
    int findTodayBookingCount(String todayDate);

    @Query("SELECT b.id, b.booked_date, b.job, b.slot, b.booked_on, u.name, b.cancelled, b.job_served " +
            "FROM Bookings b JOIN User u WHERE b.user = :id AND b.booked_date = :bookingDate")
    List<Bookings> findBookingsAsToday(int id, String bookingDate);

    @Query("SELECT b.id, b.booked_date, b.job, b.slot, b.booked_on, u.name, b.cancelled, b.job_served " +
            "FROM Bookings b JOIN User u WHERE b.user = :id AND b.booked_date < :bookingDate")
    List<Bookings> findBookingsAsOld(int id, String bookingDate);

//    For admin and user
}
