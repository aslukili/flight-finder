package com.malkfilipp.travelplanner.domain;


import com.malkfilipp.travelplanner.domain.flight.Flight;
import com.malkfilipp.travelplanner.domain.user.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "userId")
    private AppUser user;


}