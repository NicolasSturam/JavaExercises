package batailleNavalle;

abstract public class Joueur {
	protected String nom;
	protected int tirsReussis;
	protected int tirsManques;
	protected int bateauxCoules;
	protected int nbrTires;
	protected boolean gagne;
	protected Navire navires[];
	protected Grille grillePersonnelle;
	protected Grille estimationAdversaire;
	
	//Methodes abstraites
	public abstract void placerBateaux();
	
	public abstract void setNom();
	
	public abstract boolean jouer(Joueur adversaire);
	
	//Methodes generales
	public void tirReussi() {
		this.tirsReussis++;
	}
	
	public void tirManque() {
		this.tirsManques++;
	}
	
	public void bateauCoule() {
		this.bateauxCoules++;
	}
	
	public void afficherNom() {
		System.out.println(this.nom);
	}
	
	public void afficherGrillePersonnelle() {
		this.grillePersonnelle.afficherGrille();
	}
	
	public void afficherEstimationAdversaire() {
		this.estimationAdversaire.afficherGrille();
	}
	
	public boolean victoire(Joueur joueur) {
		boolean gagne = true;
		Navire navires[] = joueur.getNavires();
		for(int i=0;i<navires.length && gagne;i++) {
			if(navires[i].estCoule() == false) {
				gagne = false;
			}
		}
		return gagne;
	}
	
	protected void placerBateauAuto() {
		boolean valide = false;
		int coordonnees[], coordonneesNavires[][];
		String sens[] = new String[1];
		
		for(int i=0;i<navires.length;i++) {
			do {
				coordonnees = Outils.randomCoordonnees(navires[i].getNbrCases(), sens);
				//sens = Outils.randomSens();
				navires[i].placerBateau(coordonnees, sens[0]);
				try {
					valide = checkPosition(i, false);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}while(!valide);
			
			coordonneesNavires = navires[i].getCoordonnees();
			//On place le bateau sur la grille
			for(int j=0;j<coordonneesNavires.length;j++) {
				grillePersonnelle.getCase(coordonneesNavires[j]).setEtat('+');
				grillePersonnelle.getCase(coordonneesNavires[j]).setNavire(navires[i]);
			}
		}
	}
	
	protected boolean checkPosition(int numeroBateau, boolean afficherMessage) throws Exception{
		boolean valide = true;
		int max = 9;
		
		//On verifie si le bateau ne depasse pas de la grille
		Navire navire = navires[numeroBateau];
		int coordNav[][] = navire.getCoordonnees();
		Case cases[][] = grillePersonnelle.getCases();
		int x,y;
		String nomNavire = "";
		
		if(coordNav[coordNav.length-1][0] > max || coordNav[coordNav.length-1][1] > max) {
			valide = false;
			if(afficherMessage)
				System.out.println("Attention, le bateau depasse de la grille.");
		}
		else {
			//On verifie si toutes les cases et celles a cote sont innocupées
			if(navire.getSens().equalsIgnoreCase("horizontal")) {
				x = coordNav[0][1]-1;
				y = coordNav[0][0];
				
				if((x >= 0) && (cases[y][x].getNavire() != null)) {
					valide = false;
					nomNavire = cases[y][x].getNavire().getNom();
				}
				for(int i=0; i < coordNav.length && valide;i++) {
					for(int j=-1;j<=1 && valide;j++) {
						x = coordNav[i][1];
						y = coordNav[i][0]+j;
						if(y >= 0 && y <= max && cases[y][x].getNavire() != null) {
							valide = false;
							nomNavire = cases[y][x].getNavire().getNom();
						}
					}
				}
				x = coordNav[coordNav.length-1][1]+1;
				y = coordNav[coordNav.length-1][0];
				
				if((x <= max) && (cases[y][x].getNavire() != null)) {
					valide = false;
					nomNavire = cases[y][x].getNavire().getNom();
				}
				
			}
			else if(navire.getSens().equalsIgnoreCase("vertical")) {
				x = coordNav[0][1];
				y = coordNav[0][0]-1;
				
				if((y >= 0) && (cases[y][x].getNavire() != null)) {
					valide = false;
					nomNavire = cases[y][x].getNavire().getNom();
				}
				for(int i=0; i < coordNav.length && valide;i++) {
					for(int j=-1;j<=1 && valide;j++) {
						x = coordNav[i][1]+j;
						y = coordNav[i][0];
						if(x >= 0 && x <= max && cases[y][x].getNavire() != null) {
							valide = false;
							nomNavire = cases[y][x].getNavire().getNom();
						}
					}
				}
				x = coordNav[coordNav.length-1][1];
				y = coordNav[coordNav.length-1][0]+1;
				
				if((y <= max) && (cases[y][x].getNavire() != null)) {
					valide = false;
					nomNavire = cases[y][x].getNavire().getNom();
				}
			}
			else {
				throw new Exception("Le sens n'est pas valide.");
			}
			if(valide == false && afficherMessage) {
				System.out.println("Position invalide, le navire se supperpose à " + nomNavire);
			}
		}
		
		return valide;
	}
	
	/*
	 * 
	 */
	protected boolean tirer(Grille grille, int coordonnees[]) {
		Case c = grille.getCase(coordonnees);
		boolean touche = false;
		switch(c.getEtat()) {
			case '-':
				System.out.println("Manque !");
				tirsManques++;
				c.setEtat('o');
				break;
			case 'o':
				System.out.println("Manque !");
				break;
			case '+':
				System.out.println("Touche !");
				tirsReussis++;
				c.setEtat('x');
				touche = true;
				c.getNavire().touche(coordonnees);
				if(c.getNavire().estCoule()) {
					System.out.println("Coule !");
					bateauxCoules++;
				}
				break;
			case 'x':
				if(c.getNavire().estCoule())
					System.out.println("Cible deja coulee !");
				else
					System.out.println("Cible deja touchee !");
				break;
		}
		return touche;
	}
	
	public void afficherScores() {
		System.out.println("---------------------------------");
		System.out.println("Tableau de scores de " + nom);
		System.out.println("---------------------------------");
		System.out.println("Nombre de tirs réussis : " + tirsReussis);
		System.out.println("Nombre de tirs manqués : " + tirsManques);
		if((tirsReussis+tirsManques)!=0)
			System.out.println("Précision : " + ((double)tirsReussis/(double)(tirsReussis+tirsManques)));
		if(gagne) {
			System.out.println("Tous les bateaux ennemis ont été coulés.");
		}
		else {
			System.out.println("Nombre de bateau coules : " + bateauxCoules);
		}
		System.out.println("---------------------------------");
		
	}
	
	//Setteurs
	protected void setNavires() {
		this.navires = new Navire[5];
		this.navires[0] = new Navire("Porte-avions", 5);
		this.navires[1] = new Navire("Croiseur", 4);
		this.navires[2] = new Navire("Contre-torpilleurs", 3);
		this.navires[3] = new Navire("Contre-torpilleurs", 3);
		this.navires[4] = new Navire("Torpilleur", 2);
	}
	
	protected void setGrilles() {
		this.grillePersonnelle = new Grille(10);
		this.estimationAdversaire = new Grille(10);
	}
	
	//Accesseurs
	public String getNom() {
		return this.nom;
	}
	
	public int getTirsReussis() {
		return this.tirsReussis;
	}
	
	public int getTirsManques() {
		return this.tirsManques;
	}
	
	public Grille getGrillePersonnelle() {
		return this.grillePersonnelle;
	}
	
	public Navire[] getNavires() {
		return this.navires;
	}
	
	public boolean aGagne() {
		return this.gagne;
	}
}
