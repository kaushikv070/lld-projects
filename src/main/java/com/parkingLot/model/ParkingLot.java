package com.parkingLot.model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity;
    private final Map<Integer, Car> occupiedSlots = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public void park(int slot, Car car) {
        if (occupiedSlots.size() >= capacity) {
            throw new IllegalStateException("Parking lot is full");
        }
        occupiedSlots.put(slot, car);
    }

    public void leave(int slot) {
        occupiedSlots.remove(slot);
    }

    public boolean isSlotOccupied(int slot) {
        return occupiedSlots.containsKey(slot);
    }

    public boolean isCarAlreadyParked(String registrationNo) {
        return occupiedSlots.values().stream()
                .anyMatch(car -> car.getRegistrationNumber().equals(registrationNo));
    }



}
