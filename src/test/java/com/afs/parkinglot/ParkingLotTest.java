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

    //case2 Given a parking lot,a car,a parking ticket When the fetch, Then return car
    @Test
    public void should_return_car_when_fetch_a_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car("1");
        Ticket ticketResult = parkingLot.park(car);
        Car carResult = parkingLot.fetch(ticketResult);
        assertEquals(car, carResult);
    }

    //case3 Given a parking lot,two parked cars,two parking ticket When the fetch, Then return correct car
    @Test
    public void should_return_correct_car_when_fetch_two_cars() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Car carResult1 = parkingLot.fetch(ticket1);
        Car carResult2 = parkingLot.fetch(ticket2);
        assertEquals(car1, carResult1);
        assertEquals(car2, carResult2);
    }

    //case4 Given a parking lot,a car When the fetch with wrong ticket, Then return null
    //case5 Given a parking lot,a car When the fetch with used ticket, Then return null
    //case6 Given a parking lot,a car When the parking lot is no position, Then return null
}
