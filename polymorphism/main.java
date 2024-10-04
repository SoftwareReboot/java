package polymorphism;

import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        try{
//option to choose between Credit card payment or Paypal payment
            System.out.println("------Payment Method------");
            System.out.println(" Press [1] for Credit Card Payment.");
            System.out.println(" Press [2] for Paypal Payment");
            int choice = scann.nextInt();
            scann.nextLine();

                if (choice == 1) {
//user input for Credit Card Payment
                    System.out.println(" Enter CardNumber: ");
                    int cardNumber = scann.nextInt();

                    System.out.println(" Enter Card Holder Name: ");
                    String name = scann.nextLine();

                    System.out.println(" Enter Expiration Date(MM/YY): ");
                    int expirationDate = scann.nextInt();

                    System.out.println(" Enter Card Verification Value (CVV): ");
                    String CVV = scann.nextLine();

                    CreditCardPayment ccp = new CreditCardPayment(cardNumber, name, expirationDate, CVV);
                    ccp.processPayment();
                }

                if (choice == 2) {
                    System.out.println(" Enter Email: ");
                    String email = scann.nextLine();

                    PayPalPayment ppp = new PayPalPayment(email);
                    ppp.processPayment();
                }
                    
        }catch(java.util.InputMismatchException e){
            System.out.println(" Error, please input valid choice.");
        }finally{
            scann.close();
            System.out.println(" Exited Program.");
        }
    }
}

