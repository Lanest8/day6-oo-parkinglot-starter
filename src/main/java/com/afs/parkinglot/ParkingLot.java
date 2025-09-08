package com.afs.parkinglot;

import java.util.*;

public class ParkingLot {
    private Integer capacity;
    private static final Integer CAPACITY = 10;
    private Map<Ticket, Car> ticketCars = new HashMap<>();

    public ParkingLot() {
        this.capacity = CAPACITY;
    }

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public Map<Ticket, Car> getTicketCars() {
        return ticketCars;
    }

    public void setTicketCars(Map<Ticket, Car> ticketCars) {
        this.ticketCars = ticketCars;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
