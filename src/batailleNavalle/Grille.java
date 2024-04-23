package batailleNavalle;

public class Grille {
	private Case cases[][];
	private int lignes;
	private int colonnes;
	
	Grille(int cote){
		this.cases = new Case[cote][cote];
		this.lignes = cote;
		this.colonnes = cote;
		
		for(int i=0;i<lignes;i++) {
			for(int j=0;j<colonnes;j++) {
				this.cases[i][j] = new Case(i, j);
			}
		}
	}
	
	Grille(int lignes, int colonnes){
		this.cases = new Case[lignes][colonnes];
		this.lignes = lignes;
		this.colonnes = colonnes;
		
		for(int i=0;i<lignes;i++) {
			for(int j=0;j<colonnes;j++) {
				this.cases[i][j] = new Case(i, j);
			}
		}
	}
	
	public void afficherGrille() {
		System.out.println("---------------------------------------------");
		System.out.println("|    | A | B | C | D | E | F | G | H | I | J |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
		for(int i=0;i<this.lignes;i++) {
			System.out.print("| " + (i+1)) ;
			if(i+1 < 10) {
				System.out.print(" ");
			}
			System.out.print(" |");
			
			for(int j=0;j<this.colonnes;j++) {
				System.out.print(" " + this.cases[i][j].getEtat() + " ");
				if(j!=this.colonnes-1) {
					System.out.print(" ");
				}
			}
			System.out.print("|");
			if(i!=this.lignes-1) {
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
	}
	
	//Accesseurs
	public Case getCase(int coordonnees[]) {
		return cases[coordonnees[0]][coordonnees[1]];
	}
	
	public Case[][] getCases(){
		return cases;
	}
}
