module edu.uqtr.exercice3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.uqtr.exercice3 to javafx.fxml;
    exports edu.uqtr.exercice3;
}