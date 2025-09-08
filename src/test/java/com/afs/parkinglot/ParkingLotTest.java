package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotTest {
    //case1 Given a parking lot,a car When the car, Then return a parking ticket
    @Test
    public void should_return_ticket_when_parking_a_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("park number 1");
        Ticket ticket = new Ticket(car, 1, parkingLot);
        Ticket ticketResult = parkingLot.park(car);
        assertEquals(ticket, ticketResult);
    }


}
