package com.malkfilipp.travelplanner.service;

import com.malkfilipp.travelplanner.domain.Reservation;
import com.malkfilipp.travelplanner.domain.user.AppUser;
import com.malkfilipp.travelplanner.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsOfUser(AppUser user) {
        return reservationRepository.findReservationsByUser(user);
    }
}