package FileIO;

import java.io.File;

public class makedirectory {
    public static void main(String[] args) {
        File directory = new File("Secret_Message.txt");

            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println(" Directory Created.");
                }else{
                    System.out.println(" Failed to Create Directory");
                }
            }else{
                System.out.println(" Directory Exists.");
            }
    }
}
