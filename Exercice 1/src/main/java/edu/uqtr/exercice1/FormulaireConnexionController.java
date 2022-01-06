package edu.uqtr.exercice1;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Contrôle le formulaire de connexion
 * <p>
 * Si le nom d'utilisateur ou le mot de passe sont vides, alors on affiche une erreur. Sinon, la
 * connexion est envoyée.
 */
public class FormulaireConnexionController {
    @FXML
    private TextField nomUtilisateur;

    @FXML
    private PasswordField motDePasse;

    @FXML
    private Text message;

    @FXML
    protected void onConnecter() {
        if (nomUtilisateur.getText().isBlank() || motDePasse.getText().isBlank()) {
            message.setText("Veuillez entrer un nom d'utilisateur et un mot de passe");
        } else {
            message.setText(String.format("Tentative de connexion\nUtilisateur : %s\nMot de passe : %s",
                    nomUtilisateur.getText(), motDePasse.getText()));
        }
    }

    @FXML
    protected void onReinitialiser() {
        nomUtilisateur.setText("");
        motDePasse.setText("");
        message.setText("");
    }
}