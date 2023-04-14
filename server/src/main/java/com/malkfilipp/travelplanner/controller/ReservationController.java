package com.malkfilipp.travelplanner.controller;


import com.malkfilipp.travelplanner.domain.Reservation;
import com.malkfilipp.travelplanner.domain.ReservationRequestDto;
import com.malkfilipp.travelplanner.domain.flight.Flight;
import com.malkfilipp.travelplanner.domain.user.AppUser;
import com.malkfilipp.travelplanner.repository.flight.FlightRepository;
import com.malkfilipp.travelplanner.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final FlightRepository flightRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody ReservationRequestDto reservationRequest, @AuthenticationPrincipal AppUser user) {
        Flight flight = flightRepository.findById(reservationRequest.getFlightId()).orElseThrow();
        Reservation reservation = Reservation.builder()
                .flight(flight)
                .user(user)
                .build();
        return reservationService.create(reservation);
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<Reservation> getReservationsOfUser(@AuthenticationPrincipal AppUser user) {
        return this.reservationService.getReservationsOfUser(user);
    }

}