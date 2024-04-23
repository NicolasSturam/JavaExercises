package exercices;

import batailleNavalle.Saisies;

public class SupprimeEspace {

	public static void main(String[] args) {
		String mot = "";
		
		do {
			mot = Saisies.saisieString("Entrez une cha�ne de caract�res.");
		}while(mot.length()==0);
		
		mot = suppressionEspace(mot);
		
		System.out.println(mot);
	}

	public static String suppressionEspace(String str) {
		String mots[];
		
		mots = str.split(" ");
		
		str = "";
		for(int i=0;i<mots.length;i++) {
			str = str.concat(mots[i]);
		}
		
		return str;
	}
}
