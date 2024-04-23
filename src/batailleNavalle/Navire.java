package batailleNavalle;

public class Navire {
	private String nom;
	private int nbrCases; //nombres de points egalement
	private int coordonnees[][];
	private String sens;
	private boolean estCoule;
	private boolean etat[];
	
	Navire(String nom, int taille){
		this.nom = nom;
		this.nbrCases = taille;
		this.sens = "horizontal";
		this.coordonnees = new int[taille][2];
		this.estCoule = false;
		this.etat = new boolean[nbrCases];
	}
	
	//Methodes
	/*
	 * Attribue des coordonnées à toutes les cases du bateau
	 */
	public void placerBateau(int coordonnees[], String sens) {
		int indice1, indice2;
		if(sens.equalsIgnoreCase("horizontal")) {
			indice1 = 1;
			indice2 = 0;
		}
		else if(sens.equalsIgnoreCase("vertical")){
			indice1 = 0;
			indice2 = 1;
		}
		else {
			System.out.println("Indice invalide.");
			return;
		}
		this.sens = sens;
		this.coordonnees[0][0] = coordonnees[0];
		this.coordonnees[0][1] = coordonnees[1];
		
		for(int i=1;i<this.coordonnees.length;i++) {
			this.coordonnees[i][indice1] = coordonnees[indice1] + i;
			this.coordonnees[i][indice2] = coordonnees[indice2];
		}
	}
	
	public boolean touche(int coordonnees[]) {
		boolean touche = false;
		for(int i=0;i<this.coordonnees.length && !touche;i++) {
			if(this.coordonnees[i][0]==coordonnees[0] && this.coordonnees[i][1]==coordonnees[1]) {
				touche = true;
				this.etat[i] = true;
			}
		}
		return touche;
	}
	
	public boolean estCoule() {
		if(this.estCoule == false) {
			this.estCoule=true;
			for(int i=0;i<this.etat.length && this.estCoule;i++) {
				if(this.etat[i]==false) {
					this.estCoule = false;
				}
			}
		}
		return this.estCoule;
	}
	
	public void afficherCoordonnees() {
		for(int i=0;i<this.coordonnees.length;i++) {
			System.out.println(this.coordonnees[i][0] + ", " + this.coordonnees[i][1]);
		}
	}
	
	public void afficherEtat() {
		for(int i=0;i<this.etat.length;i++) {
			System.out.println(this.etat[i]);
		}
	}
	//Setteurs	
	public void setSens(String sens) {
		if(!this.sens.equalsIgnoreCase(sens)) {
			this.sens = sens;
			int indice1, indice2;
			if(sens.equalsIgnoreCase("horizontal")) {
				indice1 = 0;
				indice2 = 1;
			}
			else if(sens.equalsIgnoreCase("vertical")) {
				indice1 = 1;
				indice2 = 0;
			}
			else {
				System.out.println("Sens invalide");
				return;
			}
			for(int i=1;i<this.coordonnees.length;i++) {
				this.coordonnees[i][indice2] = this.coordonnees[0][indice2] + i;
				this.coordonnees[i][indice1] = this.coordonnees[0][indice1];
			}
		}
	}
	
	//Accesseurs
	public String getNom() {
		return this.nom;
	}
	
	public int getNbrCases() {
		return this.nbrCases;
	}
	
	public int[][] getCoordonnees() {
		return this.coordonnees;
	}
	
	public String getSens() {
		return this.sens;
	}
	
}
