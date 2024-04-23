package exercices;

public class Loto {

	public static void main(String[] args) {
		int n = 6;
		int tab[] = new int[n];
		
		tirageAuSort(tab, 45);
		
		Tableau.afficherVecteur(tab);
		
		Tableau.triCroissant(tab);
		
		Tableau.afficherVecteur(tab);
		
		afficherGrille(tab, 45/5, 5);
		

	}
	
	public static void tirageAuSort(int tab[], int max) {
		boolean rep;
		for(int i=0;i < tab.length;i++) {
			do {
				rep = false;
				tab[i] = (int)(Math.random()*max+1);
				for(int j=0; j<i && !rep;j++) {
					if(tab[j] == tab[i]) {
						rep=true;
					}
				}
			}while(rep);
		}
	}
	
	public static void afficherGrille(int tab[], int n, int m) {
		int k=0;
		for(int i=0; i<n;i++ ) {
			for(int j=0;j<m;j++) {
				if(k<tab.length ) {
					if(i*m+j+1==tab[k] ) {
						System.out.print(" X ");
						k++;
					}
					else {
						if(i*m+j+1 < 10)
							System.out.print(" ");
						System.out.print((i*m+j+1) + " ");
					}
				}
				else {
					if(i*m+j+1 < 10)
						System.out.print(" ");
					System.out.print((i*m+j+1) + " ");
				}
			}
			System.out.println();
		}
	}

}
