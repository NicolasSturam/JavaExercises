package batailleNavalle;

public class Case {
	private char etat;
	private Navire navire;
	private int[] coordonnees;
	
	Case(int x, int y){
		this.etat = '-';
		this.navire = null;
		this.coordonnees = new int[2];
		this.coordonnees[0] = y;
		this.coordonnees[1] = x;
	}

	//Setteurs
	public boolean setEtat(char c) {
		char tabC[] = {'-', 'o', '+', 'x'};
		boolean valide = false;
		
		for(int i=0;i<tabC.length && !valide;i++) {
			if(c==tabC[i]) {
				valide = true;
			}
		}
		
		if(valide) {
			this.etat = c;
			return true;
		}
		else {
			System.out.println("Etat pour la case invalide.");
			return false;
		}
	}
	
	public boolean setNavire(Navire navire) {
		if(this.navire == null) {
			this.navire = navire;
			return true;
		}
		else {
			return false;
		}
	}
	
	//Getteurs
	public char getEtat() {
		return this.etat;
	}
	
	public Navire getNavire() {
		return this.navire;
	}
	
	public int[] coordonnees() {
		return this.coordonnees;
	}
}
