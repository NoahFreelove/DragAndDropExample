module com.draganddropexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.draganddropexample to javafx.fxml;
    exports com.draganddropexample;
}