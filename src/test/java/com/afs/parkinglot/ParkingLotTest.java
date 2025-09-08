package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    //case1 Given a parking lot,a car When the car, Then return a parking ticket
    @Test
    public void should_return_ticket_when_park_given_parking_lot_and_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("1");

        Ticket ticket = parkingLot.park(car);

        assertNotNull(ticket);
    }
}
