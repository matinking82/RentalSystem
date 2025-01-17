import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer ID;//unique id
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private List<Rental> rentals;//stores customers rented items

    public Customer(String name, String email, String phoneNumber, String address, Integer Id) {
        ID = Id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentals = new ArrayList<Rental>();
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public List<Rental> getRentals(){
        return rentals;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
