package prep;

public class teacher extends user{
    private int borrowLimit;

    public teacher(String name, String userID){
        super(name, userID);
        this.borrowLimit = 5;
    }

    public int getBorrowBookLimit(){
        return borrowLimit;
    }

    public boolean getCanBorrowMoreBook(){
        return  getBorrowedBooks().size() < borrowLimit;
    }

    public void borrowBook(book book){
       
        if (getBorrowedBooks().size() >= borrowLimit) {
            throw new BorrowLimitExceededException(" Teacher Can Only Borrow up to 5 Books only !");
        }
        if (!book.getIsAvailable()) {
            throw new BookNotAvailableException(" Book is not Available ! ");
        }
        getBorrowedBooks().add(book);
        book.setIsAvailable(false);
        System.out.println(getName() + " Borrowed: " + book.getTitle()+ " By: " + book.getAuthor());
    }
}
