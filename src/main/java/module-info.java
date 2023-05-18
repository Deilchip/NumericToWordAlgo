module com.example.testproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.testproject to javafx.fxml;
    exports com.example.testproject;
}