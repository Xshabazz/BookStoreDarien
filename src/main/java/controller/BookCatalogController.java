package controller;

import dao.BookDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import model.Book;

public class BookCatalogController {

    @FXML
    private ListView<Book> bookListView;
    @FXML
    private TextField searchField;

    public void initialize() {
        loadAllBooks();
    }

    // Load all books into the ListView
    private void loadAllBooks() {
        bookListView.setItems(FXCollections.observableArrayList(BookDAO.getAllBooks()));
    }

    // Handle search action
    @FXML
    public void handleSearch() {
        String keyword = searchField.getText();
        if (keyword.isEmpty()) {
            loadAllBooks();
        } else {
            bookListView.setItems(FXCollections.observableArrayList(BookDAO.searchBooks(keyword)));
        }
    }

    // Handle selection of a book (you can add to cart here or show details)
    @FXML
    public void handleBookSelection() {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            showAlert("Book Selected", "You selected: " + selectedBook.getTitle());
            // Add to cart or show book details logic here
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
