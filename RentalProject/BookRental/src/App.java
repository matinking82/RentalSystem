import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.*;
import org.json.simple.parser.*;

public class App {
    private static RentalStore rentalStore = new RentalStore();

    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(
                "TestYourFork.json"));
        ;
        JSONArray books = (JSONArray) jsonObject.get("books");
        JSONArray games = (JSONArray) jsonObject.get("games");
        JSONArray movies = (JSONArray) jsonObject.get("movies");
        JSONArray customers = (JSONArray) jsonObject.get("customers");

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Customer> allCustomers = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < books.size(); i++) {
            JSONObject obj = (JSONObject) (books.get(i));

            String date = ((String) (obj.get("releaseDate")));

            Book newBook = new Book(
                    (int) ((long) (obj.get("id"))),
                    (String) obj.get("title"),
                    (String) obj.get("genre"),
                    dateFormat.parse(date),
                    (String) obj.get("writer"),
                    (String) obj.get("publisher"),
                    rentalStore);

            newBook.setAvailable((boolean) obj.get("isAvailable"));

            rentalStore.addItem(newBook);
            items.add(newBook);
        }
        for (int i = 0; i < games.size(); i++) {
            JSONObject obj = (JSONObject) (games.get(i));

            String date = ((String) (obj.get("releaseDate")));

            Game newGame = new Game(
                    (int) ((long) (obj.get("id"))),
                    (String) obj.get("title"),
                    (String) obj.get("genre"),
                    dateFormat.parse(date),
                    null,
                    (String) obj.get("manufacturer"),
                    rentalStore);

            newGame.setAvailable((boolean) obj.get("isAvailable"));

            rentalStore.addItem(newGame);
            items.add(newGame);
        }
        for (int i = 0; i < movies.size(); i++) {
            JSONObject obj = (JSONObject) (movies.get(i));

            String date = ((String) (obj.get("releaseDate")));

            Movie newMovie = new Movie(
                    (String) obj.get("title"),
                    (String) obj.get("genre"),
                    (String) obj.get("director"),
                    (String) obj.get("cast"),
                    dateFormat.parse(date),
                    (int) ((long) (obj.get("id"))),
                    rentalStore);

            newMovie.setAvailable((boolean) obj.get("isAvailable"));

            rentalStore.addItem(newMovie);
            items.add(newMovie);
        }

        for (int i = 0; i < customers.size(); i++) {
            JSONObject obj = (JSONObject) (customers.get(i));

            Customer newCustomer = new Customer(
                    (String) obj.get("name"),
                    (String) obj.get("email"),
                    (String) obj.get("phone"),
                    (String) obj.get("address"),
                    (int) ((long) obj.get("id")));
            rentalStore.register(newCustomer);
            allCustomers.add(newCustomer);
        }
        System.out.println("finished");

    }
}
