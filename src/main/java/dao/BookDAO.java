package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getString("genre"),
                        rs.getDouble("price"), rs.getInt("available")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Book> searchBooks(String keyword) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR genre LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String searchKeyword = "%" + keyword + "%";
            stmt.setString(1, searchKeyword);
            stmt.setString(2, searchKeyword);
            stmt.setString(3, searchKeyword);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getString("genre"),
                        rs.getDouble("price"), rs.getInt("available")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}

