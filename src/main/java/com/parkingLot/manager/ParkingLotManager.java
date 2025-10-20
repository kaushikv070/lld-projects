package com.parkingLot.manager;

import com.parkingLot.model.ParkingLot;
import com.parkingLot.strategy.SlotAllocationStrategy;

public class ParkingLotManager {

    private static ParkingLotManager INSTANCE;
    private ParkingLot parkingLot;
    private SlotAllocationStrategy strategy;

    public static synchronized ParkingLotManager getInstance() {
       if (INSTANCE == null) {
           INSTANCE = new ParkingLotManager();
       }
       return INSTANCE;
    }

    public void initializeParkingLot(int capacity, SlotAllocationStrategy strategy) {
        this.strategy = strategy;
        this.strategy.initialize(capacity);
        this.parkingLot = new ParkingLot(capacity);
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void park(String registrationNo, String color) {
        if (!strategy.hasAvailableSlots()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        if (parkingLot.isCarAlreadyParked(registrationNo)) {
            System.out.println("Car with registration number " + registrationNo + " is already parked");
            return;
        }
        Integer slot = strategy.getNextAvailableSlot();
        var car = new com.parkingLot.model.Car(registrationNo, color);
        parkingLot.park(slot, car);
        System.out.println("Allocated slot number: " + slot);
    }

    public void leave(int slot) {
        if (!parkingLot.isSlotOccupied(slot)) {
            System.out.println("Slot number " + slot + " is already free");
            return;
        }
        parkingLot.leave(slot);
        strategy.markSlotFree(slot);
        System.out.println("Slot number " + slot + " is free");
    }

}
