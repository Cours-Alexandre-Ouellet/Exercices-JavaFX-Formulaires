module edu.uqtr.exercice1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.uqtr.exercice1 to javafx.fxml;
    exports edu.uqtr.exercice1;
}