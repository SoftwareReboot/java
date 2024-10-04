package Inheretance;
import java.util.Scanner;

public class Car extends vehicle {
    // unique attributes of Car
    private int passengerSize;
    private int gear;
    //------------------------------------
    Scanner scann = new Scanner(System.in);
    
    // Constructor: initialize car objects
    public Car(String brand, String color, int fuel, int speed) {
        super(brand, speed, fuel, color);
        this.gear = 1; // Default gear
        
    }

    // Override displayDetails method to include passenger size and the current gear
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Passenger Size: " + passengerSize + " Person(s)");
        System.out.println("Current Gear: " + gear);
    }

    // Getter method for passenger size
    public int getPassengerSize() {
        return passengerSize;
    }
    
    // Getter for current gear
    public int getGear() {
        return gear;
    }

    // Method for passenger size input
    public void setPassengerSize() {
        System.out.print("Enter Passenger Size: ");
        int inputSize = scann.nextInt(); // Use nextInt() to read an integer
            if (inputSize > 0) {
                this.passengerSize = inputSize;
                System.out.println("Passenger Size set to: " + this.passengerSize);
            } else {
                System.out.println("Passenger Size must be positive. Setting to default (1).");
                this.passengerSize = 1; // Default to 1 if invalid input
            }
        }

    // Method to change the gear
    public void changeGear() {
        System.out.print("Enter the desired gear (1-5): ");
        int newGear = scann.nextInt(); // Use nextInt for reading integer input
            if (newGear >= 1 && newGear <= 5) {
                gear = newGear;
                System.out.println("Gear changed to: " + gear);
            } else {
            System.out.println("Invalid gear. Please enter a value between 1 and 5.");
        }
    }
}