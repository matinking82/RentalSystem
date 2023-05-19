import java.util.Date;

public class Game extends Item {
    
    private String platform;
    private String publisher;

    public Game(Integer iD, String title, String genre, Date releaseDate,String platform,String publisher, RentalStore rentalStore) {
        super(iD, title, genre, releaseDate,rentalStore);
        this.platform = platform;
        this.publisher = publisher;
    }

    public String getPlatform() {
        return platform;
    }
    public String getPublisher() {
        return publisher;
    }

    
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
