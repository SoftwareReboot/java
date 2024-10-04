package Inheretance;

public class vehicle {
    // Attributes
    private String brand;
    private int speed;
    private int fuel;
    private String color;

    // Constructor
    public vehicle(String brand,int fuel, int speed,String color) {
        this.brand = brand;
        this.speed = speed;
        this.fuel = fuel;
        this.color = color;
    }

    // Methods
    public void move() {
        System.out.println(brand + " is moving at " + speed + " km/h.");
        
        }
    

    public void stop() {
        System.out.println(brand + " has stopped.");
    }

    public void refuel(int amount) {
        fuel += amount;
        System.out.println(brand + " refueled by " + amount + " liters. Current fuel: " + fuel + " liters.");
    }

    public void displayDetails() {
        System.out.println(" ------ Vehicle Details ------ ");
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed + " (Km/h)");
        System.out.println("Fuel: " + fuel + " liters");


     
    }
}
