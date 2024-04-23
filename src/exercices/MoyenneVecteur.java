package exercices;

import batailleNavalle.Saisies;

public class MoyenneVecteur {

	public static void main(String[] args) {
		int n = 10;
		double nombres[] = new double[n], moyenne = 0.0, minMax[][] = new double[2][2];
		boolean divisionZero[] = {false};
		
		for(int i=0; i < n;i++) {
			nombres[i] = Saisies.lectureDoube("Entrez le nombre num�ro : " + (i+1));
		}
		
		moyenne = moyenneNombre(nombres, minMax, divisionZero);
		
		if(divisionZero[0]==false) {
			System.out.println("La moyenne des nombres est : " + moyenne);
		}
		System.out.println("Le minimum et le maximum des nombres entr�s n'ont pas �t� pris en compte.");
		System.out.println("Min = " + minMax[0][0] + " entr� " + minMax[0][1] + " fois.");
		System.out.println("MAx = " + minMax[1][0] + " entr� " + minMax[1][1] + " fois.");
		
	}
	
	public static double moyenneNombre(double nombres[], double minMax[][], boolean divisionZero[]) {
		double somme = 0.0;
		int taille = 0;
		
		if(nombres.length > 0) {
			minMax[0][0] = nombres[0];
			minMax[0][1]++;
			minMax[1][0] = nombres[0];
			minMax[1][1]++;
			somme-=nombres[0];
			taille--;
			for(int i=1; i < nombres.length; i++) {
				//Gestion du minimum
				if(nombres[i] == minMax[0][0]) {
					minMax[0][1]++;
				}
				else if(nombres[i] < minMax[0][0]) {
					somme+=(minMax[0][0])*minMax[0][1];
					minMax[0][0] = nombres[i];
					taille += minMax[0][1];
					minMax[0][1] = 1;
				}
				//Gestion du maximum
				else if(nombres[i] == minMax[1][0]) {
					minMax[1][1]++;
				}
				else if(nombres[i] > minMax[1][0]) {
					somme+=(minMax[1][0])*minMax[1][1];
					minMax[1][0] = nombres[i];
					taille += minMax[1][1];
					minMax[1][1] = 1;
				}
				//Sinon
				else {
					somme+=nombres[i];
					taille++;
				}
			}
			
			if(taille > 0) {
				return (double)somme/(double)taille;
			}
			else {
				System.out.println("Division par 0.");
				divisionZero[0] = true;
				return 0.0;
			}
			
		}
		else {
			System.out.println("Le tableau est vide.");
			return 0.0;
		}
		
	}
}
