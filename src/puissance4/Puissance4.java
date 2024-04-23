package puissance4;

public class Puissance4 {

	public static void main(String[] args) {
		int lignes = 6, colonnes = 7, nbrCoupsMax = lignes*colonnes;
		int choix = 0, numero, nbrCoups;
		char[][] grille = new char[lignes][colonnes];
		Mode mode = Mode.MULTI;
		
		do {
			choix = Saisies.lectureInt("Mode de jeu : solo(1), multi(2)");
		}while(choix != 1 && choix != 2);
		
		if(choix == 1) {
			mode = Mode.SOLO;
		}
		else{
			mode = Mode.MULTI;
		}
		
		//creation des joueurs
		Joueur joueurs[] = new Joueur[2];
		joueurs[0] = new Humain();
		switch(mode) {
		case SOLO:
			joueurs[1] = new IA();
			break;
		case MULTI:
			joueurs[1] = new Humain();
			break;
		}
		
		Joueur joueurDuTour, joueurSuivant, memoire;
		//"pointeurs" pour alterner entre les joueurs et permuter
		
		joueurs[0].afficherPion();
		joueurs[1].afficherPion();
		System.out.println("Entrer un nombre negatif quitte le programme.");
		
		do {
			//Initialisation
			numero = Outils.randomPileOuFace();
			joueurSuivant = joueurs[numero];
			joueurDuTour = joueurs[Math.abs(numero-1)];
			resetGrille(grille);
			nbrCoups = 0;
			joueurSuivant.reset();
			joueurDuTour.reset();
			afficherGrille(grille);
			
			//Boucle principale -> 1 boucle = 1 tour pour 1 joueur
			do {
				//Permutation
				memoire = joueurDuTour;
				joueurDuTour = joueurSuivant;
				joueurSuivant = memoire;
				nbrCoups++;
				
				//Le joueur du tour place un pion dans la grille
				joueurDuTour.afficherNom();
				if(!joueurDuTour.jouer(grille)) {
					if(joueurSuivant instanceof IA && joueurDuTour instanceof Humain) {
						((IA) joueurSuivant).watch(((Humain) joueurDuTour).getCoup());
					}
					afficherGrille(grille);
				}
				
			}while(!joueurDuTour.aGagne() && nbrCoups < nbrCoupsMax && !joueurDuTour.aAbandonne());
			
			if(joueurDuTour.aGagne()) {
				System.out.println(joueurDuTour.getNom() + " gagne !");
			}
			else if(joueurDuTour.aAbandonne()) {
				System.out.println(joueurDuTour.getNom() + " abandonne.");
				System.out.println(joueurSuivant.getNom() + " est donc vainqueur.");
			}
			else {
				System.out.println("Match nul. Le grille est remplie.");
			}
			
			do {
				choix = Saisies.lectureInt("Voulez-vous recommencer ? oui(1)/non(0)");
			}while(choix != 0 && choix != 1);
		}while(choix == 1);
		
		System.out.println("Fin du programme");
		
	}
	
	public static void resetGrille(char[][] grille) {
		for(int i=0; i < grille.length;i++) {
			for(int j = 0; j < grille[0].length; j++) {
				grille[i][j] = ' ';
			}
		}
	}
	
	public static void afficherGrille(char[][] grille) {
		for(int i=grille.length-1; i >= 0;i--) {
			System.out.print("|");
			for(int j = 0; j < grille[0].length; j++) {
				System.out.print(grille[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println("---------------");
		System.out.println("|1|2|3|4|5|6|7|");
		System.out.println("---------------");
	}

}
