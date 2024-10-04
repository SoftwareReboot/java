package Inheretance;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Vehicle System ---");
            System.out.println("Press [1] to Display Car");
            System.out.println("Press [2] to Display Backhoe");
            System.out.println("Press [3] to Display DumpTruck");
            System.out.println("Press [4] to Exit");
            System.out.print("Enter Your Choice: ");
            int choice = scann.nextInt();
            scann.nextLine(); 

            switch (choice) {
            case 1:
                System.out.print("Enter Car Model: ");
                String carModel = scann.nextLine();
                System.out.print("Enter Car Color: ");
                String carColor = scann.nextLine();
                System.out.print("Enter Car Speed: ");
                int carSpeed = scann.nextInt();
                System.out.print("Enter Car Fuel Capacity: ");
                int carFuel = scann.nextInt();
                scann.nextLine(); 

                Car cr = new Car(carModel, carColor, carSpeed, carFuel);
                cr.setPassengerSize();
                cr.changeGear();
                cr.move();
                cr.displayDetails();
                cr.stop();
                cr.displayDetails();
                break;

            case 2:
                System.out.print("Enter Backhoe Model: ");
                String backhoeModel = scann.nextLine();
                System.out.print("Enter Backhoe Color: ");
                String backhoeColor = scann.nextLine();
                System.out.print("Enter Backhoe Speed: ");
                int backhoeSpeed = scann.nextInt();
                System.out.print("Enter Backhoe Fuel Capacity: ");
                int backhoeFuel = scann.nextInt();
                scann.nextLine(); 
            
                BackHoe bh = new BackHoe(backhoeModel, backhoeColor, backhoeFuel, backhoeSpeed);
                bh.move();
                bh.startDigging();
                bh.BucketCapacity();
                bh.stop();
                bh.displayDetails();
                break;
                
            case 3:
                System.out.print("Enter DumpTruck Model: ");
                String dumpTruckModel = scann.nextLine();
                System.out.print("Enter DumpTruck Color: ");
                String dumpTruckColor = scann.nextLine();
                System.out.print("Enter DumpTruck Speed: ");
                int dumpTruckSpeed = scann.nextInt();
                System.out.print("Enter DumpTruck Fuel Capacity: ");
                int dumpTruckFuel = scann.nextInt();
                scann.nextLine(); 
        
                dumpTruck dt = new dumpTruck(dumpTruckModel, dumpTruckColor, dumpTruckSpeed, dumpTruckFuel);
                dt.move();
                dt.dumpCapacity();
                dt.displayDetails();
                dt.loadingStatus();
                dt.displayDetails();
                dt.stop();
                break;

            case 4:
                exit = true;
                System.out.println("Exiting... Thank you for using Vehicle System");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scann.close();
    }
}
