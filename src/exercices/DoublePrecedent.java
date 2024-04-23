package exercices;

import batailleNavalle.Saisies;

public class DoublePrecedent {

	public static void main(String[] args) {
		int n = 10;
		int tab[] = new int[n];
		
		do {
			tab[0] = Saisies.lectureInt("Entrez un nombre sup�rieur � 0.");
		}while(tab[0] <= 0);
		
		for(int i=1;i<n;i++) {
			tab[i] = 2*tab[i-1];
		}
		
		Tableau.afficherVecteur(tab);
	}

}
