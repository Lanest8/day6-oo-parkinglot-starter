package com.afs.parkinglot;

import java.util.*;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy() {
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .filter(lot -> !lot.isFull())
                .findFirst()
                .map(lot -> lot.park(car))
                .orElseGet(() -> {
                    System.out.println("No available position.");
                    return null;
                });
    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLot = ticket.getParkingLot();
        if (!parkingLots.contains(parkingLot)) {
            System.out.println("Unrecognized parking ticket.");
            return null;
        }
        return parkingLot.fetch(ticket);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }
}
