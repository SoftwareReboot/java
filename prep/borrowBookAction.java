package prep;

public class borrowBookAction  extends libraryAction{
    private user user;
    private book book;

    public borrowBookAction(user user, book book){
        this.user = user;
        this.book = book;
    }


    @Override
      public void execute(){
        try {
            user.borrowBook(book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      }
}
