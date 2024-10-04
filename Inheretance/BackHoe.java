package Inheretance;
import java.util.Scanner;

public class BackHoe extends vehicle {
    // unique attributes of backhoe
    private int diggingDepth = 0;
    private int bucketCapacity = 0;

    // Constructor
    public BackHoe(String backhoeModel, String backhoeColor, int backhoeSpeed, int backhoeFuel) {
        super(backhoeModel, backhoeSpeed, backhoeFuel, backhoeColor);
    }

    //Override displayDetails method to include Digging Depth and Bucket Capacity
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Digging Depth: " + diggingDepth + " Feet");
        System.out.println("Bucket Capacity: " + bucketCapacity + " Kilograms");
    }

    // Getter methods
    public int getDiggingDepth() {
        return diggingDepth;
    }

    public int getBucketCapacity() {
        return bucketCapacity;
    }

    // Method to start digging
    void startDigging() {
        Scanner scann = new Scanner(System.in);
        System.out.print("Enter depth to dig out (Feet): ");
        diggingDepth = scann.nextInt();
        scann.nextLine();
        
        if (diggingDepth > 0 && diggingDepth <= 15) {
            System.out.println("Started digging a depth of: " + diggingDepth + " Feet.");
        } else {
            System.out.println("Error: Exceeds digging depth limit.");
        }
    }

    // Method to fill the bucket with rubble
    void BucketCapacity() {
        Scanner scann = new Scanner(System.in);
        System.out.print("Enter amount of rubble to be stored (Kilograms): ");
        bucketCapacity = scann.nextInt();
        scann.nextLine();
        
        if (bucketCapacity > 0 && bucketCapacity <= 300) {
            System.out.println("Successfully stored rubble of " + bucketCapacity + " Kilograms.");
        } else {
            System.out.println("Error: Exceeds bucket capacity limit.");
        }
    }
}
