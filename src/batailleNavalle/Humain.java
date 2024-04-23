package batailleNavalle;

public class Humain extends Joueur{
	Humain(){
		this.tirsReussis = 0;
		this.tirsManques = 0;
		this.bateauxCoules = 0;
		this.gagne = false;
		this.navires = new Navire[5];
		setNavires();
		setGrilles();
		setNom();
	}
	
	Humain(String nom){
		this.tirsReussis = 0;
		this.tirsManques = 0;
		this.bateauxCoules = 0;
		this.navires = new Navire[5];
		setNavires();
		setGrilles();
		this.nom = nom;
	}
	
	//Methodes de la classe joueur
	public void placerBateaux() {
		boolean valide = false;
		int coordonnees[], coordonneesNavires[][];
		String sens="";
		
		
		for(int i=0;i<navires.length;i++) {//5 est le nombre de bateau
			this.afficherGrillePersonnelle();
			System.out.println("Placement du " + navires[i].getNom());
			
			do {
				coordonnees = saisirCoordonnees();
				sens = saisirSens();
				navires[i].placerBateau(coordonnees, sens);
				try {
					valide = checkPosition(i, true);
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
	
	private String saisirSens() {
		String sens = "";
		
		do {
			sens = Saisies.saisieString("Entrez le sens du bateau (H ou V).");
		}while(!sens.equalsIgnoreCase("H") && !sens.equalsIgnoreCase("V"));
		
		if(sens.equals("H"))
			sens = "horizontal";
		else
			sens = "vertical";
		
		return sens;
	}
	
	private int[] saisirCoordonnees() {
		int[] coordonnees = new int[2];
		String reponse;
		char reponseChar[];
		boolean valide = false;

		do {
			reponse = Saisies.saisieString("Entrez les coordonnees").toUpperCase();
			if(reponse.length() > 3 || reponse.length() < 2) {
				System.out.println("Les coordonnees doivent être un chiffre et une lettre");
			}
			else {
				reponseChar = reponse.toCharArray();
				if(reponseChar.length > 2) {
					coordonnees[0] = 9;
				}
				else {
					coordonnees[0] = reponseChar[1]-49;
				}
				if(coordonnees[0] < 0 || coordonnees[0] > 9) {
					System.out.println("La coordonnee en Y doit être compris entre 1 et 10.");
				}
				else {
					
					if(reponseChar[0] < 65 || reponseChar[0] > 74) {
						System.out.println("La coordonnee en X doit être compris entre A et J.");
					}
					else {
						valide = true;
						coordonnees[1] = reponseChar[0]-65;
					}
				}
			}
		}while(!valide);
		
		return coordonnees;
	}

	public void setNom() {
		this.nom = Saisies.saisieString("Entrez votre nom");
	}
	
	/*
	 * Renvoie true si on veut quitter false sinon
	 */
	public boolean jouer(Joueur adversaire) {
		int choix=0, coordonnees[];
		
		Saisies.saisieString("Entrez n'importe quel caractère pour continuer.");
		grillePersonnelle.afficherGrille();
		estimationAdversaire.afficherGrille();
		do {
			choix = Saisies.lectureInt("Tirer (1)");
		}while(choix!=1 && choix!=0);
		
		switch(choix) {
		case 1:
			coordonnees = saisirCoordonnees();
			if(tirer(adversaire.getGrillePersonnelle(), coordonnees)) {
				estimationAdversaire.getCase(coordonnees).setEtat('x');
				//On verifie si on a gagne
				if(victoire(adversaire)) {
					gagne = true;
					return true;
				}
			}
			else {
				estimationAdversaire.getCase(coordonnees).setEtat('o');
			}
			break;
		case 0:
			return true;
		}
		
		return false;
	}
	
	
	//Methodes specifiques
	
}
