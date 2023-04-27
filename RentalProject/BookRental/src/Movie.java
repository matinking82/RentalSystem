import java.util.Date;

public class Movie {
    private Integer ID;//unique id
    private String title;
    private String genre;
    private String director;
    private String cast;
    private Date releaseDate;
    private boolean available;

    public Movie(String title, String genre, String director, String cast, Date releaseDate, Integer ID) {
        this.ID = ID;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.cast = cast;
        this.releaseDate = releaseDate;
    }

    public Integer getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status){
        available = status;
    }
}
