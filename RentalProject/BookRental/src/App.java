import java.util.Date;

public class App {
    private static RentalStore rentalStore = new RentalStore();

    public static void main(String[] args) {
        JsonTester tester = new JsonTester(
                "C:\\Users\\matin\\Desktop\\APP\\RentalSystem\\RentalProject\\BookRental\\src\\TestYourFork.json",
                rentalStore);

        Book book = new Book(100, "null", "null", new Date(), "null", "null", rentalStore);
        Game game = new Game(100, "null", "null", new Date(), "null", "null", rentalStore);
        Movie movie = new Movie("100", "null", "null", "null", new Date(), 100, rentalStore);

        Customer customer = new Customer("null", "null", "null", "null", 100);
        book.setAvailable(false);
        game.setAvailable(false);
        movie.setAvailable(false);
        try {
            // test customer
            tester.addCustomer(customer);
            var test = tester.getAllCustomers();
            customer.setEmail("horror");
            tester.updateCustomer(customer.getID(), customer);
            test = tester.getAllCustomers();
            var t = tester.getCustomerById(100);
            tester.removeCustomer(100);
            test = tester.getAllCustomers();

            // test movie

            tester.addMovie(movie);
            var test2 = tester.getAllMovies();
            movie.setAvailable(true);
            movie.setGenre("horror");
            tester.updateMovie(movie.getID(), movie);
            test2 = tester.getAllMovies();
            var t2 = tester.getMovieById(100);
            tester.removeMovie(100);
            test2 = tester.getAllMovies();

            // test game
            //
            tester.addGame(game);
            var test3 = tester.getAllGames();
            game.setAvailable(true);
            game.setGenre("horror");
            tester.updateGame(game.getID(), game);
            test3 = tester.getAllGames();
            var t3 = tester.getGameById(100);
            tester.removeGame(100);
            test3 = tester.getAllGames();

            // test book
            tester.addBook(book);
            var test4 = tester.getAllBooks();
            book.setAvailable(true);
            book.setGenre("horror");
            tester.updateBook(book.getID(), book);
            test4 = tester.getAllBooks();
            var t4 = tester.getBookById(100);
            tester.removeBook(100);
            test4 = tester.getAllBooks();

            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
