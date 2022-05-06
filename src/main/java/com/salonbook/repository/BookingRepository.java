package com.salonbook.repository;

import com.salonbook.entity.Bookings;
import com.salonbook.entity.dto.BookingUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {

    @Query("select count(b.id) from Bookings b where b.userId = :id and b.booked_date = :todayDate")
    int findTodayUserBookingCount(int id, String todayDate);

    @Query("select count(b.id) from Bookings b where b.booked_date = :todayDate")
    int findTodayBookingCount(String todayDate);

    @Query("SELECT new com.salonbook.entity.dto.BookingUserDto(b.id, b.booked_date, b.job, b.slot, b.booked_on, uu.name, b.cancelled, b.job_served)" +
            " FROM Bookings as b INNER JOIN b.user as uu WHERE b.user.id = :id AND b.booked_date = :todayDate")
    List<BookingUserDto> findTodayBookingsByUser(int id, String todayDate);

    @Query("SELECT new com.salonbook.entity.dto.BookingUserDto(b.id, b.booked_date, b.job, b.slot, b.booked_on, uu.name, b.cancelled, b.job_served)" +
            " FROM Bookings as b INNER JOIN b.user as uu WHERE b.user.id = :id AND b.booked_date < :todayDate")
    List<BookingUserDto> findOldBookingsByUser(int id, String todayDate);

    @Query("SELECT new com.salonbook.entity.dto.BookingUserDto(b.id, b.booked_date, b.job, b.slot, b.booked_on, uu.name, b.cancelled, b.job_served)" +
            " FROM Bookings as b INNER JOIN b.user as uu WHERE b.booked_date = :todayDate")
    List<BookingUserDto> findTodayBookingsForSalonOwner(String todayDate);

    @Query("SELECT new com.salonbook.entity.dto.BookingUserDto(b.id, b.booked_date, b.job, b.slot, b.booked_on, uu.name, b.cancelled, b.job_served)" +
            " FROM Bookings as b INNER JOIN b.user as uu WHERE b.booked_date < :todayDate")
    List<BookingUserDto> findOldBookingsForSalonOwner(String todayDate);
}