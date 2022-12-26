package echec.pieces;

import echec.Coordonnée;
import echec.Echiquier;

import java.util.ArrayList;

public class Pièce {

    protected String couleur;
    protected String type;
    protected int ligne; // ligne
    protected int colonne; // colonne

    /**
     * Constructeur d'une Pièce
     * @param couleur
     * @param ligne
     * @param colonne
     */
    
    public Pièce(String couleur, int ligne, int colonne) {
        this.couleur = couleur;
        setCoordonnée(ligne, colonne);
    }

    /**
     * Ajoute dans une liste tous les coups possibles d'une pièce sur l'échiquier
     * @param e l'échiquier actuel
     * @return null
     */
    public ArrayList<Coordonnée> coupsPossibles(Echiquier e) { return null; }

    /**
     * Retourne la ligne d'une pièce
     * @return ligne
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Retourne la colonne d'une pièce
     * @return colonne
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * Retourne la couleur d'une pièce
     * @return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Retourne le type de la pièce
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Modifie les coordonnées ligne et colonne
     * @param ligne
     * @param colonne
     */
    public void setCoordonnée(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    /**
     * Déplace la pièce aux coordonnées d'arrivée
     * @param e l'échiquier actuel
     * @param départ
     * @param arrivée
     */
    public void déplacer(Echiquier e, Coordonnée départ, Coordonnée arrivée) {
        int x = départ.getLigne(), ligne = arrivée.getLigne();
        int y = départ.getColonne(), colonne = arrivée.getColonne();


        e.setPièce(x, y, null);
        setCoordonnée(ligne, colonne);
        e.setPièce(ligne, colonne, this);
    }

    /**
     * Vérifie qu'un coup est possible pour la pièce
     * @param e l'échiquier actuel
     * @param x la ligne
     * @param y la colonne
     * @return false
     */
    public boolean estPossible(Echiquier e, int x, int y) { return false; }

    /**
     * Retourne le caractère représentant la pièce
     * @return ' '
     */
    public char getSymbole() { return ' '; }

    /**
     * Retourne la couleur et les coordonnées de la pièce
     * @return s L'affichage de la couleur et des coordonnées
     */
    public String toString() {
        String s = couleur;
        Coordonnée c = new Coordonnée(ligne, colonne);
        s += c.toString();
        return s;
    }

    /**
     * Place toutes les pièces sur l'échiquier
     * @param e echiquier
     */
    public static void setEchiquier(Echiquier e) {
       
       
         // blanc 
        e.setPièce(7, 3, new Reine("BLANC", 7, 3));
        e.setPièce(7, 6, e.getRoiBlanc());

        // noir
        e.setPièce(7, 7, e.getRoiNoir());
    }
}
