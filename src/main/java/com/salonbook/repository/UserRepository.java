package com.salonbook.repository;

import com.salonbook.entity.Bookings;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Bookings, Integer> {
}
