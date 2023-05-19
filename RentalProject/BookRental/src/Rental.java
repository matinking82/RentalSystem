import java.util.Date;

public class Rental {
    private Integer ID;//unique id
    private Item rentedItem;
    private Integer customerId;
    private Date rentalDate;//stores the time that the Item rented
    private Date returnDate;


    public Rental(Integer iD, Item rentedItem, Integer customerId) {
        ID = iD;
        this.rentedItem = rentedItem;
        this.customerId = customerId;
        rentalDate = new Date();
    }

    public Integer getID() {
        return ID;
    }

    public Item getItem() {
        return rentedItem;
    }

    public Integer getCustomer() {
        return customerId;
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
