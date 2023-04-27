import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalStore {
    private List<Item> availableItems;//stores the available movies in the system
    private List<Customer> registeredCustomers;//stores the registered users

    public RentalStore() {
        availableItems = new ArrayList<Item>();
        registeredCustomers = new ArrayList<Customer>();
    }

    public void register(Customer customer) {
        registeredCustomers.add(customer);//registers a user by adding to the list of registered users
    }

    public void addItem(Item item) {
        availableItems.add(item);//adds a movie to the system
    }

    public void removeItem(Item item) {
        availableItems.remove(item);//removes a movie from the system
    }

    public List<Item> getAvailableItems() {
        return availableItems;//returns available movies
    }

    public void rentMovie(Item item, Customer customer) {
        if(!item.isAvailable()){//check if the movie is available
            return;
        }

        //adds movieId and customerId || Example = 543 + 324 => rentalId = 543324
        Integer rentalID = (item.getID()*((int) Math.pow(10, customer.getID().toString().length()))) + customer.getID();
        ////////////////////////////////

        Rental newRenatl = new Rental(rentalID, item, customer);
        item.setAvailable(false);
        removeItem(item);
        customer.getRentals().add(newRenatl);
    }

    public void returnItem(Rental rental) {

        rental.getCustomer().getRentals().remove(rental);
        rental.setReturnDate(new Date());
        rental.getItem().setAvailable(true);
        addItem(rental.getItem());
    }

    public Customer getCustomerById(int id) {
        for (int i = 0; i < registeredCustomers.size(); i++) {
            if (registeredCustomers.get(i).getID() == id) {
                return registeredCustomers.get(i);
            }
        }
        return null;
    }

    public Item getItemById(int id) {
        for (int i = 0; i < availableItems.size(); i++) {
            if (availableItems.get(i).getID() == id) {
                return availableItems.get(i);
            }
        }
        return null;
    }
}
