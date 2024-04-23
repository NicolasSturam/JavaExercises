package exercices;

public class Tableau {
	public static void vecteurAleatoire(int tab[]) {
		for(int i=0; i < tab.length;i++) {
			tab[i] = (int)(Math.random()*100);
		}
	}
	
	public static void matriceAleatoire(int tab[][]) {
		for(int i=0;i < tab.length;i++) {
			for(int j=0;j < tab[0].length;j++) {
				tab[i][j] = (int)(Math.random()*100);
			}
		}
	}
	
	public static void matriceAleatoireBornee(int tab[][], int min, int max) {
		if(min >= max) {
			System.out.println("Attention max doit �tre strictement sup�rieur � min.");
		}
		else {
			for(int i=0;i < tab.length;i++) {
				for(int j=0;j < tab[0].length ;j++) {
					tab[i][j] = (int)(Math.random()*(max-min+1)+min);
				}
			}
		}
	}
	
	public static void afficherMatrice(int tab[][]) {
		for(int i=0; i<tab.length;i++ ) {
			for(int j=0;j<tab[0].length;j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void afficherMatrice(char tab[][]) {
		for(int i=0; i<tab.length;i++ ) {
			for(int j=0;j<tab[0].length;j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void afficherVecteur(int tab[]) {
		for(int i=0;i < tab.length;i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}
	
	public static void afficherVecteur(char tab[]) {
		for(int i=0;i < tab.length;i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}
	
	public static void afficherVecteur(String tab[]) {
		for(int i=0;i < tab.length;i++) {
			System.out.print(tab[i] + ", ");
		}
		System.out.println();
	}
	
	public static void rotateMatrice90Degre(int tab[][], int n) {
		int iMax = 0, memoire = 0;
		int x[] = new int[2], y[] = new int[2];
		
		if(n % 2 ==0) {
			iMax = n/2-1;
		}
		else {
			iMax = (n-1)/2;
		}
		
		for(int i=0; i<=iMax; i++) {
			for(int j=i;j <= n-2-i; j++) {
				x[0] = i;
				y[0] = j;
				for(int p = 1; p<=3; p++) {
					x[1] = y[0];
					y[1] = n-1-x[0];
					memoire = tab[x[1]][y[1]];
					tab[x[1]][y[1]] = tab[i][j];
					tab[i][j] = memoire;
					x[0] = x[1];
					y[0] = y[1];
				}
			}
		}
	}
	
	public static void triCroissant(int tab[]) {
		int memoire = 0;
		for(int i=1;i < tab.length;i++) {
			for(int j=i; j > 0; j--) {
				if(tab[j-1] > tab[j]) {
					memoire = tab[j];
					tab[j] = tab[j-1];
					tab[j-1] = memoire;
				}
			}
		}
	}
	
	
}
