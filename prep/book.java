package prep;

public class book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;
    public int getAuthor;

    public book(String title, String author, String ISBN, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setIsbn(String ISBN){
        this.ISBN = ISBN;
    }

    public void setIsAvailable(boolean isAvailable){
        isAvailable = isAvailable;
    }

   

}
