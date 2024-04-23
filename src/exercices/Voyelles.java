package exercices;

import batailleNavalle.Saisies;

public class Voyelles {

	public static void main(String[] args) {
		String phrase = "";
		char voyelles[] = {'a','e','u','i','o','y'};
		int nbrVoyelles = 0;
		boolean trouve;
		
		System.out.println("D�but calcul voyelles.");
		
		do {
			phrase = Saisies.saisieString("Entrez une phrase.");
		}while(phrase.length()==0);
		
		for(int i=0;i<phrase.length();i++) {
			trouve = false;
			for(int j=0;j<voyelles.length && !trouve;j++) {
				if(phrase.charAt(i)==voyelles[j] || phrase.charAt(i)==Character.toUpperCase(voyelles[j])) {
					nbrVoyelles++;
					trouve = true;
				}
			}
		}
		
		System.out.println("Le nombre de voyelles contenues\ndans " + phrase + " est " + nbrVoyelles);
		System.out.println("Fin du programme.");
	}

}
