package encap;

import java.util.*;

public class main {
    public static void main(String[] args) {
      Scanner scann = new Scanner(System.in);
      try{
// prompting the user for Dimension
        System.out.println(" Enter Width of the Rectangle: ");
            double width = scann.nextDouble();

        System.out.println(" Enter Height of the Rectangle: ");
            double height = scann.nextDouble();

        rectangle rect = new rectangle(width, height);

// calculating and displaying area and perimeter
        System.out.println(" The area of the rectangle is: " + rect.calculateArea());
        System.out.println(" The perimeter of the rectangle is: " + rect.calculatePerimeter());

      }catch(InputMismatchException e){
            System.out.println(" Error, Please input a Number.");
      }finally{
        scann.close();
        System.out.println(" Exited Program.");
      }  
       
    }
}
