package exercices;

import batailleNavalle.Saisies;

public class Joueur {
	private int choix;
	private String reponse;
	private String nom;
	private int indices[];
	private int score;
	
	public Joueur(int nbrPays, int numero) {
		this.choix = 0;
		this.reponse = "";
		this.indices = new int[nbrPays];
		this.score = 0;
		this.nom = Saisies.saisieString("Joueur " + (numero+1) + ", entrez votre nom.");
	}
	
	//Methodes
	public void cash(String pays[]) {
		reponse = Saisies.saisieString("Entrez la reponse :");
		if(reponse.equalsIgnoreCase(pays[1])) {
			System.out.println("Correct.\n");
			this.score+=5;
		}
		else {
			System.out.println("Faux. La réponse était : " + pays[1] + "\n");
		}
	}
	
	public void duo(String tab[][], String pays[]) {
		String deuxPays[][] = new String[2][];
		int aleatoire = (int)(Math.random()*2);
		
		if(aleatoire == 0) {
			deuxPays[0] = pays;
			do {
				deuxPays[1] = tab[JeuCapitalesEuropeennes.indiceAleatoire(tab.length)];
			}while(pays[0].equalsIgnoreCase(deuxPays[1][0]));
		}
		else if(aleatoire == 1) {
			do {
				deuxPays[0] = tab[JeuCapitalesEuropeennes.indiceAleatoire(tab.length)];
			}while(pays[0].equalsIgnoreCase(deuxPays[0][0]));
			deuxPays[1] = pays;
		}
		else {
			System.out.println("Erreur : indice invalide.");
		}
		
		System.out.println("Choix : " + deuxPays[0][1] + " - " + deuxPays[1][1]);
		
		reponse = Saisies.saisieString("Entrez la reponse :");
		if(reponse.equalsIgnoreCase(pays[1])) {
			System.out.println("Correct.\n");
			this.score+=1;
		}
		else {
			System.out.println("Faux. La réponse était : " + pays[1] + "\n");
		}
		
	}
	
	public void carre(String tab[][], String pays[]) {
		String quatrePays[][] = new String[4][];
		int aleatoire = (int)(Math.random()*4);
		boolean valide;
		
		for(int i=0;i < 4; i++) {
			if(aleatoire==i) {
				quatrePays[i] = pays;
			}
			else {
				do {
					valide = true;
					quatrePays[i] = tab[JeuCapitalesEuropeennes.indiceAleatoire(tab.length)];
					if(pays[0].equalsIgnoreCase(quatrePays[i][0])) {
						valide = false;
					}
					for(int j=i-1;j>=0 && valide;j--) {
						if(quatrePays[j][0].equalsIgnoreCase(quatrePays[i][0])) {
							valide = false;
						}
					}
				}while(!valide);
				
			}
		}
		
		System.out.println("Choix :");
		System.out.println( quatrePays[0][1] + " - " + quatrePays[1][1]);
		System.out.println( quatrePays[2][1] + " - " + quatrePays[3][1] + "\n");
		
		
		reponse = Saisies.saisieString("Entrez la reponse :");
		if(reponse.equalsIgnoreCase(pays[1])) {
			System.out.println("Correct.\n");
			this.score+=3;
		}
		else {
			System.out.println("Faux. La réponse était : " + pays[1] + "\n");
		}
	}
	
	//Setteurs
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public void setChoix(int choix) {
		this.choix = choix;
	}
	
	public void setIndices(int max) {
		JeuCapitalesEuropeennes.tirageAuSort(this.indices, max);
	}
	
	//Accesseurs
	public int getIndice(int numero) {
		return this.indices[numero];
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getChoix() {
		return this.choix;
	}
	
	public int getScore() {
		return this.score;
	}
}
