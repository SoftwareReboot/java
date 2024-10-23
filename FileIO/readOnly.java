package FileIO;

import java.io.FileReader;
import java.io.IOException;

public class readOnly {
    public static void main(String[] args) {
        try{
            FileReader reader = new FileReader("C:/Users/Joseph/Desktop/Secret_Message.txt");
            int data = reader.read();
            while(data != -1){
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
