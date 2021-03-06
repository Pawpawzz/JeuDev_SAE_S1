package main.affichage;

import main.*;
import main.outils.Chemin;
import main.outils.Saisies;

import java.util.Scanner;

import static main.outils.Saisies.*;

public class Menu {

    public static Scanner scanner;

    public static void afficherMenuPrincipal() {
        System.out.println("Bienvenue dans RodgeLike");

        switch(saisieForcee("1. Jouer\n2. Boutique\n3. Tutoriel\n4. Quitter", 1, 4)) {
            case 1:
                System.out.print("Lancement du jeu");
                System.out.println("\uD83D\uDD2B");
                //Console.afficherBarreChargement();

                ControlleurCombat.lancerCombat();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                switch (saisieForcee("Êtes-vous sûr(e) de vouloir quitter ? \n1. Oui\n2. Non", 1, 2)) {
                    case 1:
                        System.out.println("Désolé nous vous rembourserons :(");
                        return;
                    case 2:
                        afficherMenuPrincipal();
                    default:
                        break;
                }
        }
    }

    public static void afficherActionsJoueur() {
        AffichagePersonnages.afficherNombreVie();
        AffichageTerrain.afficher();
        //Chemin.afficherTableau(Terrain.recupererTerrain());
        int[] positionJoueur = Joueur.positionJoueur();
        char direction;

        switch (saisieForcee("1. Se déplacer\n2. Grappin\n3. Charge\n4. Saut", 1, 4)) {
            case 1:
                String deplacement;
                do {
                    System.out.print("Format : nx (n = {g, d, h, v}, x est un nombre) :");
                    deplacement = Saisies.prochaineLigne();
                }
                while(!deplacementSyntaxeValide(deplacement) && deplacement.charAt(0) != 'r');

                if(deplacement.charAt(0) != 'r')
                    Joueur.deplacement(deplacement);
                else
                    afficherActionsJoueur();

                break;

            case 2:

                do {
                    System.out.print("Quel direction ? : ");
                    deplacement = Saisies.prochaineLigne();

                } while(!directionValide(deplacement) && deplacement.charAt(0) != 'r');

                direction = deplacement.charAt(0);

                if(direction == 'r')
                    afficherActionsJoueur();
                else
                    Competences.grappin(direction, positionJoueur);

                break;
            case 3:
                do {
                    System.out.print("Quel direction ? : ");
                    deplacement = Saisies.prochaineLigne();

                } while(!directionValide(deplacement) && deplacement.charAt(0) != 'r');

                direction = deplacement.charAt(0);

                if(direction == 'r')
                    afficherActionsJoueur();
                else
                    Competences.charge(direction, positionJoueur);

                break;
            case 4:
                do {
                    System.out.print("Quel direction ? : ");
                    deplacement = Saisies.prochaineLigne();

                } while(!directionValide(deplacement) && deplacement.charAt(0) != 'r');

                direction = deplacement.charAt(0);

                if(direction == 'r')
                    afficherActionsJoueur();
                else
                    Competences.saut(direction, positionJoueur);
                break;
        }

    }


}
