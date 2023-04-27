import java.util.Date;

public class Game extends Item {
    
    private String platform;
    private String publisher;
    
    public Game(Integer iD, String title, String genre, Date releaseDate,String platform,String publisher) {
        super(iD, title, genre, releaseDate);
        this.platform = platform;
        this.publisher = publisher;
    }

    public String getPlatform() {
        return platform;
    }
    public String getPublisher() {
        return publisher;
    }
}
