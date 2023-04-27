import java.util.Date;

public class Movie extends Item{
    private String director;
    private String cast;

    public Movie(String title, String genre, String director, String cast, Date releaseDate, Integer ID) {
        
        super(ID, title, genre, releaseDate);

        this.director = director;
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    
}
