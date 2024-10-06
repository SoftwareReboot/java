package prep;

public class returnBookAction  extends libraryAction{
        private user user;
        private book book;
    
    public returnBookAction(user user, book book){
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
       user.returnBook(book);
        
    }

    
}
