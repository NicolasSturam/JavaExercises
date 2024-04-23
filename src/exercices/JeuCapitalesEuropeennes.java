package exercices;

import java.util.ArrayList;

import batailleNavalle.Saisies;

public class JeuCapitalesEuropeennes {

	public static void main(String[] args) {
		String[][] tabCapitales={ 
				{"de l'Allemagne ", "Berlin"}, { "de l'Autriche ", "Vienne"},
				{ "de la Belgique ", "Bruxelles"}, { "de la Bulgarie ", "Sofia"},
				{ "de Chypre ", "Nicosie"}, { "de la Croatie ", "Zagreb"},
				{ "du Danemark ", "Copenhague"}, { "de l'Espagne ", "Madrid"},
				{ "de l'Estonie ", "Tallinn"}, { "de la Finlande ", "Helsinki"},
				{ "de la France ", "Paris"}, { "de la Grèce ", "Athènes"},
				{ "de la Hongrie ", "Budapest"}, { "de l'Irlande ", "Dublin"},
				{ "de l'Italie ", "Rome"}, { "de la Lettonie ", "Riga"},
				{ "de la Lituanie ", "Vilnius"}, { "du Luxembourg ", "Luxembourg"},
				{ "de Malte ", "La Valette"}, { "des Pays-Bas ", "Amsterdam"},
				{ "de la Pologne ", "Varsovie"}, { "du Portugal ", "Lisbonne"},
				{ "de la République tchèque ", "Prague"}, { "de la Roumanie ", "Bucarest"},
				{ "de la Slovaquie ", "Bratislava"}, { "de la Slovénie ", "Ljubljana"},
				{ "de la Suède ", "Stockholm"}} ;
		int choix;

		do {
			choix = menu();

			switch(choix) {
			case 1:
				etudier(tabCapitales);
				break;
			case 2:
				tester(tabCapitales);
				break;
			case 3:
				jouer(tabCapitales);
				break;
			case 4:
				break;
			default:
				System.out.println("Choix invalide");
				choix = 4;
				break;
			}
		}while(choix != 4);

		System.out.println("Fin du programme");
	}

	public static ArrayList<String[]> creerListeString(String tab[][]){
		ArrayList<String[]> liste = new ArrayList<String[]>();
		for(int i=0;i<tab.length;i++) {
			liste.add(tab[i]);
		}
		return liste;
	}
	/*
	 * return [0;max[
	 */
	public static int indiceAleatoire(int max) {
		return (int)(Math.random()*max);
	}

	public static void etudier(String tab[][]) {
		ArrayList<String[]> liste = creerListeString(tab);
		String reponse = "";
		String pays[];
		int indice = 0;

		System.out.println("Début du mode étude !");
		System.out.println("Des noms de pays vont vous être proposés et vous allez devoir proposer le nom de la capitale.");
		System.out.println("Si la proposition est incorrecte, la correction sera donnée.");
		System.out.println("Entrez ? pour indiquer que vous ne savez pas ou # pour stopper avant la fin.");
		System.out.println("Le programme s'arrête lorsque toutes les capitales ont été trouvées.");
		System.out.println("(Les pays dont la capitale a été trouvée ne sont pas reproposés.)\n");

		do {
			indice = indiceAleatoire(liste.size());
			pays = liste.get(indice);

			reponse = Saisies.saisieString("Quelle est la capitale " + pays[0] + " ?");
			//reponse = SupprimeEspace.suppressionEspace(reponse);

			if(reponse.equalsIgnoreCase(pays[1])) {
				System.out.println("Correct.");
				liste.remove(indice);
			}
			else {
				if(!reponse.equalsIgnoreCase("?") && !reponse.equalsIgnoreCase("#")) {
					System.out.print("Faux.");
				}
				System.out.println("La réponse était : " + pays[1]);
			}
		}while(liste.size() > 0 && !reponse.equalsIgnoreCase("#"));

		if(!reponse.equalsIgnoreCase("#")) {
			System.out.println("Bravo ! Vous avez terminé d'étudier !");
		}
		else {
			System.out.println("Sortie du mode étudier.");
		}

	}
	public static void tirageAuSort(int tab[], int max) {
		boolean rep;
		for(int i=0;i < tab.length;i++) {
			do {
				rep = false;
				tab[i] = indiceAleatoire(max);
				for(int j=0; j<i && !rep;j++) {
					if(tab[j] == tab[i]) {
						rep=true;
					}
				}
			}while(rep);
		}
	}

	public static void tester(String tab[][]) {
		int nbrPays = 10, score = 0;
		int indices[] = new int[nbrPays];
		String reponse = "", pays[];

		//10 pays sont tirés au hasard et placés dans indices
		tirageAuSort(indices, tab.length);

		System.out.println("Début du mode tester !");
		System.out.println("10 pays ont été tirés au hasard afin de tester vos connaissances sur les capitales auropéennes.");

		for(int i=0;i<indices.length;i++) {
			pays = tab[indices[i]];
			reponse = Saisies.saisieString("Quelle est la capitale " + pays[0] + " ?");

			if(reponse.equalsIgnoreCase(pays[1])) {
				System.out.println("Correct.");
				score++;
			}
			else {
				System.out.println("Faux. La réponse était : " + pays[1]);
			}
		}

		System.out.println("Votre score est de : " + score + " sur 10.");
	}

	public static void jouer(String tab[][]) {
		int nbrPays = 10;
		String pays[];

		//Infos joueurs
		int nbrJoueurs = 2;
		Joueur joueurs[] = new Joueur[nbrJoueurs];

		//Initialisations
		for(int i=0;i<nbrJoueurs;i++) {
			joueurs[i] = new Joueur(nbrPays, i);
			//10 pays sont tirés au hasard et placés dans indices
			joueurs[i].setIndices(tab.length);
		}
		int numeroJoueur = 0;
		//int numeroQuestion = 0;
		//Jeux
		for(int i=0;i<nbrJoueurs*10;i++) {
			System.out.println(joueurs[numeroJoueur].getNom() + ", c'est à votre tour de jouer.\n" );

			pays = tab[joueurs[numeroJoueur].getIndice(i/nbrJoueurs)];
			System.out.println("Question " + (i/nbrJoueurs+1));
			System.out.println("Quelle est la capitale " + pays[0] + " ?");
			joueurs[numeroJoueur].setChoix(menuJeu());

			switch(joueurs[numeroJoueur].getChoix()) {
			case 1:
				joueurs[numeroJoueur].cash(pays);
				break;
			case 2:
				joueurs[numeroJoueur].duo(tab, pays);
				break;
			case 3:
				joueurs[numeroJoueur].carre(tab, pays);
				break;
			}
			
			numeroJoueur++;
			if(numeroJoueur==nbrJoueurs) {
				numeroJoueur = 0;
			}
		}

		Joueur gagnant = joueurs[0];
		if(nbrJoueurs > 1) {
			for(int i=1;i<nbrJoueurs;i++) {
				if(joueurs[i].getScore() > gagnant.getScore()) {
					gagnant = joueurs[i];
				}
			}
		}

		System.out.println(gagnant.getNom() + " gagne !");
		System.out.println("--------------------");
		System.out.println(" Tableau des scores ");
		System.out.println("--------------------");
		for(int i=0; i< nbrJoueurs;i++) {
			System.out.println(joueurs[i].getNom() + " : " + joueurs[i].getScore());
		}
		System.out.println("--------------------");
	}

	public static int menuJeu() {
		int choix = 0;

		System.out.println("-------------------------");
		System.out.println("1. Cash (pour 5 points)");
		System.out.println("2. Duo (pour 1 point)");
		System.out.println("3. Carré (pour 3 points)");
		System.out.println("-------------------------");
		do {
			choix = Saisies.lectureInt("Votre choix ?");
		}while(choix < 1 || choix > 3);

		return choix;
	}

	public static int menu() {
		int choix = 0;

		System.out.println("----------");
		System.out.println("1. Etudier");
		System.out.println("2. Tester");
		System.out.println("3. Jouer");
		System.out.println("4. Quitter");
		System.out.println("----------");
		do {
			choix = Saisies.lectureInt("Votre choix ?");
		}while(choix < 1 || choix > 4);

		return choix;
	}

}
