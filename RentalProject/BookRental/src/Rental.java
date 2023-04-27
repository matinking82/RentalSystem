import java.util.Date;

public class Rental {
    private Integer ID;//unique id
    private Item rentedItem;
    private Customer customer;
    private Date rentalDate;//stores the time that the Item rented
    private Date returnDate;


    public Rental(Integer iD, Item rentedItem, Customer customer) {
        ID = iD;
        this.rentedItem = rentedItem;
        this.customer = customer;
        rentalDate = new Date();
    }

    public Integer getID() {
        return ID;
    }

    public Item getItem() {
        return rentedItem;
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
