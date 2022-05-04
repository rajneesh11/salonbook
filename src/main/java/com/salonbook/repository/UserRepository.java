package com.salonbook.repository;

import com.salonbook.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<Bookings, Integer> {
}
