package com.parkingLot.command;

import com.parkingLot.manager.ParkingLotManager;
import com.parkingLot.strategy.SlotAllocationStrategy;

public class CreateParkingLotCommand implements Command {
    @Override
    public void execute(String[] args) {
        // Implementation for creating a parking lot
        int capacity = Integer.parseInt(args[0]);
        SlotAllocationStrategy strategy = null;
        // here args can have info about strategy type if needed default we have used NearestSlotAllocationStrategy
        if (args.length > 1) {
            String strategyType = args[1];
            // You can add more strategies here based on strategyType
//            switch (strategyType) {
//                case "Nearest":
//                    strategy = new com.parkingLot.strategy.NearestSlotAllocationStrategy();
//                    break;
//                case "Random":
//                    strategy = new com.parkingLot.strategy.RandomSlotAllocationStrategy();
//                    break;
//                default:
//                    strategy = new com.parkingLot.strategy.NearestSlotAllocationStrategy();
//                    break;
//            }
        } else {
            strategy = new com.parkingLot.strategy.NearestSeatAllocationStrategy();
        }
        ParkingLotManager.getInstance().initializeParkingLot(capacity, strategy);
    }
}
