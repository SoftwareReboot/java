import java.awt.Color;
import java.util.HashMap;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signup {
    private static final String FILE_PATH = "C:\\Users\\Joseph\\Desktop\\userInfo.txt";
    private static HashMap<String, String> database = new HashMap<>();
    public static void main(String[] args) {
                //frame
                JFrame frame = new JFrame("Sign Up");
                frame.setSize(558, 500);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.BLACK);
        
                //panel
                JPanel panel = new JPanel();
                panel.setLayout(null);
                panel.setBackground(Color.BLACK);
        
                //title
                JLabel label = new JLabel("Sign Up");
                label.setFont(new Font("Arial", Font.BOLD, 36));
                label.setForeground(Color.WHITE);
                label.setBounds(200, 20, 200, 40);
                panel.add(label);
        
                //Email sign UP
                JLabel emailLabel = new JLabel("Email:");
                emailLabel.setForeground(Color.WHITE);
                emailLabel.setBounds(70, 100, 200, 30);
                panel.add(emailLabel);
        
                JTextField emailField = new JTextField();
                emailField.setBounds(70, 130, 400, 30);
                panel.add(emailField);
                
                //Password Sign up
                JLabel passwordLabel = new JLabel("Password:");
                passwordLabel.setForeground(Color.WHITE);
                passwordLabel.setBounds(70, 170, 200, 30);
                panel.add(passwordLabel);
        
                JPasswordField passwordField = new JPasswordField();
                passwordField.setBounds(70, 200, 400, 30);
                panel.add(passwordField);
        
                JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
                confirmPasswordLabel.setForeground(Color.WHITE);
                confirmPasswordLabel.setBounds(70, 240, 200, 30);
                panel.add(confirmPasswordLabel);
        
                JPasswordField confirmPasswordField = new JPasswordField();
                confirmPasswordField.setBounds(70, 270, 400, 30);
                panel.add(confirmPasswordField);
                
                //Register Button
                JButton registerButton = new JButton("Register");
                registerButton.setBounds(70, 330, 400, 40);
                registerButton.setBackground(Color.RED);
                registerButton.setForeground(Color.WHITE);
                registerButton.setFont(new Font("Arial", Font.BOLD, 18));
                panel.add(registerButton);
        
                registerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String email = emailField.getText();
                        String password = new String(passwordField.getPassword());
                        String confirmPassword = new String(confirmPasswordField.getPassword());
        
                        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (!password.equals(confirmPassword)) {
                            JOptionPane.showMessageDialog(frame, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });
        
                frame.add(panel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        
            private static void writeToFile(String email, String password){
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                    bw.write(email + ":" + password);
                    bw.newLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}
