package com.parkingLot.command;

import com.parkingLot.manager.ParkingLotManager;

// Command to handle leaving a parking spot in the parking lot
public class LeaveCommand implements Command {
    @Override
    public void execute(String[] args) {
        // Implementation for leaving a parking spot
        ParkingLotManager.getInstance().leave(Integer.parseInt(args[0]));
    }
}