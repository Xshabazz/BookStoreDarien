package test;

import dao.BookDAO;
import model.Book;
import service.CheckoutService;

import java.util.List;


public class CheckoutServiceTest {

    public static void main(String[] args) {
        // Test setup: adding some sample books
        BookDAO.addBook("Book 1", "Author 1", "Genre 1", 15.99);
        BookDAO.addBook("Book 2", "Author 2", "Genre 2", 25.99);

        // Retrieve books from the database
        List<Book> books = BookDAO.getAllBooks();

        // Test the CheckoutService
        CheckoutService checkoutService = new CheckoutService();

        // Simulate adding books to the checkout cart (book IDs are fetched from the database)
        System.out.println("Testing checkout process...");

        // Assuming book ID 1 and ID 2 exist in the database
        boolean checkoutResult = checkoutService.checkout(1, 2);

        if (checkoutResult) {
            System.out.println("Checkout successful!");
        } else {
            System.out.println("Checkout failed.");
        }
    }
}
