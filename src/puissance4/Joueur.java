package puissance4;

abstract public class Joueur {
	protected String nom;
	protected char pion;
	protected boolean gagne;
	protected boolean abandon;
	protected static int nbrJoueur = 0;
	protected static char[] pions = {'X', 'O'};
	
	protected void setPion() {
		int numero = Outils.randomNombre(pions.length);
		pion = pions[numero];
		if(pions.length > 1) {
			if(numero == 0) {
				pions = new char[1];
				pions[0] = 'O';
			}
			else {
				pions = new char[1];
				pions[0] = 'X';
			}
		}
		else if(pions.length == 1) {
			pions = null;
		}
	}
	
	abstract public boolean jouer(char[][] grille);
	
	protected void verification(char[][] grille, int ligne, int colonne) {
		int i, j;
		boolean stop = false;
		int compteur = 1;
		//On regarde si le joueur a gagne
		//Colonne
		if(ligne >= 3) {
			//Vers le bas
			for(i = ligne - 1; i>=0 && !stop;i--) {
				if(grille[i][colonne] == pion) {
					compteur++;
					if(compteur == 4) {
						gagne = true;
						stop = true;
					}
				}
				else {
					stop = true;
				}
			}

			if(gagne == false) {
				stop = false;
				compteur = 1;
			}
		}

		//Ligne
		//On regarde vers la gauche
		for(j = colonne - 1;j>=0 && !stop;j--) {
			if(grille[ligne][j] == pion) {
				compteur++;
				if(compteur == 4) {
					gagne = true;
					stop = true;
				}
			}
			else {
				stop = true;
			}
		}
		if(gagne == false) {
			stop = false;
			//On regarde vers la droite
			for(j=colonne + 1;j < grille[0].length && !stop; j++){
				if(grille[ligne][j] == pion) {
					compteur++;
					if(compteur == 4) {
						gagne = true;
						stop = true;
					}
				}
				else {
					stop = true;
				}
			}
			if(gagne == false) {
				stop = false;
				compteur = 1;
			}
		}

		//Diagonale 1
		//Vers sud-ouest
		i = ligne -1;
		j = colonne-1;
		while(!stop && i>=0 && j>=0) {
			if(grille[i][j] == pion) {
				compteur++;
				if(compteur == 4) {
					gagne = true;
					stop = true;
				}
			}
			else {
				stop = true;
			}
			i--;
			j--;
		}
		if(gagne == false) {
			//Vers le nord-est
			i = ligne + 1;
			j = colonne + 1;
			stop = false;
			while(!stop && i < grille.length && j < grille[0].length) {
				if(grille[i][j] == pion) {
					compteur++;
					if(compteur == 4) {
						gagne = true;
						stop = true;
					}
				}
				else {
					stop = true;
				}
				i++;
				j++;
			}
			if(gagne == false) {
				stop = false;
				compteur = 1;
			}
		}

		//Diagonale 2
		//Vers nord-ouest
		i = ligne + 1;
		j = colonne - 1;
		while(!stop && i < grille.length && j>= 0) {
			if(grille[i][j] == pion) {
				compteur++;
				if(compteur == 4) {
					gagne = true;
					stop = true;
				}
			}
			else {
				stop = true;
			}
			i++;
			j--;
		}
		if(gagne == false) {
			//Vers le sud-est
			i = ligne - 1;
			j = colonne + 1;
			stop = false;
			while(!stop && i >= 0 && j < grille[0].length) {
				if(grille[i][j] == pion) {
					compteur++;
					if(compteur == 4) {
						gagne = true;
						stop = true;
					}
				}
				else {
					stop = true;
				}
				i--;
				j++;
			}
			if(gagne == false) {
				stop = false;
				compteur = 1;
			}
		}
	}
	
	public void reset() {
		gagne = false;
		abandon = false;
	}
	
	public boolean aGagne() {
		return gagne;
	}
	
	public boolean aAbandonne() {
		return abandon;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void afficherPion() {
		if(pion != ' ')
			System.out.println(nom + " vous avez le pion " + pion);
	}

	public void afficherNom() {
		System.out.println(nom);
	}
}
