package com.example.exercice4;

import javafx.fxml.FXML;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Contrôle le déplacement de la forme
 */
public class DeplacerFormeController {

    @FXML
    private Text message;

    @FXML
    private Rectangle carre;

    /**
     * Position autorisées pour le carré
     */
    private BoundingBox limitesCarre;

    /**
     * Indique si la souris se trouve au-dessus du rectangle
     */
    private boolean estSurCarre;

    /**
     * Position de la souris
     */
    // Point2D permet de stocker une coordonée en X et une en Y
    private Point2D positionSouris;

    /**
     * Initialise le contrôleur
     */
    public DeplacerFormeController() {
        estSurCarre = false;
        positionSouris = new Point2D(0, 0);
        limitesCarre = new BoundingBox(0.0, 0.0, 400.0, 400.0);
    }

    /**
     * Clic gauche dans la zone
     * @param event
     */
    @FXML
    public void onSourisClicZone(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            deplacerCarre(event.getX(), event.getY());
        }

        afficherMessage();
    }

    /**
     * Déplacement de la souris dans la zone
     * @param event
     */
    @FXML
    public void onSourisDeplacerZone(MouseEvent event) {
        positionSouris = new Point2D(event.getX(), event.getY());
        afficherMessage();
    }

    /**
     * Glissement de la souris dans la zone
     * @param event
     */
    @FXML
    public void onSourisGlisserZone(MouseEvent event) {
        if (event.getButton() != MouseButton.SECONDARY) {
            return;
        }

        positionSouris = new Point2D(event.getX(), event.getY());
        deplacerCarre(positionSouris.getX(), positionSouris.getY());
        afficherMessage();
    }

    /**
     * La souris entre au-dessus du carré
     */
    @FXML
    public void onSourisEntreeRectangle() {
        estSurCarre = true;
        afficherMessage();
    }

    /**
     * La souris sort d'au-dessus du carré
     */
    @FXML
    public void onSourisSortieRectangle() {
        estSurCarre = false;
        afficherMessage();
    }

    /**
     * Affiche le message concernant la souris
     */
    private void afficherMessage() {
        String infoSouris = String.format("La souris est à la position %d, %d.\n", (int) positionSouris.getX(),
                (int) positionSouris.getY());

        infoSouris += (estSurCarre) ? "La souris est au-dessus du carre" : "La souris n'est pas au-dessus du carré";

        message.setText(infoSouris);
    }

    /**
     * Déplace le carré à la position indiquée
     *
     * @param x la coordonnée en x
     * @param y la coordonnée en y
     */
    private void deplacerCarre(double x, double y) {
        if(!limitesCarre.contains(x, y)) {
            return;
        }

        carre.setX(x - carre.getWidth() / 2);
        carre.setY(y - carre.getHeight() / 2);
    }
}