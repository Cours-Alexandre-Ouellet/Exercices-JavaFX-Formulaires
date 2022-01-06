package edu.uqtr.exercice2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Gère la création des monstres
 */
public class CreationMonstreController {

    @FXML
    private TextField nouvelleFamille;

    @FXML
    private TextField nomMonstre;

    @FXML
    private TextField vieMonstre;

    @FXML
    private ChoiceBox niveauDifficulte;

    @FXML
    private RadioButton elementAir;

    @FXML
    private RadioButton elementEau;

    @FXML
    private RadioButton elementFeu;

    @FXML
    private RadioButton elementTerre;

    @FXML
    private ChoiceBox famille;

    @FXML
    private Text message;

    @FXML
    private Text nombreMonstres;

    /**
     * Contient toutes les familles définies par l'utilsateur
     */
    private ObservableList<String> listeFamilles;

    /**
     * Contient les monstres créés
     */
    private ArrayList<Monstre> monstres;

    /**
     * Constructeur du contrôleur de monstre
     */
    public CreationMonstreController() {
        // Comme ce n'est pas un champs de JavaFX, on l'initialise dans le constructeur
        monstres = new ArrayList<>();
        listeFamilles = FXCollections.observableArrayList();
    }

    /**
     * Crée la liste des familles et initilise les choix
     */
    @FXML
    public void initialize() {
        // famille étant un élément JavaFX, il faut l'initialiser ici
        famille.setItems(listeFamilles);
    }

    /**
     * Ajoute une nouvelle famille
     */
    @FXML
    public void onAjoutFamille() {
        // Récupération de la valeur
        String nomNouvelleFamille = nouvelleFamille.getText();

        // Ajout à la liste
        listeFamilles.add(nomNouvelleFamille);

        // Réinitialisation du champ
        nouvelleFamille.setText("");
    }

    /**
     * Ajoute un nouveau monstre à la liste
     */
    @FXML
    public void onAjoutMonstre() {
        String nomMonstreValeur = nomMonstre.getText();
        String vieMonstreValeur = vieMonstre.getText();
        int vieMonstreEntier = validerVieMonstre(vieMonstreValeur);

        if (vieMonstreEntier == -1) {
            message.setText("La vie du monstre est invalide");
            return;
        }

        // Ici le cast est nécessaire, car getValue retourne un Object
        String niveauDifficulteValeur = (String) niveauDifficulte.getValue();

        String element = trouverElementSelectionner();
        String familleValeur = (String) famille.getValue();

        Monstre nouveauMonstre = new Monstre(nomMonstreValeur, vieMonstreEntier, familleValeur,
                element, niveauDifficulteValeur);
        System.out.println("Ajout du monstre : " + nouveauMonstre);

        monstres.add(nouveauMonstre);
        message.setText("Le monstre a été ajouté");
        nombreMonstres.setText(String.format("Il y a %d monstre%s de créé%s",
                monstres.size(),
                (monstres.size() >= 2) ? "s" : "",
                (monstres.size() >= 2) ? "s" : ""));

        reinitialiserChamps();
    }

    /**
     * Réinitialise tous les champs du formulaire
     */
    // C'est essentiel de rassembler le code dans un méthode
    // Autrement, nos autres méthodes seraient trop longues
    // De plus, si l'on avait un bouton réinitialiser, on pourrait simplement
    // appeler cette méthode;
    private void reinitialiserChamps() {
        nomMonstre.setText("");
        vieMonstre.setText("");
        niveauDifficulte.setValue("Choisissez une difficulté");
        elementAir.setSelected(false);
        elementEau.setSelected(false);
        elementFeu.setSelected(false);
        elementTerre.setSelected(false);
        famille.setValue("Choisissez une famille");
    }

    /**
     * Convertie la vie du monstre (string) en entier
     *
     * @param valeur la valeur en string à convertir
     * @return la valeur entière ou -1 si une erreur se produit (le nombre est négatif ou il n'est pas entier).
     */
    private int validerVieMonstre(String valeur) {
        try {
            int vieMonstre = Integer.parseInt(valeur);

            if (vieMonstre > 0) {
                return vieMonstre;
            } else {
                return -1;
            }
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    /**
     * Retourne l'élément sélectionné par l'utilisateur ou la chaîne Aucun, si aucun élément n'a
     * été sélectionné
     *
     * @return le nom de l'élément ou aucun
     */
    private String trouverElementSelectionner() {
        if (elementAir.isSelected()) {
            return "air";
        } else if (elementEau.isSelected()) {
            return "eau";
        } else if (elementFeu.isSelected()) {
            return "feu";
        } else if (elementTerre.isSelected()) {
            return "terre";
        } else {
            return "aucun";
        }
    }
}