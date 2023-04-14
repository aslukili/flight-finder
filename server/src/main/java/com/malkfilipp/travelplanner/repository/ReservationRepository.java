package com.malkfilipp.travelplanner.repository;

import com.malkfilipp.travelplanner.domain.Reservation;
import com.malkfilipp.travelplanner.domain.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findReservationsByUser(AppUser user);
}