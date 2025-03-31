module com.example.bookstorefinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.bookstorefinal to javafx.fxml;
    exports com.example.bookstorefinal;
}