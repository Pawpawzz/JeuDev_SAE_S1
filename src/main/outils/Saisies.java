package main.outils;

import java.util.Scanner;

import static main.outils.Mathematiques.estUnNombre;

public class Saisies {
    private static Scanner scanner;

    public static void definirScanner(Scanner sc) {
        scanner = sc;
    }

    public static int saisieForcee(String textAffche, int min, int max) {
        //-2 pour signifie que le choix est incorrecte par défaut
        int choix =-2;
        do {
            System.out.println(textAffche);

            String chaineCharChoix = scanner.nextLine();
            if(chaineCharChoix != "") {
                //Permet d'empêcher de saisir des lettres ou toute autre caractère n'étant pas un nombre
                if(estUnNombre(chaineCharChoix)) {
                    choix = Integer.parseInt(chaineCharChoix);
                }
            }


        } while(choix > max || choix < min);

        return choix;
    }

    /**
     * Fonction permettant de savoir un déplacement est sous la forme lx (l est une lettre parmis h, b, g, d) et x est un nombre
     * @param deplacement
     * @return true si valide, false si non valide
     */
    public static boolean deplacementSyntaxeValide(String deplacement) {
        char directionDeplacement = deplacement.charAt(0);

        if(directionDeplacement == 'h' || directionDeplacement == 'b' || directionDeplacement == 'g' || directionDeplacement == 'd')
            if (estUnNombre(deplacement.substring(1)))
                return true;
            else
                return false;
        else
            return false;
    }


    public static boolean directionValide(String valeurSaisie) {
        if(valeurSaisie != "") {
            char direction = valeurSaisie.charAt(0);
            if (direction == 'd' || direction == 'g' || direction == 'h' || direction == 'b')
                return true;
        }

        return false;
    }
    
    public static String prochaineLigne() {
    	return scanner.nextLine();
    }
}
