package prep;

import java.util.ArrayList;

public class user {
    private ArrayList<book> borrowedBooks;
    private String name;
    private String userId;

   public user(String name, String userId){
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
   }

    public String getName(){
        return name;
    }

    public String getUserID(){
        return userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUserID(String userID){
        this.userId = userID;
    }

    //getter for the list of Borrowed books
    public ArrayList<book> getBorrowedBooks(){
        return borrowedBooks;
    }

    //method to add book in the arrayList
    public  void borrowBook(book book){
        borrowedBooks.add(book);
    }

    public void returnBook(book book){
        borrowedBooks.remove(book);
    }

    public void showBorrowedBook(){
        System.out.println(" List of Borrowed Books: ");
            for(int i = 0; i < borrowedBooks.size(); i++ ){
                System.out.println(borrowedBooks.get(i));
            }
    }

    
}
