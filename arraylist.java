import java.util.*;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("jamil francis bayot");
        students.add("joshua jamisola");
        students.add("jude ebarita");

        students.remove(0);
        students.clear();
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
    }    
}
