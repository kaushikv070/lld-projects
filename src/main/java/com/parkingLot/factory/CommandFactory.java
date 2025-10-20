package com.parkingLot.factory;

import com.parkingLot.command.Command;

public class CommandFactory {
    public static Command getCommand(String commandName) {
        // Implementation to return the appropriate Command instance based on commandName
        // This is a placeholder implementation; actual implementation would involve more logic
        return switch (commandName.toLowerCase()) {
            case "create_parking_lot" -> new com.parkingLot.command.CreateParkingLotCommand();
            case "park" -> new com.parkingLot.command.ParkCarCommand();
            case "leave" -> new com.parkingLot.command.LeaveCommand();
            // Add more cases for other commands
            default -> throw new IllegalArgumentException("Unknown command: " + commandName);
        };
    }
}
