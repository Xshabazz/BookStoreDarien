package service;

import dao.BookDAO;
import dao.OrderDAO;
import model.Book;

public class CheckoutService {

    // Method to calculate the total price of the books in the cart
    public double calculateTotalPrice(int bookId, int quantity) {
        Book book = BookDAO.getBookById(bookId); // Get book details by ID
        if (book != null) {
            return book.getPrice() * quantity;
        }
        return 0.0;
    }

    // Method to process the order (simplified without actual payment gateway integration)
    public boolean processOrder(int userId, int bookId, int quantity) {
        // Step 1: Calculate the total price
        double totalPrice = calculateTotalPrice(bookId, quantity);

        // Step 2: Place the order
        boolean orderPlaced = OrderDAO.placeOrder(userId, bookId, quantity, totalPrice);

        // Step 3: If the order is successfully placed, reduce the book availability
        if (orderPlaced) {
            reduceBookAvailability(bookId, quantity);
        }

        return orderPlaced;
    }

    // Method to reduce the book's availability after an order is placed
    private void reduceBookAvailability(int bookId, int quantity) {
        BookDAO.updateBookAvailability(bookId, -quantity);
    }

    public boolean checkout(int... bookIds) {
        // Retrieve the books to be checked out from the database by their IDs
        double totalAmount = 0.0;
        for (int bookId : bookIds) {
            Book book = BookDAO.getBookById(bookId);
            if (book == null || book.getAvailable() <= 0) {
                // If the book is not found or is out of stock, return false (checkout failed)
                System.out.println("Book with ID " + bookId + " is not available for checkout.");
                return false;
            }
            // Add the price of the book to the total amount
            totalAmount += book.getPrice();
        }

        // Now we would typically create an order and save it to the database.
        // In this example, we just print out the total amount (for simplicity).
        System.out.println("Total amount for checkout: $" + totalAmount);

        // Assuming the checkout process is successful, return true
        return true;
    }
}
