package exercices;

public class RotationMatrice90Degre {

	public static void main(String[] args) {
		int n = 4;
		int matrice[][] = new int[n][n];
		
		Tableau.matriceAleatoire(matrice);
		
		Tableau.afficherMatrice(matrice);
		
		Tableau.rotateMatrice90Degre(matrice, n);
		
		Tableau.afficherMatrice(matrice);
	}

}
