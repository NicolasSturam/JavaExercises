package exercices;

import batailleNavalle.Saisies;

public class TestMath {

	public static void main(String[] args) {
		int niveau; //1. < 10; 2. < 100; 3. < 1000;
		int operation; //1. Addition; 2. Soustraction; 3. Multiplication; 4. Divison
		// 5. Mélange
		int nombreCalculs = 10;
		int calculs[][] = new int[nombreCalculs][6]; 
		//10 calculs, 4 composants pour les operations et 2 infos pour m�moriser la solution de l'utilisateur
		String demande = "", message;
		int calcul = 0;
		
		niveau = menuNiveau();
		operation = choixOperation();
		remplirMatrice(calculs, (int)Math.pow(10, niveau), operation);
		//Tableau.afficherMatrice(calculs);
		
		/*
		 * Boucle principale
		 * L'utilisateur peut voir les calculs, naviguer et entrer ses r�ponses
		 */
		do {
			if(demande.equalsIgnoreCase("S")) {
				if(calcul < nombreCalculs-1) {
					calcul++;
				}
					
			}
			else if(demande.equalsIgnoreCase("P")){
				if(calcul > 0) {
					calcul--;
				}	
			}
			
			afficherCalcul(calculs[calcul]);
			if(calculs[calcul][4]==0) {
				
			}
			
			if(calcul == 0) {
				message = "Suivant (S)\nCorrection (C)";
			}
			else if(calcul == nombreCalculs-1) {
				message = "Pr�c�dent (P)\nCorrection (C)";
			}
			else {
				message = "Suivant (S)\nCorection (C)";
			}
			demande = Saisies.saisieString(message);
		}while(!demande.equalsIgnoreCase("C"));
		
		/*
		 * On verifie les r�ponses de l'utilisateur et on lui affiche ses points
		 */
		
		System.out.println("Fin du programme");
	}

	/*
	 * Calcul est au format :
	 * nombre1 <operation> nombre2 = nombre3
	 */
	public static void afficherCalcul(int calcul[]) {
		String operation = " ", reponse;
		
		switch(calcul[1]) {
		case 1:
			operation = " + ";
			break;
		case 2:
			operation = " - ";
			break;
		case 3:
			operation = " * ";
			break;
		case 4:
			operation = " / ";
			break;
		default:
			System.out.println("Valeur d'op�ration invalide.");
			break;
		}
		
		System.out.print(calcul[0] + operation + calcul[2] + " = ");
		
		//On regarde si l'utilisateur a entré une solution ou non pour l'afficher
		if(calcul[4]==0) {
			calcul[5] = Saisies.lectureInt("\nQuelle est la réponse ?");
		}
		else {
			System.out.println(calcul[5]);
			do {
				reponse = Saisies.saisieString("Voulez-vous changer votre réponse ? (oui/non)");
			}while(!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non"));
			
			if(reponse.equalsIgnoreCase("oui")) {
				calcul[5] = Saisies.lectureInt("\nQuelle est la réponse ?");
			}
		}
		
	}
	
	public static void remplirMatrice(int calculs[][], int max, int operation) {
		int op;
		for(int i=0;i<calculs.length;i++) {
			if(operation == 5)
				op = nombreAleatoire(4);
			else
				op = operation;
			remplirLigne(calculs[i], op, max);
			
		}
	}

	public static void remplirLigne(int tab[], int operation, int max) {
		tab[0] = nombreAleatoire(max);
		tab[1] = operation;
		tab[2] = nombreAleatoire(max);
		switch(operation) {
		case 1://Addition
			tab[3] = tab[0] + tab[2];
			break;
		case 2://Soustraction
			tab[3] = tab[2];
			tab[2] = tab[0];
			tab[0] = tab[2] + tab[3];
			break;
		case 3://Multiplication
			tab[3] = tab[0] * tab[2];
			break;
		case 4://Division
			tab[3] = tab[2];
			tab[2] = tab[0];
			tab[0] = tab[2] * tab[3];
			break;
		default:
			System.out.println("Operation impossible.");
			break;
		}
	}
	
	/*
	 * return [1;max]
	 */
	public static int nombreAleatoire(int max) {
		return (int)(Math.random()*(max-1))+1;
	}

	public static int menuNiveau() {
		int niveau = 0;
		System.out.println("-----------------------------");
		System.out.println("1. Nombres inf�rieurs � 10");
		System.out.println("2. Nombres inf�rieurs � 100");
		System.out.println("3. Nombres inf�rieurs � 1000");
		System.out.println("-----------------------------");

		do {
			niveau = Saisies.lectureInt("Choisissez le niveau en entrant le num�ro.");
		}while(niveau < 0 || niveau > 4);

		return niveau;
	}

	public static int choixOperation() {
		int choix;
		System.out.println("-----------------------------");
		System.out.println("1. Addition");
		System.out.println("2. Soustraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Un peu de tout");
		System.out.println("-----------------------------");

		do {
			choix = Saisies.lectureInt("Choisissez une op�ration en entrant le num�ro.");
		}while(choix < 0 || choix > 6);

		return choix;

	}
}
