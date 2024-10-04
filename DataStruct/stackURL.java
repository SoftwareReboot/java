package DataStruct;
import java.util.Scanner;

public class stackURL {
    static Scanner scann = new Scanner(System.in);
    static String[] stack = new String[5];
    static int counter = 0;

    public static void main(String[] args) {
        int choice;

        do {
            menu();
            choice = scann.nextInt();
            scann.nextLine(); // Consume newline after nextInt

            switch (choice) {
                case 1:
                    System.out.println("Enter URL to push: ");
                    push(scann.nextLine());
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
                    System.out.println("Program Ended Successfully.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);
    }

    static boolean isEmpty() {
        return counter == 0;
    }

    static boolean isFull() {
        return counter == stack.length;
    }

    static void push(String Url) {
        if (!isFull()) {
            stack[counter] = Url;
            counter++; // Increment the counter
            System.out.println("Successfully added to stack.");
        } else {
            System.out.println("Stack is Full");
        }
    }

    static void pop() {
        if (!isEmpty()) {
            counter--; // Decrement the counter
            System.out.println("Successfully removed from stack.");
        } else {
            System.out.println("Error: Stack is Empty");
        }
    }

    static void peek() {
        if (!isEmpty()) {
            System.out.println("Top URL: " + stack[counter - 1]); // Corrected index
        } else {
            System.out.println("Stack is Empty");
        }
    }

    static void displayDetails() {
        if (!isEmpty()) {
            System.out.println("URLs in stack:");
            for (int i = counter - 1; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        } else {
            System.out.println("Stack is Empty");
        }
    }

    static void menu() {
        System.out.println("--------Browsing History--------");
        System.out.println("Press [1] to Push URL to stack.");
        System.out.println("Press [2] to Pop URL from stack.");
        System.out.println("Press [3] to Peek URL from stack.");
        System.out.println("Press [4] to Display URLs in stack.");
        System.out.println("Press [5] to close program.");
        System.out.println("Enter Your Choice: ");
    }
}
