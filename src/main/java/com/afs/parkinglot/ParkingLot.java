package com.afs.parkinglot;

public class ParkingLot {
    public ParkingLot(Integer capacity) {
    }

    public Ticket park(Car car) {
        return new Ticket(this, car);
    }

    public Car fetch(Ticket ticket) {
        return null;
    }
}
