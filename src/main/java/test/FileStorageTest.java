package test;

import dao.BookFileDAO;
import dao.UserFileDAO;
import dao.OrderFileDAO;
import model.Book;
import model.User;
import model.Order;

import java.util.List;

public class FileStorageTest {

    public static void main(String[] args) {
        // Testing BookFileDAO
        System.out.println("Testing BookFileDAO:");
        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 10.99, 5);
        Book book2 = new Book(2, "1984", "George Orwell", "Dystopian", 8.99, 10);

        // Add books to file
        BookFileDAO.addBookToFile(book1);
        BookFileDAO.addBookToFile(book2);

        // Retrieve all books and display them
        List<Book> books = BookFileDAO.getAllBooksFromFile();
        books.forEach(book -> System.out.println("Book ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor()));

        // Testing UserFileDAO
        System.out.println("\nTesting UserFileDAO:");
        User user1 = new User(1, "john_doe", "password123", "admin");
        User user2 = new User(2, "jane_doe", "password456", "customer");

        // Add users to file
        UserFileDAO.addUserToFile(user1);
        UserFileDAO.addUserToFile(user2);

        // Retrieve all users and display them
        List<User> users = UserFileDAO.getAllUsersFromFile();
        users.forEach(user -> System.out.println("User ID: " + user.getId() + ", Username: " + user.getUsername() + ", Role: " + user.getRole()));

        // Testing OrderFileDAO
        System.out.println("\nTesting OrderFileDAO:");
        // Create order with book IDs and username
        Order order1 = new Order(List.of(1, 2), "john_doe");

        // Add order to file
        OrderFileDAO.addOrderToFile(order1);

        // Retrieve all orders and display them
        List<Order> orders = OrderFileDAO.getAllOrdersFromFile();
        orders.forEach(order -> {
            System.out.println("Order for User: " + order.getUserId() + ", Book IDs: " + order.getBookId());
        });
    }
}
