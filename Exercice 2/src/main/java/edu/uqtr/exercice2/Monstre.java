package edu.uqtr.exercice2;

/**
 * Représente un monstre créé par l'utilisateur
 */
public class Monstre {

    /**
     * Nom du monstre
     */
    private String nom;

    /**
     * Point de vie (devrait être positif)
     */
    private int vie;

    /**
     * Famille du monstre
     */
    private String famille;

    /**
     * Element du monstre
     */
    private String element;

    /**
     * Niveau de difficulté du monstre
     */
    private String difficulte;

    /**
     * Crée un nouveau monstre
     * @param nom le nom du monstre
     * @param vie la vie du monstre
     * @param famille la famille du monstre
     * @param element l'élément du monstre
     * @param difficulte le niveau de difficulté du monstre
     */
    public Monstre(String nom, int vie, String famille, String element, String difficulte) {
        this.nom = nom;
        this.vie = vie;
        this.famille = famille;
        this.element = element;
        this.difficulte = difficulte;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Monstre{" +
                "nom='" + nom + '\'' +
                ", vie=" + vie +
                ", famille='" + famille + '\'' +
                ", element='" + element + '\'' +
                ", difficulte='" + difficulte + '\'' +
                '}';
    }
}
