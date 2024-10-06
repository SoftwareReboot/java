package prep;

public class student extends user {
    private int borrowLimit;

    public student(String name, String userID){
        super(name, userID);
        this.borrowLimit = 3;
    }

    public int getBorrowBookLimit(){
        return borrowLimit;
    }

    public boolean getCanBorrowMoreBook(){
        return getBorrowedBooks().size() < borrowLimit;
    }

    public void borrowBook(book book){
       
        if (getBorrowedBooks().size() >= borrowLimit) {
            throw new BorrowLimitExceededException(" Student Can Only Borrow up to 3 Books only !");
        }
        if (!book.getIsAvailable()) {
            throw new BookNotAvailableException(" Book is not Available ! ");
        }
        getBorrowedBooks().add(book);
        book.setIsAvailable(false);
        System.out.println(getName() + " Borrowed: " + book.getTitle()+ " By: " + book.getAuthor());
    }
}