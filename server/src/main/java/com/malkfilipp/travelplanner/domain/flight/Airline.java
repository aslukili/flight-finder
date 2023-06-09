package com.malkfilipp.travelplanner.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malkfilipp.travelplanner.domain.location.Country;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

    public Airline() {
    }

    public Airline(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
