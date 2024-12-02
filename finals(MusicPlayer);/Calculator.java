import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // JFrame and components
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    // Variables for calculation
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor to setup the GUI
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        // Set background color of frame to black
        frame.getContentPane().setBackground(Color.BLACK);

        // Set up the display field
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE); // White text on black background

        // Function buttons
        addButton = createButton("+");
        subButton = createButton("-");
        mulButton = createButton("*");
        divButton = createButton("/");
        decButton = createButton(".");
        equButton = createButton("=");
        delButton = createButton("Del");
        clrButton = createButton("Clr");
        negButton = createButton("(-)");

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
        }

        // Layout the calculator
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.BLACK); // Set background of panel to black

        // Add buttons to the grid
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        frame.setVisible(true);
    }

    // Helper function to create buttons with orange background
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(myFont);
        button.setFocusable(false);
        button.setBackground(Color.ORANGE);  // Set button background to orange
        button.setForeground(Color.WHITE);    // Set button text to white
        button.addActionListener(this);
        return button;
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new Calculator();
    }

    // Action event handling
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // Decimal button
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        // Operator buttons
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        // Equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        // Clear button
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }

        // Delete button (remove last character)
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        // Negative button (change sign)
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
