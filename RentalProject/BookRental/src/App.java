import java.util.Date;

public class App {
    private static RentalStore rentalStore = new RentalStore();

    public static void main(String[] args) {
        JsonTester tester = new JsonTester(
                "C:\\Users\\matin\\Desktop\\APP\\RentalSystem\\RentalProject\\BookRental\\TestYourFork.json",
                rentalStore);

        var books = tester.getAllBooks();

        for (Book book : books) {
            rentalStore.addItem(book);
        }

        var games = tester.getAllGames();

        for (Game game : games) {
            rentalStore.addItem(game);
        }

        var movies = tester.getAllMovies();

        for (Movie movie : movies) {
            rentalStore.addItem(movie);
        }

        var customers = tester.getAllCustomers();

        for (Customer customer : customers) {
            rentalStore.register(customer);
        }

        Customer john = rentalStore.getCustomerById(1);
        Customer emily = rentalStore.getCustomerById(2);
        Customer michael = rentalStore.getCustomerById(3);

        Item b3 = rentalStore.getItemById(3);
        Item b6 = rentalStore.getItemById(6);
        rentalStore.rentitem(b3, john);
        rentalStore.rentitem(b6, john);

        Item b1 = rentalStore.getItemById(1);
        Item b7 = rentalStore.getItemById(7);
        rentalStore.rentitem(b1, emily);
        rentalStore.rentitem(b7, emily);

        Item b9 = rentalStore.getItemById(9);
        Item b4 = rentalStore.getItemById(4);
        rentalStore.rentitem(b9, michael);
        rentalStore.rentitem(b4, michael);

        tester.updateCustomer(john.getID(), john);
        tester.updateCustomer(emily.getID(), emily);
        tester.updateCustomer(michael.getID(), michael);
        tester.updateItem(b1);
        tester.updateItem(b3);
        tester.updateItem(b4);
        tester.updateItem(b6);
        tester.updateItem(b7);
        tester.updateItem(b9);

        
    }
}
