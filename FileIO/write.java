package FileIO;
import java.io.FileWriter;
import java.io.IOException;

public class write {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("C:/Users/Joseph/Desktop/Secret_Message.txt")){
            
            writer.write("This is Doggy\nDoggy is humping Friend\n    __/o \\_\r\n" + //
                                "     \\____  \\\r\n" + //
                                "         /   \\\r\n" + //
                                "   __   //\\   \\\r\n" + //
                                "__/o \\-//--\\   \\_/\r\n" + //
                                "\\____  ___  \\  |\r\n" + //
                                "     ||   \\ |\\ |\r\n" + //
                                "    _||   _||_||");
            
            //notify the user if it was executed Successfully
            System.out.println(" Data Written Successfuly.");

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
