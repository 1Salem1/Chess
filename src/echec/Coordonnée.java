package echec;

import java.util.ArrayList;

public class Coordonnée {
    private int ligne;
    private int colonne; 

    /**
     * Constructeur d'une Coordonnée
     * @param x ligne
     * @param y colonne
     */
    public Coordonnée(int x, int y) {
        this.ligne = x;
        this.colonne = y;
    }

    /**
     * Retourne la coordonnée (un entier) d'une ligne
     * @return ligne
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Retourne la coordonnée (un entier) d'une colonne
     * @return colonne
     */
    public int getColonne() {
        return colonne;
    }

   //ffiche les coordonnées ligne et colonne
  
    public String toString(){
        return "[" + ligne + ", " + colonne + "]";
    }

    
     //onvertit le coup du joueur en coordonnées (entiers)

    public static Coordonnée[] stringToInt(String s) {
        ArrayList<Character> nombres = new ArrayList<>();
        nombres.add('8');
        nombres.add('7');
        nombres.add('6');
        nombres.add('5');
        nombres.add('4');
        nombres.add('3'); 
        nombres.add('2');
        nombres.add('1');

        // supprimer les espaces vides fournis par l'utilisateur
        s = s.replaceAll("\\s+","");
        
        s = s.toLowerCase();
        Coordonnée départ =
                new Coordonnée(nombres.indexOf(s.charAt(1)),
                        (int) s.charAt(0) - 97);
        Coordonnée arrivée =
                new Coordonnée(nombres.indexOf(s.charAt(3)),
                		
              // code ASCII de a est 97
                        (int) s.charAt(2) - 97);
        Coordonnée[] c = { départ, arrivée };
        return c;
    }

     //onvertit les coordonnées en coup (String)
    public static String intToString(Coordonnée départ, Coordonnée arrivée) {
        ArrayList<String> lettre = new ArrayList<>();
        lettre.add("a"); lettre.add("b"); lettre.add("c"); lettre.add("d");
        lettre.add("e"); lettre.add("f"); lettre.add("g"); lettre.add("h");

        ArrayList<String> chiffre = new ArrayList<>();
        chiffre.add("8"); chiffre.add("7"); chiffre.add("6"); chiffre.add("5");
        chiffre.add("4"); chiffre.add("3"); chiffre.add("2"); chiffre.add("1");

        String s = lettre.get(départ.getColonne()) + chiffre.get(départ.getLigne());
        s += lettre.get(arrivée.getColonne()) + chiffre.get(arrivée.getLigne());
        return s;
    }

}