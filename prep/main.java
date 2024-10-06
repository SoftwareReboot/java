package prep;
import java.util.*;

public class main {
    public static void main(String[] args) {
        
        // Adding Books
        book book1 = new book( "No Longer Human", " Osamu Dazai", " NLM-067", true);
        book book2 = new book(" Double Suicide", " Osamu Dazai", " DS-092", true);
        book book3 = new book(" Game Of Thrones", " George R.R Martin", "GOT-287", true);
        book book4 = new book(" House Of Dragons", " George R.R Martin", " HOD-256", false);


        // Adding Users
        student stud = new student(" Joshua Miguel G. Jamisola", "23798424");
        teacher teach = new teacher(" Jewel Cedrick", " CD -  24165456");

        System.out.println(" Case 3: Borrwing books for Student(No Errors): ");
        libraryAction borrow1 = new borrowBookAction(stud, book3);
        libraryAction borrow3 = new borrowBookAction(stud, book2);
        libraryAction borrow2 = new borrowBookAction(stud, book1);
        borrow1.execute();
        borrow2.execute();
        borrow3.execute();    
    }
}
