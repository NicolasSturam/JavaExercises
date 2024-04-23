package puissance4;

public class Humain extends Joueur{
	private int[] coup;
	
	Humain(){
		if(nbrJoueur < 2) {
			nom = Saisies.saisieString("Joueur " + (nbrJoueur+1) + ", entrez votre nom :");
			nbrJoueur++;
			setPion();
			coup = new int[2];
		}
		else {
			System.out.println("Il ne peut y avoir plus de 2 joueurs !");
			nom = "";
			pion = ' ';
		}
		gagne = false;
		abandon = false;
	}
	
	public boolean jouer(char[][] grille) {
		int colonne, ligne = 0; //infos du pion
		boolean valide = false;
		
		System.out.println("Placer votre pion");
		//On demande au joueur de placer un pion et on verifie si il est 
		// bien place
		do {
			do {
				colonne = Saisies.lectureInt("Entrez le numero de la colonne");
			}while((colonne < 1 || colonne > grille[0].length) && colonne >=0);
			
			if(colonne > 0) {
				colonne--;
				//car la grille est remplie par le haut et que le 0
				//commence tout a gauche
				if(grille[grille.length-1][colonne] == ' ') {
					valide = true;
				}
				else {
					System.out.println("La colonne choisie est deja remplie !");
				}
			}
			else {
				abandon = true;
			}

		}while(!valide && !abandon);
		
		if(!abandon) {
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
		}
		
		coup[0] = ligne;
		coup[1] = colonne;
		
		return abandon;

	}
	
	public int[] getCoup() {
		return coup;
	}
}
