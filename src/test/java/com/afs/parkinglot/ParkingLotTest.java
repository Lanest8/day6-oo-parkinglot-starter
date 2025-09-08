package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    //case1 Given a parking lot,a car When the car, Then return a parking ticket
    @Test
    public void should_return_ticket_when_parking_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("park number 1");
        Ticket ticket = new Ticket(car, 1, parkingLot);
        Ticket ticketResult = parkingLot.park(car);
        assertEquals(ticket, ticketResult);
    }

    //case2 Given a parking lot,a car,a parking ticket When the fetch, Then return car
    @Test
    public void should_return_car_when_fetch_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("1");
        Ticket ticketResult = parkingLot.park(car);
        Car carResult = parkingLot.fetch(ticketResult);
        assertEquals(car, carResult);
    }

    //case3 Given a parking lot,two parked cars,two parking ticket When the fetch, Then return correct car
    @Test
    public void should_return_correct_car_when_fetch_two_cars() {
        ParkingLot parkingLot = new ParkingLot();
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
    @Test
    public void should_return_null_when_fetch_a_cars_with_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Ticket wrongTicket = new Ticket(new Car("2"), 2, parkingLot);
        Car carResult = parkingLot.fetch(wrongTicket);
        assertNull(carResult);
    }

    //case5 Given a parking lot,a car When the fetch with used ticket, Then return null
    @Test
    public void should_return_null_when_fetch_a_cars_with_used_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("1");
        Ticket ticket = parkingLot.park(car);
        Car carResult1 = parkingLot.fetch(ticket);
        Car carResult2 = parkingLot.fetch(ticket);
        assertEquals(car, carResult1);
        assertNull(carResult2);
    }

    //case6 Given a parking lot,a car When the parking lot is no position, Then return null
    @Test
    public void should_return_null_when_parking_lot_no_position() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        parkingLot.park(car1);
        Ticket ticket = parkingLot.park(car2);
        assertNull(ticket);
    }

    //case7 Given a parking lot,a car When the fetch with unrecognized ticket, Then print message "Unrecognized parking ticket".
    @Test
    public void should_print_message_when_fetch_a_cars_with_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Ticket wrongTicket = new Ticket(new Car("2"), 2, parkingLot);
        parkingLot.fetch(wrongTicket);
        assertTrue(outputStream.toString().contains("Unrecognized parking ticket."));
    }

    //case8 Given a parking lot,a car When the fetch with used ticket, Then print message "Unrecognized parking ticket".

    //case9 Given a parking lot,a car When the parking lot is no position, Then print message No available position.
}
