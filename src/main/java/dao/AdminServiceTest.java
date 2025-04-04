package dao;
import service.AdminService;
import model.Book;

import java.util.List;

public class AdminServiceTest {
    public static void main(String[] args) {
        AdminService admin = new AdminService();

        // Test adding a book
        boolean added = admin.addBook("Test Book", "Test Author", "Fiction", 9.99);
        System.out.println("Add Book: " + (added ? "Success" : "Failed"));

        // Test retrieving all books
        List<Book> books = admin.getAllBooks();
        System.out.println("Books in DB:");
        for (Book b : books) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }

        // Test searching books
        List<Book> results = admin.searchBooks("Test");
        System.out.println("Search Results:");
        for (Book b : results) {
            System.out.println("- " + b.getTitle());
        }
    }
}
