module com.example.testproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.testproject to javafx.fxml;
    exports com.example.testproject;
    exports com.example.testproject.digit;
    exports com.example.testproject.input;
    exports com.example.testproject.extensions;
    opens com.example.testproject.extensions to javafx.fxml;
    exports com.example.testproject.sufix;
    opens com.example.testproject.sufix to javafx.fxml;
    exports com.example.testproject.constants;
    opens com.example.testproject.constants to javafx.fxml;
}