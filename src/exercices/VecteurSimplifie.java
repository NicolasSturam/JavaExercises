package exercices;

import batailleNavalle.Saisies;

public class VecteurSimplifie {
	
	public static void main(String[] args) {
		int n=20;
		char vect[] = new char[n];
		
		for(int i=0;i<n;i++) {
			vect[i] = Saisies.saisieChar("Entrez le caract�re : " + (i+1));
		}
		
		Tableau.afficherVecteur(vect);
		
		vect = vecteurSimplifie(vect);
		
		Tableau.afficherVecteur(vect);
		
	}

	public static char[] vecteurSimplifie(char[] vect) {
		char[] vect2 = new char[vect.length];
		boolean doublon = false;
		
		vect2[0] = vect[0];
		
		for(int i=1; i<vect.length ;i++) {
			
			for(int j=i-1; j>=0 && !doublon; j--) {
				if(vect[i] == vect2[j]) {
					doublon = true;
				}
			}
			
			if(!doublon) {
				vect2[i] = vect[i];
			}
			else {
				vect2[i] = ' ';
			}
		}
		
		return SupprimeEspace.suppressionEspace(new String(vect2)).toCharArray();
	}
}
