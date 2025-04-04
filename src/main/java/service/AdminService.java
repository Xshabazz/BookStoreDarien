package service;

import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import model.User;

import java.util.List;

public class AdminService {

    // Book Management
    public List<Book> getAllBooks() {
        return BookDAO.getAllBooks();
    }

    public boolean addBook(String title, String author, String genre, double price) {
        return BookDAO.addBook(title, author, genre, price);
    }

    public List<Book> searchBooks(String keyword) {
        return BookDAO.searchBooks(keyword);
    }

    // User Management
    public boolean registerUser(String username, String password, String role) {
        return UserDAO.registerUser(username, password, role);
    }

    public User authenticateUser(String username, String password) {
        return UserDAO.authenticateUser(username, password);
    }



}
