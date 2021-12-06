module com.example.exampleapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exampleapp to javafx.fxml;
    exports com.example.exampleapp;
}