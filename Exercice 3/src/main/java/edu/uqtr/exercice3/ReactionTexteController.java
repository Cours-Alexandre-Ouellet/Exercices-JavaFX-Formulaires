package edu.uqtr.exercice3;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class ReactionTexteController {
    @FXML
    private Text message;

    @FXML
    public void onToucheRelachee(KeyEvent evenement) {
        // On convertit en noeud TextField -- attention de toujours déclencher cet événement sur un textField
        // autrement il va y avoir une erreur de cast.
        if(!(evenement.getSource() instanceof TextField)) {
            return;
        }

        TextField zone = (TextField) evenement.getSource();
        String textFieldId = zone.getId();

        message.setText(String.format("Touche « %s » pressée dans %s", evenement.getText(), textFieldId));

        zone.setText("");
    }
}