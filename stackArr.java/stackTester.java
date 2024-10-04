import java.util.Scanner;

public class stackTester {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in); 
        String choice = "";

        System.out.println("Enter size");
        int size = scann.nextInt();
        stackArray SA = new stackArray(size);
        scann.nextLine(); // Consume the leftover newline after nextInt()

        do {
            System.out.println("------Welcome to Stack Menu---------------------------");
            System.out.println(" Press [1] to push");
            System.out.println(" Press [2] to pop");
            System.out.println(" Press [3] to peek");
            System.out.println(" Press [4] to display stack");
            System.out.println(" Press [x] to Exit");
            System.out.println("----------------------------------------------------------");

            System.out.print(" Enter your choice: ");
            choice = scann.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter value to push to stack: ");
                    String value = scann.nextLine(); // Get user input for the value
                    if (SA.push(value)) {
                        System.out.println("Value pushed: " + value);
                    } else {
                        System.out.println("Stack is full. Cannot push.");
                    }
                    break;
                case "2":
                    if (SA.pop()) {
                        System.out.println("Value popped.");
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;
                case "3":
                    String topValue = SA.peek();
                    if (topValue != null) {
                        System.out.println("Current top value: " + topValue);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case "4":
                    SA.displayStack();
                    break;
                case "x":
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (!choice.equals("x"));
    }
}
