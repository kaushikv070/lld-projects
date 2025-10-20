package com.parkingLot;

import com.parkingLot.factory.CommandFactory;

import java.util.Scanner;

public class ParkingSystem {

    public static void main(String[] args) {

        ParkingSystem parkingSystem = new ParkingSystem();
        if (args.length == 0) {
            parkingSystem.startInteractiveMode();
        } else {
            parkingSystem.startFileMode(args[0]);
        }
    }

    private void startInteractiveMode() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            executeCommand(input);
            // Process the input command
        }
    }

    private void executeCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, parts.length - 1);

        CommandFactory.getCommand(command).execute(args);
    }



    private void startFileMode(String fileName) {

        // use bufferReader
        try (Scanner scanner = new Scanner(new java.io.File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                executeCommand(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }



}
