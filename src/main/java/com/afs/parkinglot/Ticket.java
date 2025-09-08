package com.afs.parkinglot;

import java.util.Objects;

public class Ticket {
    private ParkingLot parkingLot;
    private Integer position;
    private Car car;

    public Ticket(ParkingLot parkingLot, Car car) {
        this.parkingLot = parkingLot;
        this.car = car;
    }

    public Ticket(Car car, Integer position, ParkingLot parkingLot) {
        this.car = car;
        this.position = position;
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(parkingLot, ticket.parkingLot) && Objects.equals(position, ticket.position) && Objects.equals(car, ticket.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingLot, position, car);
    }
}
