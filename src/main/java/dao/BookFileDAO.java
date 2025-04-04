package dao;

import model.Book;
import java.io.*;
import java.util.*;

public class BookFileDAO {

    private static final String BOOK_FILE = "books.txt"; // File to store books

    // Reads all books from the file
    public static List<Book> getAllBooksFromFile() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    books.add(new Book(Integer.parseInt(data[0]), data[1], data[2], data[3],
                            Double.parseDouble(data[4]), Integer.parseInt(data[5])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Adds a new book to the file
    public static boolean addBookToFile(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE, true))) {
            String line = book.getId() + "," + book.getTitle() + "," + book.getAuthor() + ","
                    + book.getGenre() + "," + book.getPrice() + "," + book.getAvailable();
            writer.write(line);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Updates the file with a modified list of books
    public static boolean updateBooksFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books) {
                String line = book.getId() + "," + book.getTitle() + "," + book.getAuthor() + ","
                        + book.getGenre() + "," + book.getPrice() + "," + book.getAvailable();
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
