package Inheretance;

public class protoMain {
    public static void main(String[] args) {
     Car cr = new Car("Toyota Supra MK-4", "Ash Grey", 52, 80);
     BackHoe bh = new BackHoe("Komatsu PC30MR-5", "Yellow", 250, 131);
     dumpTruck dt = new dumpTruck(" Komatsu 980E-5", "Yellow", 4542, 40);
     /*cr.changeGear();
     cr.setPassengerSize(2);
     cr.displayDetails();
     cr.stop();
     cr.displayDetails();
    
     /*bh.move();
     bh.startDigging();
     bh.fillBucketCapacity();
     bh.stop();
     bh.displayDetails();*/

     dt.move();
     dt.dumpCapacity();
     dt.displayDetails();
     dt.loadingStatus();
     dt.displayDetails();
     dt.stop();
     
    }   
}
