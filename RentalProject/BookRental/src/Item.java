import java.util.Date;

public class Item {
    private Integer ID;
    private String title;
    private String genre;
    private Date releaseDate;
    private boolean available;


    public Item(Integer iD, String title, String genre, Date releaseDate) {
        ID = iD;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        available = true;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status){
        available = status;
    }

    public void rentItem(){
        //test
    }

    public void retutnItem(){
        //test
    }
}
