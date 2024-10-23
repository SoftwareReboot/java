package FileIO;

import java.io.File;

public class relativeToAbsolute {
    public static void main(String[] args) {
        File file = new File("Desktop/Secret_Message.txt");

        if (!file.exists()) {
            System.out.println(" File name: " + file.getName());
            System.out.println(" Absolute path: " + file.getAbsolutePath());
            System.out.println(" Parent directory: " + file.getAbsoluteFile().getParent());

            String separator = file.separator.equals("\\") ? "\\\\" : file.separator;

            String[] pathElements = file.getAbsolutePath().split(separator);

            for(int i = 0; i < pathElements.length; i++){
                System.out.println(i+1 + " " + pathElements[i]);
            }
            System.out.println(" Number of paths(Including File): " + pathElements.length);

        }else{
            System.out.println(" File Not Found.");
        }
    }
}
