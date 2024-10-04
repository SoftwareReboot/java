package inheritanceException;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        try{

// prompting the user input for the circle
            System.out.println(" Enter the Radius of the Circle: ");
            double radius = scann.nextDouble();
            Circle cir = new Circle(radius);
            System.out.println(" Area of the Circle: " + cir.area());

// prompting the user input for the square
            System.out.println(" Enter the Sides of the Square: ");
            double sides = scann.nextDouble();
            Square squ = new Square(sides);
            System.out.println(" Area of the Square: " + squ.area());
        }catch(InputMismatchException e){
            System.out.println(" Error, please input a Number.");
        }finally{
            scann.close();
            System.out.println(" Exited Program");
        }
    }    
}
