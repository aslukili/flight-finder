package com.malkfilipp.travelplanner.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    private Timestamp departureTime;
    private Timestamp arrivalTime;

    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    private List<Ticket> tickets;

    public Schedule() {
    }

    public Schedule(Integer id, Flight flight, Timestamp departureTime, Timestamp arrivalTime) {
        this.id = id;
        this.flight = flight;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", flight=" + flight +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
