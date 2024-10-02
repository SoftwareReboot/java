package ooprog;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Inventory invent = new Inventory();

        //diri ta ga add ug products
        
        //case 1: Adding perishable products
        System.out.println(" Case 1: ");
        perishableProduct chickenBreast = new perishableProduct("CB-17#", " Chicken Breast", 20, 64.50, "2024-10-30");
        invent.addProduct(chickenBreast);
        
        //case 2: Adding non-Perishable Products
        System.out.println(" Case 2: ");
        nonPerishableProduct cannedTuna = new nonPerishableProduct("CT-515#", " Century Tuna", 50, 20.50, 3);
        invent.addProduct(cannedTuna);

        // diri ta mag update sa stock dapat within limits ra.
            System.out.println(" Case 3: ");
            chickenBreast.updateStock(60);
        // ga update stock ta diri kanang ni lapas konohay.
            System.out.println(" Case 4: ");
            try{
                chickenBreast.updateStock(54);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        
        // remove ta ug products kanang success.
            System.out.print(" Case 5: ");
            try {
                invent.removeProduct("CB-17#");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        // nag remove ta subra sa avail stack
            System.out.println(" Case 6:");
            try {
                chickenBreast.updateStock(-60);
            } catch (InsufficientStockException e) {
                System.out.println(e.getMessage());
            }
        //Invalid Quantity Update ta diri dapita 
            System.out.println(" Case 7: ");
            try {
                chickenBreast.setQuantity(-10);
            } catch (InvalidQuantityException e) {
                System.out.println(e.getMessage());
            }
    }
}
