import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalStore {
    private List<Movie> availableMovies;//stores the available movies in the system
    private List<Customer> registeredCustomers;//stores the registered users

    public RentalStore() {
        availableMovies = new ArrayList<Movie>();
        registeredCustomers = new ArrayList<Customer>();
    }

    public void register(Customer customer) {
        registeredCustomers.add(customer);//registers a user by adding to the list of registered users
    }

    public void addMovie(Movie movie) {
        availableMovies.add(movie);//adds a movie to the system
    }

    public void removeMovie(Movie movie) {
        availableMovies.remove(movie);//removes a movie from the system
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;//returns available movies
    }

    public void rentMovie(Movie movie, Customer customer) {
        if(!movie.isAvailable()){//check if the movie is available
            return;
        }

        //adds movieId and customerId || Example = 543 + 324 => rentalId = 543324
        Integer rentalID = (movie.getID()*((int) Math.pow(10, customer.getID().toString().length()))) + customer.getID();
        ////////////////////////////////

        Rental newRenatl = new Rental(rentalID, movie, customer);
        movie.setAvailable(false);
        removeMovie(movie);
        customer.getRentals().add(newRenatl);
    }

    public void returnMovie(Rental rental) {

        rental.getCustomer().getRentals().remove(rental);
        rental.setReturnDate(new Date());
        rental.getMovie().setAvailable(true);
        addMovie(rental.getMovie());
    }

    public Customer getCustomerById(int id) {
        for (int i = 0; i < registeredCustomers.size(); i++) {
            if (registeredCustomers.get(i).getID() == id) {
                return registeredCustomers.get(i);
            }
        }
        return null;
    }

    public Movie getMovieById(int id) {
        for (int i = 0; i < availableMovies.size(); i++) {
            if (availableMovies.get(i).getID() == id) {
                return availableMovies.get(i);
            }
        }
        return null;
    }
}
