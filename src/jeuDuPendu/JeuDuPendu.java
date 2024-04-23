package jeuDuPendu;

import java.util.ArrayList;

public class JeuDuPendu {

	public static void main(String[] args) {
		String mots[] = {
				"POMME",
				"ROUGE",
				"NOIR",
				"LUNETTES",
				"HABIT",
				"ARBRE",
				"FEUILLE",
				"BANANE",
				"ORANGE",
				"CHAT",
				"VOITURE"
		};
		
		String dessin[];
		boolean gagne;
		int choix;
		char[] mot, motJoueur;
		int nbrEssais, lettresTrouvees[] = new int[1];
		final int NBRESSAISMAX = 10;
		char lettre;
		ArrayList<Character> lettresTestees = new ArrayList<Character>();
		
		do {
			//Initialisation
			//fin = false;
			dessin = resetDessin();
			gagne = false;
			choix = 0;
			nbrEssais = 0;
			lettresTrouvees[0] = 0;
			lettresTestees.clear();
			mot = tirageMot(mots).toCharArray();
			motJoueur = new char[mot.length];
			for(int i=0;i<motJoueur.length;i++) {
				motJoueur[i] = '-';
			}
			//Boucle principale
			do {
				//Affichage a la console
				affichagePendu(dessin, motJoueur, NBRESSAISMAX-nbrEssais, lettresTestees);
				//Demande d'une lettre (conversion en majuscule)
				lettre = Saisies.saisieCharMaj("Entrez une lettre");
				//Verification de la lettre et modification du dessin
				if(!verificationLettre(mot, lettre, motJoueur, lettresTrouvees, lettresTestees)) {
					nbrEssais++;
					modificationDessin(dessin,nbrEssais);
				}
				
				if(lettresTrouvees[0] == mot.length)
					gagne = true;
				
			}while(!gagne && nbrEssais < NBRESSAISMAX);
			
			//Fin du jeu
			if(gagne) {
				System.out.println("Bravo ! Vous avez trouvé le mot mystère");
			}
			else {
				modificationDessin(dessin,nbrEssais);
				afficherDessin(dessin);
				System.out.println("Vous n'avez pas trouve le mot à temps ...");
				System.out.println("Le mot mystere etait : " + new String(mot));
			}
			
			do {
				choix = Saisies.lectureInt("Voulez-vous recommencer ? oui(1)/non(0)");
			}while(choix != 0 && choix != 1);
		}while(choix == 1);
		
		System.out.println("Fin du programme");
		
	}
	
	public static String[] resetDessin() {
		String dessin[] = {
				"  |-------- ",
				"  |  /    | ",
				"  | /       ",
				"  |/        ",
				"  |         ",
				"  |         ",
				"  |         ",
				"  |         ",
				" /|\\         ",
				"/---\\        "
		};
		
		return dessin;
	}
	
	public static boolean verificationLettre(char[] mot, char lettre, char[] motJoueur, int lettresTrouvees[], ArrayList<Character> lettresTestees) {
		boolean trouve = false, doublon = false;
		for(int i=0;i<mot.length && !doublon;i++) {
			if(mot[i] == lettre) {
				if(motJoueur[i] == '-') {
					trouve = true;
					motJoueur[i] = lettre;
					lettresTrouvees[0]++;
				}
				else if(mot[i] == motJoueur[i]) {
					if(!doublon) {
						System.out.println("Le caractere a deja ete entre");
						doublon = true;
					}
				}
				else {
					System.out.println("Erreur. Mot et mot joueur ne matchent pas");
				}
			}
		}
		if(doublon == false && trouve == false) {
			System.out.println("Lettre pas dans le mot !");
			//On verifie si la lettre n'a pas deja ete testee
			for(int i=0;i<lettresTestees.size() && !trouve;i++) {
				if(lettresTestees.get(i) == lettre) {
					trouve = true;
				}
			}
			if(trouve == false) {
				lettresTestees.add(lettre);
			}
			else {
				trouve = false;
			}
		}
		else if(trouve == true){
			System.out.println("Bonne lettre !");
		}
		
		return trouve;
	}
	
	public static void modificationDessin(String[] dessin, int nbrEssais) {
		char ligne[];
		switch(nbrEssais) {
		case 1:
			ligne = dessin[2].toCharArray();
			ligne[9] = '(';
			dessin[2] = new String(ligne);
			break;
		case 2:
			ligne = dessin[2].toCharArray();
			ligne[11] = ')';
			dessin[2] = new String(ligne);
			break;
		case 3:
			ligne = dessin[3].toCharArray();
			ligne[10] = '-';
			dessin[3] = new String(ligne);
			break;
		case 4:
			ligne = dessin[4].toCharArray();
			ligne[9] = '/';
			dessin[4] = new String(ligne);
			break;
		case 5:
			ligne = dessin[4].toCharArray();
			ligne[11] = '\\';
			dessin[4] = new String(ligne);
			break;
		case 6:
			ligne = dessin[4].toCharArray();
			ligne[10] = '|';
			dessin[4] = new String(ligne);
			break;
		case 7:
			ligne = dessin[5].toCharArray();
			ligne[10] = '|';
			dessin[5] = new String(ligne);
			break;
		case 8:
			ligne = dessin[6].toCharArray();
			ligne[10] = 'X';
			dessin[6] = new String(ligne);
			break;
		case 9:
			ligne = dessin[7].toCharArray();
			ligne[9] = '/';
			dessin[7] = new String(ligne);
			break;
		case 10:
			ligne = dessin[7].toCharArray();
			ligne[11] = '\\';
			dessin[7] = new String(ligne);
			break;
		}
	}
	
	public static void afficherDessin(String[] dessin) {
		for(int i=0;i<dessin.length;i++) {
			System.out.println(dessin[i]);
		}
		System.out.println();
	}
	
	public static void affichagePendu(String[] dessin, char[] motJoueur, int nbrEssais, ArrayList<Character> lettresTestees) {
		afficherDessin(dessin);
		System.out.println(motJoueur);
		System.out.println("Il vous reste : " + nbrEssais + " vies");
		if(lettresTestees.size() > 0) {
			System.out.print("Lettres testees : ");
			for(int i=0;i<lettresTestees.size();i++) {
				System.out.print(lettresTestees.get(i) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static String tirageMot(String listeMots[]) {
		int numero = Outils.randomNombre(listeMots.length);
		return listeMots[numero];
	}

}
