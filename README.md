# Parking Lot System

This project is a simple Parking Lot Management System implemented in Java. It allows users to create a parking lot, park cars, leave parking slots, and manage parking operations using a command-based interface.

## Features
- Create a parking lot with a specified number of slots
- Park cars in the nearest available slot
- Leave a parking slot
- Extensible command pattern for adding new operations
- Slot allocation strategies (e.g., nearest slot)

## Project Structure
```
src/main/java/com/parkingLot/
  ParkingSystem.java                # Entry point for the parking lot system
  command/                         # Command pattern implementations
    Command.java
    CreateParkingLotCommand.java
    LeaveCommand.java
    ParkCarCommand.java
  factory/
    CommandFactory.java            # Factory for creating command instances
  manager/
    ParkingLotManager.java         # Core logic for parking lot management
  model/
    Car.java
    ParkingLot.java
  strategy/
    NearestSeatAllocationStrategy.java
    SlotAllocationStrategy.java
```

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven (for building the project)

### Build
```
mvn clean install
```

### Run
You can run the main class to start the parking lot system:
```
java -cp target/classes org.self.Main
```

## Usage
The system accepts commands such as:
- `create_parking_lot <number_of_slots>`
- `park <registration_number> <color>`
- `leave <slot_number>`

Example:
```
create_parking_lot 6
park KA-01-HH-1234 White
leave 4
```

## Extending Functionality
To add new commands, implement the `Command` interface in the `command` package and register it in the `CommandFactory`.

## License
This project is licensed under the Learning deployment License - see the LICENSE file for details.

