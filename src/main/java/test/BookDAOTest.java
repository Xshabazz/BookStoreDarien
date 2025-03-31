package test;

import model.Book;
import dao.BookDAO;

import java.util.List;

public class BookDAOTest {

    public static void main(String[] args) {
        // Test 1: Adding a new book
        addBookTest();

        // Test 2: Retrieving all books
        getAllBooksTest();

        // Test 3: Searching for books by title, author, or genre
        searchBooksTest();
    }

    // Test 1: Adding a new book to the database
    private static void addBookTest() {
        System.out.println("Test 1: Add Book Test");
        String title = "Java Programming";
        String author = "John Doe";
        String genre = "Technology";
        double price = 29.99;

        boolean success = BookDAO.addBook(title, author, genre, price);
        if (success) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Failed to add book.");
        }
    }

    // Test 2: Retrieving all books from the database
    private static void getAllBooksTest() {
        System.out.println("Test 2: Get All Books Test");

        List<Book> books = BookDAO.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found in the catalog.");
        } else {
            System.out.println("Books in catalog:");
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " - $" + book.getPrice());
            }
        }
    }

    // Test 3: Searching for books by title, author, or genre
    private static void searchBooksTest() {
        System.out.println("Test 3: Search Books Test");

        String keyword = "Java";
        List<Book> books = BookDAO.searchBooks(keyword);
        if (books.isEmpty()) {
            System.out.println("No books found for search keyword: " + keyword);
        } else {
            System.out.println("Books found for search keyword '" + keyword + "':");
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " - $" + book.getPrice());
            }
        }
    }
}

