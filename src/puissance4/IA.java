package puissance4;

public class IA extends Joueur{
	private int etat;
	private int[][] coupsAdversaire;
	private int nbrCoups;
	
	IA(){
		if(nbrJoueur < 2) {
			nom = "BOB";
			nbrJoueur++;
			setPion();
			coupsAdversaire = new int[21][2];
		}
		else {
			System.out.println("Il ne peut y avoir plus de 2 joueurs !");
			nom = "";
			pion = ' ';
		}
		gagne = false;
		abandon = false;
		etat = 0;
		nbrCoups = 0;
	}

	public void watch(int[] coup) {
		coupsAdversaire[nbrCoups][0] = coup[0];
		coupsAdversaire[nbrCoups][1] = coup[1];
		nbrCoups++;
	}
	
	public boolean jouer(char[][] grille) {
		int colonne, ligne = 0; //infos du pion
		boolean valide = false;

		do {
			colonne = Outils.randomNombre(grille[0].length);
			
			//car la grille est remplie par le haut et que le 0
			//commence tout a gauche
			if(grille[grille.length-1][colonne] == ' ') {
				valide = true;
			}
		}while(!valide);

		valide = false;

		//On place le pion dans la grille
		for(int i=grille.length-1; i > 0 && !valide; i--) {
			if(grille[i-1][colonne] != ' ') {
				valide = true;
				ligne = i;
			}
		}

		grille[ligne][colonne] = pion;

		verification(grille, ligne, colonne);

		return false;
	}
}
