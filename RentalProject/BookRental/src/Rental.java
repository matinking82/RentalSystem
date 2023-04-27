import java.util.Date;

public class Rental {
    private Integer ID;//unique id
    private Movie rentedMovie;
    private Customer customer;
    private Date rentalDate;//stores the time that the movie rented
    private Date returnDate;


    public Rental(Integer iD, Movie rentedMovie, Customer customer) {
        ID = iD;
        this.rentedMovie = rentedMovie;
        this.customer = customer;
        rentalDate = new Date();
    }

    public Integer getID() {
        return ID;
    }

    public Movie getMovie() {
        return rentedMovie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date date){
        returnDate = date;
    }

    public double calculateLateFee(){
        return 0.1;//test
    }
}
