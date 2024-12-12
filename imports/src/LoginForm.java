import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginForm {
    private String filepath = "C:\\Users\\Joseph\\Desktop\\uwa\\codingBit(java)\\test\\imports\\src\\userinfo.txt";
    public HashMap<String, String> readFile() {
        HashMap<String, String> accounts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String user;
            while ((user = br.readLine()) != null) {
            String pass = br.readLine();
                if (pass != null) {
                    accounts.put(user, pass);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public void writeToFile(HashMap<String, String> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey());   // Write the key
                writer.newLine();               // New line after key
                writer.write(entry.getValue()); // Write the value
                writer.newLine();               // New line after value
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public static void main(String[] args) {
        
      
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);

        
    }
}   

