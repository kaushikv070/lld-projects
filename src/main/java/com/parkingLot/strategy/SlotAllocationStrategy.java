package com.parkingLot.strategy;

public interface SlotAllocationStrategy {
    void initialize(int capacity);
    Integer getNextAvailableSlot();
    void markSlotFree(int slot);
    boolean hasAvailableSlots();

}
