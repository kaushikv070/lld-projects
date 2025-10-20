package com.parkingLot.command;

import com.parkingLot.manager.ParkingLotManager;

/**
 * Command to park a car in the parking lot.
 * Expects args[0] as registration number and args[1] as color.
 */
public class ParkCarCommand implements Command {
    @Override
    public void execute(String[] args) {
        // Implementation for parking a car
        ParkingLotManager.getInstance().park(args[0], args[1]);
    }
}
