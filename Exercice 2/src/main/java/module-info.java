module edu.uqtr.exercice2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.uqtr.exercice2 to javafx.fxml;
    exports edu.uqtr.exercice2;
}