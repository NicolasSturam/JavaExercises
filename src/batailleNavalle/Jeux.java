package batailleNavalle;

public class Jeux {
	private Joueur joueurs[];
	private Mode mode;
	private ModeTir modeTir;
	private boolean fin;
	
	Jeux(Mode mode, ModeTir modeTir){
		joueurs = new Joueur[2];
		this.mode = mode;
		joueurs[0] = new Humain();
		//joueurs[0].placerBateauAuto();
		joueurs[0].placerBateaux();
		switch(mode) {
		case SOLO:
			joueurs[1] = new IA();
			break;
		case MULTI:
			joueurs[1] = new Humain();
			//joueurs[1].placerBateauAuto();
			joueurs[1].placerBateaux();
			break;
		}
		
		this.modeTir = modeTir;
		fin = false;
	}
	
	public void jouer() {
		int premierJoueur = Outils.randomPileOuFace();
		int numero = premierJoueur;
		//memoire pour les permutations
		Joueur joueurEnCours, adversaire, memoire;
		
		if(numero==0) {
			adversaire = joueurs[0];
			joueurEnCours = joueurs[1];
		}
		else {
			adversaire = joueurs[1];
			joueurEnCours = joueurs[0];
		}
		
		//Boucle principale
		do {
			//Inversion de l'adversaire et du joueur en cours
			memoire = adversaire;
			adversaire = joueurEnCours;
			joueurEnCours = memoire;
			
			if(joueurEnCours instanceof Humain) {
				System.out.println(joueurEnCours.getNom() + " à votre tour.");
			}
			else if(joueurEnCours instanceof IA) {
				System.out.println("Au tour de " + joueurEnCours.getNom());
			}
			
			fin = joueurEnCours.jouer(adversaire);
			//fin = true;
		}while(!fin);
		
		//Tableau des scores etc
		if(joueurEnCours.aGagne()) {
			System.out.println(joueurEnCours.getNom() + " a gagné !");
		}
		else {
			System.out.println("Abandon de " + joueurEnCours.getNom());
			System.out.println("Par conséquent, victoire de " + adversaire.getNom());
		}
		joueurEnCours.afficherScores();
		adversaire.afficherScores();
	}
}
