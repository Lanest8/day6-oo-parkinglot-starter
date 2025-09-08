package com.afs.parkinglot;

import java.util.stream.IntStream;

public class StandardParkingBoy {
    private ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        return IntStream.rangeClosed(1, this.parkingLot.getCapacity()).boxed()
                .filter(position -> this.parkingLot.getTicketCars().keySet().stream().noneMatch(ticket -> ticket.getPosition().equals(position)))
                .findFirst()
                .map(position -> {
                    Ticket ticket = new Ticket(car, position, this.parkingLot);
                    this.parkingLot.getTicketCars().put(ticket, car);
                    return ticket;
                })
                .orElseGet(() -> {
                    System.out.println("No available position.");
                    return null;
                });
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null || !this.parkingLot.getTicketCars().containsKey(ticket)) {
            System.out.println("Unrecognized parking ticket.");
        }
        return this.parkingLot.getTicketCars().remove(ticket);
    }
}
