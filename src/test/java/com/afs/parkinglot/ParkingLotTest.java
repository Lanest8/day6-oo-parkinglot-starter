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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car("park number 1");
        Ticket ticket = new Ticket(car, 1, parkingLot);
        standardParkingBoy.addParkingLot(parkingLot);
        Ticket ticketResult = standardParkingBoy.park(car);
        assertEquals(ticket, ticketResult);
    }

    //case2 Given a parking lot,a car,a parking ticket When the fetch, Then return car
    @Test
    public void should_return_car_when_fetch_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car("1");
        standardParkingBoy.addParkingLot(parkingLot);
        Ticket ticketResult = standardParkingBoy.park(car);
        Car carResult = standardParkingBoy.fetch(ticketResult);
        assertEquals(car, carResult);
    }

    //case3 Given a parking lot,two parked cars,two parking ticket When the fetch, Then return correct car
    @Test
    public void should_return_correct_car_when_fetch_two_cars() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        standardParkingBoy.addParkingLot(parkingLot);
        Ticket ticket1 = standardParkingBoy.park(car1);
        Ticket ticket2 = standardParkingBoy.park(car2);
        Car carResult1 = standardParkingBoy.fetch(ticket1);
        Car carResult2 = standardParkingBoy.fetch(ticket2);
        assertEquals(car1, carResult1);
        assertEquals(car2, carResult2);
    }

    //case4 Given a parking lot,a car When the fetch with wrong ticket, Then return null
    @Test
    public void should_return_null_when_fetch_a_cars_with_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Ticket wrongTicket = new Ticket(new Car("2"), 2, parkingLot);
        standardParkingBoy.addParkingLot(parkingLot);
        Car carResult = standardParkingBoy.fetch(wrongTicket);
        assertNull(carResult);
    }

    //case5 Given a parking lot,a car When the fetch with used ticket, Then return null
    @Test
    public void should_return_null_when_fetch_a_cars_with_used_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car("1");
        standardParkingBoy.addParkingLot(parkingLot);
        Ticket ticket = standardParkingBoy.park(car);
        Car carResult1 = standardParkingBoy.fetch(ticket);
        Car carResult2 = standardParkingBoy.fetch(ticket);
        assertEquals(car, carResult1);
        assertNull(carResult2);
    }

    //case6 Given a parking lot,a car When the parking lot is no position, Then return null
    @Test
    public void should_return_null_when_parking_lot_no_position() {
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        standardParkingBoy.addParkingLot(parkingLot);
        standardParkingBoy.park(car1);
        Ticket ticket = standardParkingBoy.park(car2);
        assertNull(ticket);
    }

    //case7 Given a parking lot,a car When the fetch with unrecognized ticket, Then print message "Unrecognized parking ticket".
    @Test
    public void should_print_message_when_fetch_a_cars_with_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Ticket wrongTicket = new Ticket(new Car("2"), 2, parkingLot);
        standardParkingBoy.addParkingLot(parkingLot);
        standardParkingBoy.fetch(wrongTicket);
        assertTrue(outputStream.toString().contains("Unrecognized parking ticket."));
    }

    //case8 Given a parking lot,a car When the fetch with used ticket, Then print message "Unrecognized parking ticket".
    @Test
    public void should_print_message_when_fetch_a_cars_with_used_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car("1");
        standardParkingBoy.addParkingLot(parkingLot);
        Ticket ticket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(ticket);
        standardParkingBoy.fetch(ticket);
        assertTrue(outputStream.toString().contains("Unrecognized parking ticket."));
    }

    //case9 Given a parking lot,a car When the parking lot is no position, Then print message No available position.
    @Test
    public void should_print_message_when_parking_lot_no_position() {
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        standardParkingBoy.addParkingLot(parkingLot);
        standardParkingBoy.park(car1);
        standardParkingBoy.park(car2);
        assertTrue(outputStream.toString().contains("No available position."));
    }

    //case10 Given two parking lot,three car When first the parking lot is no position, Then return null.
    @Test
    public void should_return_null_when_first_parking_lot_no_position() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Ticket ticket = new Ticket(car1, 1, parkingLot);
        Ticket ticket2 = new Ticket(car2, 1, parkingLot2);
        Ticket ticket3 = new Ticket(car3, 2, parkingLot2);

        standardParkingBoy.addParkingLot(parkingLot);
        standardParkingBoy.addParkingLot(parkingLot2);
        Ticket ticketResult = standardParkingBoy.park(car1);
        Ticket ticketResult2 = standardParkingBoy.park(car2);
        Ticket ticketResult3 = standardParkingBoy.park(car3);
        assertEquals(ticket, ticketResult);
        assertEquals(ticket2, ticketResult2);
        assertEquals(ticket3, ticketResult3);
    }

    //case11 Given two parking lot,three car When all parking lot is no position, Then print message "No available position."
    @Test
    public void should_print_message_when_all_parking_lots_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        standardParkingBoy.addParkingLot(parkingLot);
        standardParkingBoy.addParkingLot(parkingLot2);
        standardParkingBoy.park(car1);
        standardParkingBoy.park(car2);
        Ticket ticket = standardParkingBoy.park(car3);

        assertNull(ticket);
        assertTrue(outputStream.toString().contains("No available position."));
    }
}
