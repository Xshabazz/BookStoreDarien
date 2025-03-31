package com.example.bookstorefinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookstore",
                    "root",
                    "xzlkjc(8sdfj&f"
            );
            System.out.println("Connected to the database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        launch();
    }
}