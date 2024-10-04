package Inheretance;
import java.util.Scanner;

public class dumpTruck extends vehicle {
//Unique Attributes of Dump Truck
    private int dumpCapacity;
    private String loadingStatus;
//----------------------------------------
    Scanner scann = new Scanner(System.in);

//Constructor: initialize dumpTruck objects
public dumpTruck(String brand, String color, int fuel, int speed) {
    super(brand, speed, fuel, color);
    this.dumpCapacity = dumpCapacity;
    this.loadingStatus = loadingStatus;
}

 // Override displayDetails method to include Dumping Capacity and loading status
 public void displayDetails() {
    super.displayDetails();
    System.out.println(" Dumping Capacity: " + dumpCapacity + " Tons " );
    System.out.println(" Loading Status: " + loadingStatus);
}
// getter methods for both dumpingCapacity and loadingStatus
    public int getDumpingCapacity(){
        return dumpCapacity;
    }

    public String getLoadingStatus(){
        return loadingStatus;
    }

//method for dumping capacity
    public void dumpCapacity(){
        System.out.println(" Enter amount of Debri(s) to Dump: " + dumpCapacity + " Tons ");
        dumpCapacity = scann.nextInt();
            if (dumpCapacity > 0 && dumpCapacity <= 400) {
                loadingStatus = " Loaded ";
                System.out.println(" Succfully Hauled: "  + dumpCapacity + " Tons ");
            }else{
                System.out.println(" Error Input valid Option.");
            }
    }
//method for loading status
    public void loadingStatus() {
    if (dumpCapacity > 0) {
        System.out.println("Unloading " + dumpCapacity + " Tons...");
        dumpCapacity = 0; // Reset dump capacity after unloading
        loadingStatus = "Empty"; // Update loading status
        System.out.println("Successfully Unloaded. Current Status: " + loadingStatus);
    } else {
        System.out.println("Error: The dump truck is already empty.");
        }
    }
}