package DataStruct;
 import java.util.Scanner;

public class stack {
    static Scanner scann = new Scanner(System.in);
    static int [] stack = new int[5];
    static int counter = 0;
    public static void main(String[] args) {
      int choice = 0;

      do{
            menu();
            choice = scann.nextInt();

            switch (choice) {
                case 1:
                    System.out.print(" Enter Number to push to stack: ");
                    push(scann.nextInt());
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    displayDetails();
                    break;
                case 5:
                    System.out.println(" Exiting Program...");
            
                default:
                    break;
            }
      }while(choice != 5);
    }
    
    static boolean isEmpty(){
        if (counter == 0) {
            return true;
        }else
            return false;
    }

    static boolean isFull(){
        if (counter == stack.length) {
            return true;
        }else
            return false;
    }

    static void push(int num){
        if (!isFull()) {
            stack[counter] = num;
            counter ++;
            System.out.println(" Successfully added to stack.");
        }else
            System.out.println(" Error, Stack is Full");
    }

    static void pop(){
        if (!isEmpty()) {
            stack[counter - 1] = 0;
            counter --;
            System.out.println(" Successfully removed from Stack.");
        }else   
            System.out.println(" Error, Stack is Empty.");
    }

    static void peek(){
        if (!isEmpty()) {
            System.out.println(stack[counter - 1]);
        }else
            System.out.println(" Stack is Empty.");
    }

    static void menu(){
        System.out.println("------Welcome to Stack of Books---------------------------");
            System.out.println(" Press [1] to push");
            System.out.println(" Press [2] to pop");
            System.out.println(" Press [3] to peek");
            System.out.println(" Press [4] to display stack");
            System.out.println(" Press [5] to Exit");
            System.out.println("----------------------------------------------------------");

            System.out.print(" Enter your choice: ");
    }

    static void displayDetails(){
        if (!isEmpty()) {
            for(int i = counter - 1; i >=0; i--){
                System.out.println(stack[i] + " ");
            }
        }else
            System.out.println(" Stack is Empty.");
    }
}
