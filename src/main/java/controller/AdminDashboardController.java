package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Book;
import model.User;
import model.Order;
import service.AdminService;

import java.util.List;

public class AdminDashboardController {

    @FXML private TableView<Book> bookTable;
    @FXML private TableColumn<Book, Integer> bookIdColumn;
    @FXML private TableColumn<Book, String> bookTitleColumn;
    @FXML private TableColumn<Book, String> bookAuthorColumn;
    @FXML private TableColumn<Book, String> bookGenreColumn;
    @FXML private TableColumn<Book, Double> bookPriceColumn;

    @FXML private TableView<User> userTable;
    @FXML private TableColumn<User, Integer> userIdColumn;
    @FXML private TableColumn<User, String> userUsernameColumn;
    @FXML private TableColumn<User, String> userRoleColumn;

    @FXML private TableView<Order> orderTable;
    @FXML private TableColumn<Order, Integer> orderIdColumn;
    @FXML private TableColumn<Order, Integer> orderUserIdColumn;
    @FXML private TableColumn<Order, Integer> orderBookIdColumn;
    @FXML private TableColumn<Order, String> orderDateColumn;

    private AdminService adminService;

    public AdminDashboardController() {
        adminService = new AdminService();
    }

    @FXML
    public void initialize() {
        /*
        bookIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        bookTitleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        bookAuthorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        bookGenreColumn.setCellValueFactory(cellData -> cellData.getValue().genreProperty());
        bookPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());


        userIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        userUsernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        userRoleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());


        orderIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        orderUserIdColumn.setCellValueFactory(cellData -> cellData.getValue().userIdProperty().asObject());
        orderBookIdColumn.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty().asObject());
        orderDateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());


        loadBooks();
        loadUsers();
        loadOrders();
    }

    private void loadBooks() {
        List<Book> books = adminService.getAllBooks();
        bookTable.getItems().setAll(books);
    }

    private void loadUsers() {
        List<User> users = adminService.getAllUsers();
        userTable.getItems().setAll(users);
    }

    private void loadOrders() {
        List<Order> orders = adminService.getAllOrders();
        orderTable.getItems().setAll(orders);
    }

    @FXML
    public void addBook() {

    }

    @FXML
    public void deleteBook() {

    }

    @FXML
    public void addUser() {

    }

    @FXML
    public void deleteUser() {

    }

    @FXML
    public void viewOrder() {

    }

    @FXML
    public void deleteOrder() {

    }*/
}}
