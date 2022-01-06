module com.example.exercice4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercice4 to javafx.fxml;
    exports com.example.exercice4;
}