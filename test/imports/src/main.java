
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;


public class main {
    public static void main(String[] args) {
       HashMap<String, String> acc = readFile(); 
        //jframe
        JFrame frame = new JFrame("Sign In");
        frame.setSize(558, 412);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        ImageIcon image = new ImageIcon("iconidea.jpg");
        frame.setIconImage(image.getImage());
        
        try {
            Image logo = ImageIO.read(new File("logo.png"));
            frame.setIconImage(logo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //jpanel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        //title lable
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setForeground(Color.WHITE);
        label.setBounds(220, 20, 200, 40);
        panel.add(label);

        //logins
        
        //user
        JLabel userLabel = new JLabel("Email or mobile number");
        userLabel.setBounds(70, 100, 200, 30);
        userLabel.setForeground(Color.white);
        panel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(70, 130, 400, 30);
        panel.add(userField);
        
        //password
        JLabel Passwordlabel = new JLabel("Password");
        Passwordlabel.setBounds(70, 170, 200, 30);
        Passwordlabel.setForeground(Color.WHITE);
        panel.add(Passwordlabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(70, 200, 400, 30);
        panel.add(passField);
        
        //log in button
        JButton button = new JButton("Sign In");
        button.setBounds(70, 250, 400, 40);
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(button);
        
        frame.add(panel);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userField.getText();
                String password = new String(passField.getPassword());

                if (acc.containsKey(userName)) {
                    if (acc.get(userName).equals(password)) {
                        JOptionPane.showMessageDialog(frame,  "Log In Successfully");
                        frame.dispose();
                        new PlayListGui();
                    }else{
                        JOptionPane.showMessageDialog(frame,  "InCorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
         JButton signupButton = new JButton("Sign Up");
         signupButton.setBounds(70, 300, 400, 40);
         signupButton.setBackground(Color.DARK_GRAY);
         signupButton.setForeground(Color.WHITE);
         signupButton.setFont(new Font("Arial", Font.BOLD, 18));
         panel.add(signupButton);
         
         signupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, " Signing Up....");
                new Signup();
                frame.setVisible(false);
                
            }
            
        });
          
    }

    static HashMap<String, String> readFile(){
        HashMap<String, String> acc = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Joseph\\Desktop\\uwa\\codingBit(java)\\test\\imports\\src\\userInfo.txt"))) {
            String data;
            while ((data = br.readLine())!= null) {
                String pass = br.readLine();
                if (pass != null) {
                    acc.put(data, pass);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
