package com.parkingLot.strategy;

import java.util.PriorityQueue;

/**
 * Strategy for allocating the nearest available parking slot.
 * Uses a PriorityQueue to always allocate the lowest-numbered free slot.
 */
public class NearestSeatAllocationStrategy implements SlotAllocationStrategy {

    /**
     * Priority queue to store available slot numbers in ascending order.
     */
    private PriorityQueue<Integer> availableSlots;

    /**
     * Initializes the strategy with the given parking lot capacity.
     * All slots from 1 to capacity are marked as available.
     *
     * @param capacity the total number of slots in the parking lot
     */
    @Override
    public void initialize(int capacity) {
        availableSlots = new PriorityQueue<>();
        for (int i = 1; i <= capacity; i++) {
            availableSlots.offer(i);
        }
    }

    /**
     * Returns and removes the nearest available slot.
     *
     * @return the slot number, or null if no slots are available
     */
    @Override
    public Integer getNextAvailableSlot() {
        return availableSlots.poll();
    }

    /**
     * Marks a slot as free and adds it back to the available slots.
     *
     * @param slot the slot number to mark as free
     */
    @Override
    public void markSlotFree(int slot) {
        availableSlots.offer(slot);
    }

    /**
     * Checks if there are any available slots.
     *
     * @return true if at least one slot is available, false otherwise
     */
    @Override
    public boolean hasAvailableSlots() {
        return !availableSlots.isEmpty();
    }
}