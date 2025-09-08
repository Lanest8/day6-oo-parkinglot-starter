package com.afs.parkinglot;

public class Ticket {
    private ParkingLot parkingLot;
    private Car car;

    public Ticket(ParkingLot parkingLot, Car car) {
        this.parkingLot = parkingLot;
        this.car = car;
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
}
