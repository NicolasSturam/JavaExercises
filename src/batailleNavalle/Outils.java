package batailleNavalle;

public class Outils {
	public static void afficherCoordonnees(int c[][]) {
		for(int i=0;i<c.length;i++) {
			System.out.println(c[i][0] + ", " + c[i][1]);
		}
	}
	/*
	 * 0 ou 1
	 */
	public static int randomPileOuFace() {
		return (int)(Math.random()*2);
	}
	
	/*
	 * [0;max[
	 */
	public static int randomNombre(int max) {
		return (int)(Math.random()*max);
	}
	
	public static String randomSens() {
		String sens = "";
		int pileOuFace = randomPileOuFace();
		if(pileOuFace == 0) {
			sens = "horizontal";
		}
		else
			sens = "vertical";
		return sens;
	}
	
	public static int[] randomCoordonnees(int tailleBateau, String sens[]) {
		int coordonnees[] = new int[2], max = 10;
		
		//On tire d'abord la coordonnee y
		coordonnees[0] = randomNombre(max); 
		
		//On teste cette premiere coordonnee pour savoir comment tirer la seconde
		if(coordonnees[0] > max-tailleBateau) {
			//Si on a pas la place pour le placer verticalement,
			//on le place horizontalement
			sens[0] = "horizontal";
			//Il ne faut pas que le bateau depasse de la grille
			coordonnees[1] = randomNombre(max-tailleBateau);
		}
		else {
			//On va juste forcer le sens verticalement si la coordonnee en x est 
			//trop grande pour placer le bateau horizontalement
			coordonnees[1] = randomNombre(max);
			if(coordonnees[1] > max-tailleBateau) {
				sens[0] = "vertical";
			}
			else {
				sens[0] = randomSens();
			}
		}
		return coordonnees;
	}
}
