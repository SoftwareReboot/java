import java.io.*;
import javazoom.jl.player.Player;

public class audio {
    public static void main(String[] args) {
        try {
            Player player = new Player(new FileInputStream(new File("C:\\Users\\Joseph\\Downloads\\Juice WRLD - Lucid Dreams (Official Music Video).mp3")));
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
} 