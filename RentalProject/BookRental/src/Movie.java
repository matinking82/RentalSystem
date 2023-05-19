import java.util.Date;

public class Movie extends Item{
    private String director;
    private String cast;

    public Movie(String title, String genre, String director, String cast, Date releaseDate, Integer ID, RentalStore rentalStore) {
        
        super(ID, title, genre, releaseDate,rentalStore);

        this.director = director;
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public void setCast(String cast) {
        this.cast = cast;
    }
}
