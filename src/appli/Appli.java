package appli;

import java.util.Scanner;
import echec.Partie;

public class Appli {
    public static void main(String[] args) throws InterruptedException {
    
    	
    	
        Partie jeu = null;
        Scanner sc = new Scanner(System.in);
        String s = "tmp";

        System.out.println(toStringMenu());
        while(!(s.equals("1") || s.equals("2") || s.equals("3"))) {
            System.out.print("> ");
            s = sc.nextLine();
        }

        if(s.equals("1")) {
            jeu = new Partie("Humain", "Humain");
            while (!jeu.fin()) {
                System.out.println(jeu.getEchiquier());
                System.out.print("> ");
                s = sc.nextLine();
                while (!jeu.abandon(s) && !(estValide(s)
                        && jeu.estPossible(s) && !jeu.donneEchec(s))) {
                    System.out.print("#> ");
                    s = sc.nextLine();
                }
                if(jeu.abandon(s))
                    break;
                jeu.jouer(s);
            }
        }

        if(s.equals("2")) {
            jeu = new Partie("Humain", "IA");
            while (!jeu.fin()) {
                System.out.println(jeu.getEchiquier());
                System.out.print("> ");
                s = sc.nextLine();

                while (!jeu.abandon(s) && !(estValide(s)
                        && jeu.estPossible(s) && !jeu.donneEchec(s))) {
                    System.out.print("#> ");
                    s = sc.nextLine();
                }
                if(jeu.abandon(s))
                    break;
                jeu.jouer(s);
                System.out.println(jeu.getEchiquier());
                if(!jeu.fin()) {
                    jeu.jouer(s);
                    Thread.sleep(1000);
                }
            }
        }

        if(s.equals("3")) {
            jeu = new Partie("IA", "IA");
            while (!jeu.fin()) {
                System.out.println(jeu.getEchiquier());
                jeu.jouer(s);

                Thread.sleep(1000);
            }
        }

        System.out.println(jeu.getEchiquier());
        System.out.print(jeu.toStringFin(s));
    }

    /**
     * Affiche le menu pour choisir le mode de jeu
     * @return s le menu
     */
    private static String toStringMenu() {
        String s = "Saisissez un chiffre selon le mode désiré : \n";
        s += "1. Humain VS Humain\n";
        s += "2. Humain VS IA\n";
        s += "3. IA VS IA\n";
        return s;
    }

    /**
     * Vérifie que le coup saisi est valide
     * @param s le coup saisi
     * @return true si la saisie du coup est valide
     */
    public static boolean estValide(String s) {
        // on efface les espaces (\\s+)
        s = s.replaceAll("\\s+","");
        s = s.toLowerCase();

        if(s.length() == 0)
            return true;

        if(s.length() != 4)
            return false;

        if(!Character.isDigit(s.charAt(1))
                || !Character.isDigit(s.charAt(3)))
            return false;

        if(Character.isDigit(s.charAt(0))
                || Character.isDigit(s.charAt(2)))
            return false;

        if(s.charAt(0) > 'h' || s.charAt(2) > 'h')
            return false;

        if(Character.getNumericValue(s.charAt(1)) > 8
                || Character.getNumericValue(s.charAt(1)) < 1
                || Character.getNumericValue(s.charAt(3)) > 8
                || Character.getNumericValue(s.charAt(3)) < 1)
            return false;

        return true;
    }

}
