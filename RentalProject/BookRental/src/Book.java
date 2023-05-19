import java.util.Date;

public class Book extends Item {

    private String author;
    private String publisher;

    public Book(Integer iD, String title, String genre, Date releaseDate,String author,String publisher, RentalStore rentalStore) {
        super(iD, title, genre, releaseDate,rentalStore);
        this.author = author;
        this.publisher = publisher;
    }    
   
    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }


    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
