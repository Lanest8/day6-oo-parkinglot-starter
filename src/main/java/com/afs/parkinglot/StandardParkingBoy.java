package com.afs.parkinglot;

import java.util.*;
import java.util.stream.IntStream;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy() {
    }

    public Ticket park(Car car) {
        Optional<ParkingLot> availableLot = parkingLots.stream()
                .filter(lot -> !lot.isFull())
                .findFirst();
        if (availableLot.isEmpty()) {
            System.out.println("No available position.");
            return null;
        }
        ParkingLot parkingLot = availableLot.get();
        return IntStream.rangeClosed(1, parkingLot.getCapacity()).boxed()
                .filter(position -> parkingLot.getTicketCars().keySet().stream().noneMatch(ticket -> ticket.getPosition().equals(position)))
                .findFirst()
                .map(position -> {
                    Ticket ticket = new Ticket(car, position, parkingLot);
                    parkingLot.getTicketCars().put(ticket, car);
                    return ticket;
                })
                .orElseGet(() -> {
                    System.out.println("No available position.");
                    return null;
                });
    }

    public Car fetch(Ticket ticket) {
        if (parkingLots.contains(ticket.getParkingLot())) {
            parkingLots.stream()
                    .filter(lot -> lot.equals(ticket.getParkingLot()))
                    .findFirst()
                    .ifPresent(parkingLot -> {
                        if (!parkingLot.getTicketCars().containsKey(ticket)) {
                            System.out.println("Unrecognized parking ticket.");
                        }
                    });
        }
        return ticket.getParkingLot().getTicketCars().remove(ticket);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }
}
