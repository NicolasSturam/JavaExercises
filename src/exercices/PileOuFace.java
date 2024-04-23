package exercices;

import batailleNavalle.Saisies;

public class PileOuFace {
	private static int choix = 0;

	//stats
	private static int nbrPartie = 0;
	private static int nbrTentatives = 0;
	private static int nbrTentativesR = 0;
	private static int maxReussite = 0;
	private static double pReussite = 0.0;
	private static int nCotePile = 0;
	private static double pCotePile = 0.0;


	public static void main(String[] args) {
		boolean afficherMenu = true;
		do {
			if(afficherMenu) {
				afficherMenu();
				afficherMenu = false;
			}	
			do {
				choix = Saisies.lectureInt("Que souhaitez-vous faire ?\nEntrez votre choix.");
			}while(choix < 1 || choix > 4);

			switch(choix) {
			case 1:
				if(nbrPartie == 0) {
					System.out.println("Aucune partie n'a �t� jou�e.");
				}
				else {
					reinitialiserStatistiques();
				}
				break;
			case 2:
				jouer();
				afficherMenu = true;
				break;
			case 3:
				if(nbrPartie == 0) {
					System.out.println("Aucune partie n'a �t� jou�e.");
				}
				else {
					afficherStatistiques();
				}
				break;
			}
		}while(choix!=4);
		System.out.println("Fin du programme");

	}

	public static void afficherMenu() {
		System.out.println("---------------------------------");
		System.out.println("1. R�initialiser les statistiques");
		System.out.println("2. Jouer");
		System.out.println("3. Afficher les statistiques");
		System.out.println("4. Quitter le programme");
		System.out.println("---------------------------------");
	}

	public static void reinitialiserStatistiques() {
		System.out.println("Reinitialisation des stats");
		nbrPartie = 0;
		nbrTentatives = 0;
		nbrTentativesR = 0;
		maxReussite = 0;
		pReussite = 0.0;
		nCotePile = 0;
		pCotePile = 0.0;
	}

	public static void jouer() {
		System.out.println("Jouer");
		int points, nTentatives, nTentativesR, mReussite;
		boolean stop;
		String cote, choix, cPiece;

		do {
			System.out.println("D�but d'une nouvelle partie");
			nTentatives = 0;
			nTentativesR = 0;
			mReussite = 0;
			points = 0;
			cote = "";
			choix = "oui";
			cPiece = "";
			stop = false;
			do {
				do {
					cote = Saisies.saisieString("Choisissez un c�t� (pile ou face)");
				}while(!cote.equalsIgnoreCase("pile") && !cote.equalsIgnoreCase("face"));
				cPiece = jetPiece();
				if(cPiece.equalsIgnoreCase("Pile"))
					nCotePile++;
				if(cPiece.equalsIgnoreCase(cote)) {
					System.out.println("Le cot� �tait bien " + cPiece +". Vous marquez 1 point.");
					points++;
					nTentativesR++;
					mReussite++;

				}
				else {
					System.out.println("Rat�. Le cot� �tait " + cPiece);
					if(mReussite > maxReussite)
						maxReussite = mReussite;
					mReussite = 0;
				}

				nTentatives++;
				do {
					choix = Saisies.saisieString("Refaire une tentative ? (oui/non)");
				}while(!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non"));
			}while(choix.equalsIgnoreCase("oui"));

			//Afficher le nombre de points
			System.out.println("Vous avez marqu� " + points + " points durant cette partie.");
			choix ="";	
			do {
				choix = Saisies.saisieString("Jouer une nouvelle partie ? (oui/non)");
			}while(!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non"));
			if(choix.equalsIgnoreCase("non"))
				stop = true;
			//Mise � jour des stats
			nbrPartie++;
			nbrTentatives += nTentatives;
			nbrTentativesR += nTentativesR;
			if(nbrTentatives!=0) {
				pReussite = (double)nbrTentativesR/(double)nbrTentatives;
				pCotePile = (double)nCotePile/(double)nbrTentatives;
			}
			else
				System.out.println("Erreur division par 0.");
		}while(!stop);
	}

	public static String jetPiece() {
		int rand = (int)(Math.random()*2+1);
		if(rand==1) {
			return "Pile";
		}
		else
			return "Face";
	}

	public static void afficherStatistiques() {
		System.out.println("Affichage des statistiques");
		System.out.println("Le pourcentage de r�ussite : " + pReussite);
		System.out.println("Le pourcentage d'�chec : " + (1-pReussite));
		System.out.println("Le nombre de parties jou�es : " + nbrPartie);
		System.out.println("Le pourcentage de cot� pile : " + pCotePile);
		System.out.println("Le pourcentage cot� face : " + (1-pCotePile));
		System.out.println("La plus grande s�rie de tentative r�ussie : " + maxReussite);
	}
}
