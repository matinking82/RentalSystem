import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JsonTester {
    private String path;
    private RentalStore rentalStore;

    public JsonTester(String path, RentalStore rentalStore) {
        this.path = path;
        this.rentalStore = rentalStore;
    }

    public void addItem(Item item) {
        if (item instanceof Book) {
            addBook((Book) item);
        } else if (item instanceof Game) {
            addGame((Game) item);
        } else if (item instanceof Movie) {
            addMovie((Movie) item);
        } else {
            throw new IllegalArgumentException("Unsupported item type");
        }
    }

    public void removeItem(Item item) {
        if (item instanceof Book) {
            removeBook(item.getID());
        } else if (item instanceof Game) {
            removeGame(item.getID());
        } else if (item instanceof Movie) {
            removeMovie(item.getID());
        } else {
            throw new IllegalArgumentException("Unsupported item type");
        }
    }

    public void updateItem(Item item) {
        if (item instanceof Book) {
            updateBook(item.getID(), (Book) item);
        } else if (item instanceof Game) {
            updateGame(item.getID(), (Game) item);
        } else if (item instanceof Movie) {
            updateMovie(item.getID(), (Movie) item);
        } else {
            throw new IllegalArgumentException("Unsupported item type");
        }
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        items.addAll(getAllBooks());
        items.addAll(getAllGames());
        items.addAll(getAllMovies());
        return items;
    }

    public Item getItemById(int id) {
        Item item = getBookById(id);
        if (item == null) {
            item = getGameById(id);
        }
        if (item == null) {
            item = getMovieById(id);
        }
        return item;
    }

    public void addBook(Book book) {
        JSONObject jsonObject = readJsonFile();
        JSONArray books = (JSONArray) jsonObject.get("books");
        books.add(bookToJsonObject(book));
        writeJsonFile(jsonObject);
    }

    public void removeBook(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray books = (JSONArray) jsonObject.get("books");
        Iterator<JSONObject> iterator = books.iterator();
        while (iterator.hasNext()) {
            JSONObject book = iterator.next();
            if (((int) (long) book.get("ID") == id)) {
                iterator.remove();
                break;
            }
        }
        writeJsonFile(jsonObject);
    }

    public void updateBook(Integer id, Book updatedBook) {
        JSONObject jsonObject = readJsonFile();
        JSONArray books = (JSONArray) jsonObject.get("books");
        for (int i = 0; i < books.size(); i++) {
            JSONObject book = (JSONObject) books.get(i);
            if (((int) (long) book.get("ID")) == (id)) {
                books.set(i, bookToJsonObject(updatedBook));
                break;
            }
        }
        writeJsonFile(jsonObject);
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        JSONObject jsonObject = readJsonFile();
        JSONArray books = (JSONArray) jsonObject.get("books");
        for (Object book : books) {
            JSONObject bookObject = (JSONObject) book;
            bookList.add(jsonObjectToBook(bookObject));
        }
        return bookList;
    }

    public Book getBookById(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray books = (JSONArray) jsonObject.get("books");
        for (Object book : books) {
            JSONObject bookObject = (JSONObject) book;
            if (((int) (long) bookObject.get("ID")) == (id)) {
                return jsonObjectToBook(bookObject);
            }
        }
        return null;
    }

    public void addGame(Game game) {
        JSONObject jsonObject = readJsonFile();
        JSONArray games = (JSONArray) jsonObject.get("games");
        games.add(gameToJsonObject(game));
        writeJsonFile(jsonObject);
    }

    public void removeGame(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray games = (JSONArray) jsonObject.get("games");
        Iterator<JSONObject> iterator = games.iterator();
        while (iterator.hasNext()) {
            JSONObject game = iterator.next();
            if (((int) (long) game.get("ID")) == (id)) {
                iterator.remove();
                break;
            }
        }
        writeJsonFile(jsonObject);
    }

    public void updateGame(Integer id, Game updatedGame) {
        JSONObject jsonObject = readJsonFile();
        JSONArray games = (JSONArray) jsonObject.get("games");
        for (int i = 0; i < games.size(); i++) {
            JSONObject game = (JSONObject) games.get(i);
            if (((int) (long) game.get("ID")) == (id)) {
                games.set(i, gameToJsonObject(updatedGame));
                break;
            }
        }
        writeJsonFile(jsonObject);
    }

    public List<Game> getAllGames() {
        List<Game> gameList = new ArrayList<>();
        JSONObject jsonObject = readJsonFile();
        JSONArray games = (JSONArray) jsonObject.get("games");
        for (Object game : games) {
            JSONObject gameObject = (JSONObject) game;
            gameList.add(jsonObjectToGame(gameObject));
        }
        return gameList;
    }

    public Game getGameById(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray games = (JSONArray) jsonObject.get("games");
        for (Object game : games) {
            JSONObject gameObject = (JSONObject) game;
            if (((int) (long) gameObject.get("ID")) == (id)) {
                return jsonObjectToGame(gameObject);
            }
        }
        return null;
    }

    public void addMovie(Movie movie) {
        JSONObject jsonObject = readJsonFile();
        JSONArray movies = (JSONArray) jsonObject.get("movies");
        movies.add(movieToJsonObject(movie));
        writeJsonFile(jsonObject);
    }

    public void removeMovie(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray movies = (JSONArray) jsonObject.get("movies");
        Iterator<JSONObject> iterator = movies.iterator();
        while (iterator.hasNext()) {
            JSONObject movie = iterator.next();
            if (((int) (long) movie.get("ID")) == (id)) {
                iterator.remove();
                break;
            }
        }
        writeJsonFile(jsonObject);
    }

    public void updateMovie(Integer id, Movie updatedMovie) {
        JSONObject jsonObject = readJsonFile();
        JSONArray movies = (JSONArray) jsonObject.get("movies");
        for (int i = 0; i < movies.size(); i++) {
            JSONObject movie = (JSONObject) movies.get(i);
            if (((int) (long) movie.get("ID")) == (id)) {
                movies.set(i, movieToJsonObject(updatedMovie));
                break;
            }
        }
        writeJsonFile(jsonObject);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        JSONObject jsonObject = readJsonFile();
        JSONArray movies = (JSONArray) jsonObject.get("movies");
        for (Object movie : movies) {
            JSONObject movieObject = (JSONObject) movie;
            movieList.add(jsonObjectToMovie(movieObject));
        }
        return movieList;

    }

    public Movie getMovieById(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray movies = (JSONArray) jsonObject.get("movies");
        for (Object movie : movies) {
            JSONObject movieObject = (JSONObject) movie;
            if (((int) (long) movieObject.get("ID")) == (id)) {
                return jsonObjectToMovie(movieObject);
            }
        }
        return null;

    }

    public void addCustomer(Customer customer) {
        JSONObject jsonObject = readJsonFile();
        JSONArray customers = (JSONArray) jsonObject.get("customers");
        customers.add(customerToJsonObject(customer));
        writeJsonFile(jsonObject);
    }

    public void removeCustomer(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray customers = (JSONArray) jsonObject.get("customers");
        Iterator<JSONObject> iterator = customers.iterator();
        while (iterator.hasNext()) {
            JSONObject customer = iterator.next();
            if (((int) (long) customer.get("ID")) == (id)) {
                iterator.remove();
                break;
            }
        }
        writeJsonFile(jsonObject);

    }

    public void updateCustomer(Integer id, Customer updatedCustomer) {
        JSONObject jsonObject = readJsonFile();
        JSONArray customers = (JSONArray) jsonObject.get("customers");
        for (int i = 0; i < customers.size(); i++) {
            JSONObject customer = (JSONObject) customers.get(i);
            if (((int) (long) customer.get("ID")) == (id)) {
                customers.set(i, customerToJsonObject(updatedCustomer));
                break;
            }
        }
        writeJsonFile(jsonObject);

    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        JSONObject jsonObject = readJsonFile();
        JSONArray customers = (JSONArray) jsonObject.get("customers");
        for (Object customer : customers) {
            JSONObject customerObject = (JSONObject) customer;
            customerList.add(jsonObjectToCustomer(customerObject));
        }
        return customerList;

    }

    public Customer getCustomerById(Integer id) {
        JSONObject jsonObject = readJsonFile();
        JSONArray customers = (JSONArray) jsonObject.get("customers");
        for (Object customer : customers) {
            JSONObject customerObject = (JSONObject) customer;
            if (((int) (long) customerObject.get("ID")) == (id)) {
                return jsonObjectToCustomer(customerObject);
            }
        }
        return null;

    }

    private void writeJsonFile(JSONObject obj) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private JSONObject readJsonFile() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);

            return (JSONObject) obj;

        } catch (IOException | ParseException e) {
            e.printStackTrace();

        }
        return null;

    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Book jsonObjectToBook(JSONObject obj) {
        Integer ID = ((Long) obj.get("ID")).intValue();
        String title = (String) obj.get("title");
        String genre = (String) obj.get("genre");
        Date releaseDate = null;

        try {
            releaseDate = dateFormat.parse((String) obj.get("releaseDate"));

        } catch (Exception e) {
            e.printStackTrace();

        }
        String author = (String) obj.get("author");
        String publisher = (String) obj.get("publisher");

        Book book = new Book(ID, title, genre, releaseDate, author, publisher, rentalStore);
        book.setAvailable((boolean) obj.get("available"));
        return book;

    }

    private JSONObject bookToJsonObject(Book book) {
        JSONObject obj = new JSONObject();
        obj.put("ID", book.getID());
        obj.put("title", book.getTitle());
        obj.put("genre", book.getGenre());
        obj.put("releaseDate", dateFormat.format(book.getReleaseDate()));
        obj.put("author", book.getAuthor());
        obj.put("publisher", book.getPublisher());
        obj.put("available", book.isAvailable());
        return obj;
    }

    private JSONObject gameToJsonObject(Game game) {
        JSONObject obj = new JSONObject();
        obj.put("ID", game.getID());
        obj.put("title", game.getTitle());
        obj.put("genre", game.getGenre());
        obj.put("releaseDate", dateFormat.format(game.getReleaseDate()));
        obj.put("platform", game.getPlatform());
        obj.put("publisher", game.getPublisher());
        obj.put("available", game.isAvailable());
        return obj;
    }

    private JSONObject movieToJsonObject(Movie movie) {
        JSONObject obj = new JSONObject();
        obj.put("ID", movie.getID());
        obj.put("title", movie.getTitle());
        obj.put("genre", movie.getGenre());
        obj.put("releaseDate", dateFormat.format(movie.getReleaseDate()));
        obj.put("director", movie.getDirector());
        obj.put("cast", movie.getCast());
        obj.put("available", movie.isAvailable());
        return obj;
    }

    private Movie jsonObjectToMovie(JSONObject obj) {
        Integer ID = ((Long) obj.get("ID")).intValue();
        String title = (String) obj.get("title");
        String genre = (String) obj.get("genre");
        Date releaseDate = null;
        try {
            releaseDate = dateFormat.parse((String) obj.get("releaseDate"));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        String director = (String) obj.get("director");
        String cast = (String) obj.get("cast");

        Movie movie = new Movie(title, genre, director, cast, releaseDate, ID, rentalStore);
        movie.setAvailable((boolean) obj.get("available"));
        return movie;
    }

    private JSONObject customerToJsonObject(Customer customer) {
        JSONObject obj = new JSONObject();
        obj.put("ID", customer.getID());
        obj.put("name", customer.getName());
        obj.put("email", customer.getEmail());
        obj.put("phoneNumber", customer.getPhoneNumber());
        obj.put("address", customer.getAddress());

        JSONArray rentalsArray = new JSONArray();
        for (Rental rental : customer.getRentals()) {
            rentalsArray.add(rentalToJsonObject(rental));
        }
        obj.put("rentals", rentalsArray);

        return obj;
    }

    private Customer jsonObjectToCustomer(JSONObject obj) {
        Integer ID = ((Long) obj.get("ID")).intValue();
        String name = (String) obj.get("name");
        String email = (String) obj.get("email");
        String phoneNumber = (String) obj.get("phoneNumber");
        String address = (String) obj.get("address");

        Customer customer = new Customer(name, email, phoneNumber, address, ID);

        JSONArray rentalsArray = (JSONArray) obj.get("rentals");
        if (rentalsArray != null) {
            for (Object rental : rentalsArray) {
                JSONObject rentalObject = (JSONObject) rental;
                customer.getRentals().add(jsonObjectToRental(rentalObject));
            }
        }

        return customer;
    }

    private Game jsonObjectToGame(JSONObject obj) {
        Integer ID = ((Long) obj.get("ID")).intValue();
        String title = (String) obj.get("title");
        String genre = (String) obj.get("genre");
        Date releaseDate = null;
        try {
            releaseDate = dateFormat.parse((String) obj.get("releaseDate"));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        String platform = (String) obj.get("platform");
        String publisher = (String) obj.get("publisher");

        Game game = new Game(ID, title, genre, releaseDate, platform, publisher, rentalStore);
        game.setAvailable((boolean) obj.get("available"));
        return game;
    }

    private JSONObject rentalToJsonObject(Rental rental) {
        JSONObject obj = new JSONObject();
        obj.put("ID", rental.getID());
        obj.put("customerId", rental.getCustomer());

        if (rental.getItem() instanceof Book) {
            obj.put("item", bookToJsonObject((Book) rental.getItem()));
            obj.put("itemType", "book");
        } else if (rental.getItem() instanceof Game) {
            obj.put("item", gameToJsonObject((Game) rental.getItem()));
            obj.put("itemType", "game");
        } else if (rental.getItem() instanceof Movie) {
            obj.put("item", movieToJsonObject((Movie) rental.getItem()));
            obj.put("itemType", "movie");
        }

        obj.put("rentalDate", dateFormat.format(rental.getRentalDate()));

        if (rental.getReturnDate() != null) {
            obj.put("returnDate", dateFormat.format(rental.getReturnDate()));
        } else {
            obj.put("returnDate", null);
        }

        return obj;
    }

    private Rental jsonObjectToRental(JSONObject obj) {
        Integer ID = ((Long) obj.get("ID")).intValue();
        int customerId = ((Long) obj.get("customerId")).intValue();
        Date rentalDate = null;
        Item item = null;

        switch ((String) obj.get("itemType")) {
            case "book":
                item = (jsonObjectToBook((JSONObject) obj.get("item")));
                break;
            case "game":
                item = (jsonObjectToGame((JSONObject) obj.get("item")));

                break;
            case "movie":
                item = (jsonObjectToMovie((JSONObject) obj.get("item")));
                break;
            default:
                break;
        }

        try {
            rentalDate = dateFormat.parse((String) obj.get("rentalDate"));
        } catch (java.text.ParseException e) {
        }

        Rental rental = new Rental(ID, item, customerId);

        if (obj.containsKey("returnDate")) {
            Date returnDate = null;
            try {
                returnDate = dateFormat.parse((String) obj.get("returnDate"));
            } catch (Exception e) {
            }
            rental.setReturnDate(returnDate);
        }

        return rental;
    }

}
