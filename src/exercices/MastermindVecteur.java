package exercices;

import batailleNavalle.Saisies;

public class MastermindVecteur {

	public static void main(String[] args) {
		final int max = 12;

		char combinaison[] = new char[4], proposition[] = new char[4];
		char couleurs[] = {'R', 'J', 'B', 'O', 'V', 'C', 'T', 'S'};
		String nomCouleurs[] = {"Rouge (R)", "Jaune (J)", "Bleu (B)", "Orange (O)", "Vert (V)", "Blanc (C)", "Violet (T)", "Rose (S)"};
		//Rouge, Jaune, Bleu, Orange, Vert, Blanc, Violet, Rose
		String difficulte = "";
		String mode = "";
		boolean trouve = false, comp[] = new boolean[4];
		int essais = 0, nbrMalPlaces = 0, nbrBienPlaces = 0;

		System.out.println("D�but Mastermind");
		do {
			difficulte = Saisies.saisieString("Choisissez la difficulte (Facile ou Difficile)");
		}while(!difficulte.equalsIgnoreCase("Facile") && !difficulte.equalsIgnoreCase("Difficile"));

		do {
			mode = Saisies.saisieString("Entrer la combinaison manuellement ou laisser l'ordinateur le faire ?\n(Manuel ou Auto)");
		}while(!mode.equalsIgnoreCase("Manuel") && !mode.equalsIgnoreCase("Auto") && !mode.equalsIgnoreCase("Debug"));

		System.out.println("Les couleurs possibles sont :");
		Tableau.afficherVecteur(nomCouleurs);

		if(mode.equalsIgnoreCase("Manuel")) {
			System.out.println("Un caract�re doit correspondre � une couleur de la liste.");
			combinaisonManuelle(combinaison, couleurs, difficulte);
		}
		else if(mode.equalsIgnoreCase("Debug")){
			combinaisonAuto(combinaison, couleurs, difficulte);
			Tableau.afficherVecteur(combinaison);
		}
		else {
			combinaisonAuto(combinaison, couleurs, difficulte);
		}

		//boucle du jeu
		while(!trouve && essais < max) {
			System.out.println("Il reste " + (max - essais) + " coups.");
			nbrMalPlaces = 0;
			nbrBienPlaces=0;
			//1) L'utilisateur entre les caract�res
			combinaisonJoueur(proposition, couleurs);

			//2) V�rification des caract�res
			for(int i=0; i < combinaison.length;i++) {
				if(combinaison[i] == proposition[i]) {
					nbrBienPlaces++;
					comp[i] = true;
				}
				else {
					comp[i] = false;
				}
			}

			//3) On verifie si l'utilisateur a trouve
			if(nbrBienPlaces==4)
				trouve = true;
			else {
				//On v�rifie s'il a mal plac� certains
				for(int i=0; i < combinaison.length;i++) {
					if(!comp[i]) {//si faux, si vrai alors bien place et on ne fait rien
						for(int j=0;j < proposition.length; j++) {
							if(combinaison[j] == proposition[i] && !comp[j])
								nbrMalPlaces++;
						}
					}
				}
			}

			if(!trouve) {
				System.out.println("Caract�res bien plac�s : " + nbrBienPlaces);
				System.out.println("Caract�res mal plac�s : " + nbrMalPlaces);
				essais++;
				//calcul des caract�res mal plac�s
			}
			else {
				if(essais > 0)
					System.out.println("Bravo ! Vous avez trouv� en " + essais + " coups.");
				else
					System.out.println("Bravo ! Vous avez trouv� ... du premier coup.");
			}
		}
		if(!trouve && !(essais < max)) {
			System.out.println("Dommage ! Vous n'avez pas r�ussi � trouver la combinaison en 12 coups.");
			System.out.println("La combinaison �tait :");
			Tableau.afficherVecteur(combinaison);
		}


	}

	public static void combinaisonManuelle(char tab[], char couleurs[], String difficulte) {
		boolean valide;
		for(int i=0;i < tab.length;i++) {
			do {
				valide = false;
				tab[i] = Character.toUpperCase(Saisies.saisieChar("Entrez la couleur " + (i+1)));
				for(int j=0; j < couleurs.length && !valide; j++) {//on verifie si la couleur est valide
					if(tab[i] == couleurs[j])
						valide = true;
				}
				if(!valide)
					System.out.println("Attention. Choix de couleurs incorrecte.");
				if(difficulte.equalsIgnoreCase("Facile")) {
					//En facile, il ne peut y avoir de r�p�tition
					for(int j=0; j < i && valide; j++) {
						if(tab[i] == tab[j]) {
							valide = false;
							System.out.println("Attention. En mode facile, il ne peut y avoir de r�p�tition.");
						}
					}
				}
			}while(!valide);
		}
	}

	public static void combinaisonJoueur(char tab[], char couleurs[]) {
		boolean valide;
		String saisie="";
		char tab2[] = new char[4];
		do {
			valide = false;
			saisie = Saisies.saisieString("Entrez une combinaison :").toUpperCase();
			if(saisie.length() != 4) {
				System.out.println("Attention. Une combinaison doit �tre compos�e de 4 couleurs.");
			}
			else {
				tab2 = saisie.toCharArray();
				for(int i=0;i<tab.length;i++) {
					valide = false;
					for(int j=0; j < couleurs.length && !valide; j++) {//on verifie si la combinaison est valide
						if(tab2[i] == couleurs[j]) {
							valide = true;
							tab[i] = tab2[i];
						}
					}
				}
				if(!valide)
					System.out.println("Attention. Choix de couleurs incorrecte.");
			}
		}while(!valide);
	}

	public static void combinaisonAuto(char tab[], char couleurs[], String difficulte) {
		boolean rep;
		for(int i=0;i < tab.length;i++) {
			do {
				rep = false;
				tab[i] = couleurAleatoire(couleurs);
				if(difficulte.equalsIgnoreCase("Facile")) {
					for(int j=0; j<i && !rep;j++) {
						if(tab[j] == tab[i]) {
							rep=true;
						}
					}
				}
			}while(rep);
		}
	}

	public static char couleurAleatoire(char couleurs[]) {
		int indice = (int)(Math.random()*couleurs.length);
		return couleurs[indice];
	}

}
