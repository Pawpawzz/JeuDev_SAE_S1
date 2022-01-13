package main;

import main.affichage.Menu;

import static main.Constantes.VALEUR_ARCHER;
import static main.Constantes.VALEUR_TAUREAU;
import static main.Constantes.TOUR_EVENEMENT;


public class ControlleurCombat {

    public static void lancerCombat() {
        Terrain.genererTerrain(6, false);



        int[] tabEnnemis = {VALEUR_TAUREAU,VALEUR_ARCHER};
        Terrain.placerEnnemis(tabEnnemis);

        int tour = 1;
        boolean evenementFrappe = false;

        while(Joueur.estEnVie()) {
            System.out.println("Tour n°" + tour);
            if (evenementFrappe)
            	Evenement.finEvent();
            if (tour%TOUR_EVENEMENT == 0) {
            	Evenement.debutEvent();
            	evenementFrappe = true;
            }
            Menu.afficherActionsJoueur();
            /*System.out.println(">Mouvement ennemis<");
             */
            Ennemi.effectuerTourEnnemis();
            //System.out.println("[TEST] Tu perds une vie ");*/


            tour+=1;
        }

        System.out.println("Tu as perdu");

    }
}
