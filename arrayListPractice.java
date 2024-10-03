import java.util.*;

public class arrayListPractice {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String choice = "";

        try{
            System.out.println(" Enter Size of the ArrayList: ");
            int size = scann.nextInt();
            ArrayList<String> Songs = new ArrayList<>();
            scann.nextLine();
    
            do{
                System.out.println("------Music Playlist---------------------------");
                System.out.println(" Press [1] to add Songs to Playlist");
                System.out.println(" Press [2] to remove Song from Playlist");
                System.out.println(" Press [3] to Display Songs From Playlist");
                System.out.println(" Press [4] to Play a Song From Playlist");
                System.out.println(" Press [5] to Clear Songs From Playlist");
                System.out.println(" Press [x] to Exit");
                System.out.println("----------------------------------------------------------");
    
                System.out.print(" Enter your choice: ");
                choice = scann.nextLine();
              
    
                    switch (choice) {
                        case "1":// add songs using .add method
                          if (Songs.size() < size) {
                            System.out.println(" Enter Song Title: ");
                            String input = scann.nextLine();
                            Songs.add(input);
                            System.out.println(input + " Successfully added to Playlist.");
                          }else{
                            System.out.println(" Error, Playlist is Full cannot add Song.");
                          }
                            break;
                        case "2":// removing songs using .remove method
                          System.out.println(" Enter Song to be removed from Playlist: ");
                          String removedSongs = scann.nextLine();
                            if (Songs.remove(removedSongs)) {
                                System.out.println(removedSongs + " Successfully removed from Playlist.");
                            }else
                                System.out.println(" Error, Song not Found in Playlist.");
                                break;
                        case "3"://displaying songs in playlist using .get method
                           if (Songs.size() == 0) {
                                System.out.println(" The Playlist is Empty.");
                           }else{
                                System.out.println(" Songs in Playlist: ");
                                for(int i = 0; i < Songs.size(); i ++){
                                    System.out.println("[" + Songs.get(i) + "]");
                                }
                           }
                            break;
                        case "4":
                        System.out.println(" Enter the Index of the Song to Play: ");
                        int index = scann.nextInt();
                        scann.nextLine();
                            if (index >=0 && index < Songs.size()) {
                                System.out.println(" Now Playing: " + Songs.get(index));
                            }else
                                System.out.println(" Error cannot Find Song.");
                            break;
                        case "5"://clearing the songs from playlist using .clear method
                            Songs.clear();
                            System.out.println(" Playlist Cleared.");
                            break;
                        case "x":
                            System.out.println(" Exiting Program...Thank you for Using Music Playlist.");
                            break;
                        default:
                            System.out.println(" Invalid Choice Please Try Again.");
                            break;
                    }
            }while(!choice.equals("x"));
        }catch(InputMismatchException e){
            System.out.println(" Error, please input a number.");
        }finally{
            scann.close();
            System.out.println(" Program Ended.");
        }
    }    
}
