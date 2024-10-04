import java.util.*;

public class stackArray {
    private String[] s;
    private int counter = 0;

    public stackArray(int size) {
        s = new String[size];
        counter = 0;
    }

    public stackArray() {
        this(5); // Default stack size to 5
    }

    private boolean isEmpty() {
        return counter == 0;
    }

    private boolean isFull() {
        return counter == s.length;
    }

    public boolean push(String value) {
        if (!isFull()) {
            s[counter++] = value;
            return true;
        }
        return false;
    }

    public boolean pop() {
        if (!isEmpty()) {
            s[counter - 1] = null; // Nullify the value being popped
            counter--; // Decrease counter after nullifying
            return true;
        }
        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return s[counter - 1];
        }
        return null; // Return null if the stack is empty
    }

    public void displayStack() { // Changed method name to match your main class
        if (!isEmpty()) {
            System.out.println("Stack elements:");
            for (int i = counter - 1; i >= 0; i--) {
                System.out.println("[" + s[i] + "]");
            }
        } else {
            System.out.println("Error: the stack is empty.");
        }
    }
}
