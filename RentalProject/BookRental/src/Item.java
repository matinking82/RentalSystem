import java.util.Date;

public class Item {
    private Integer ID;
    private String title;
    private String genre;
    private Date releaseDate;
    private boolean available;
    private RentalStore rentalStore;

    public Item(Integer iD, String title, String genre, Date releaseDate, RentalStore rentalStore) {
        ID = iD;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rentalStore = rentalStore;
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

    public void setAvailable(boolean status) {
        available = status;
    }

    public void rentItem(Customer customer) {
        rentalStore.rentitem(this, customer);
    }

    public void retutnItem(Customer customer) {
        Rental rental = new Rental(0, null, null);

        for (Rental r : customer.getRentals()) {
            if (r.getItem().getID() == this.ID) {
                rental = r;
                break;
            }
        }

        rentalStore.returnItem(rental);
    }
}
