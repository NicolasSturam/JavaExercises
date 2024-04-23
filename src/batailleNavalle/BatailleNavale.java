package batailleNavalle;

public class BatailleNavale {

	public static void main(String[] args) {
		
		//testIA()
		//testHumain();
		testJeux();
		
		System.out.println("Fin du programme");
	}
	
	public static void testJeux() {
		Mode mode = Mode.MULTI; //ou multi
		ModeTir modeTir = ModeTir.SIMPLE;
		Jeux jeu = new Jeux(mode, modeTir);
		jeu.jouer();
	}
	
	public static void testHumain() {
		Humain moi = new Humain();
		moi.afficherNom();
		//moi.placerBateaux();
		moi.placerBateauAuto();
		moi.afficherGrillePersonnelle();
		//moi.afficherEstimationAdversaire();
		
	}
	
	public static void testIA() {
		IA bob = new IA();
		bob.afficherNom();
		bob.afficherGrillePersonnelle();
		bob.afficherEstimationAdversaire();
	}
	
	public static void testBateau() {
		Navire porteAvions = new Navire("Porte-avions", 5);
		int coordonnees[] = {3,4};
		porteAvions.placerBateau(coordonnees,"vertical");
		porteAvions.afficherCoordonnees();
		coordonnees[0] = 1;
		coordonnees[1] = 4;
		System.out.println(porteAvions.touche(coordonnees) + "\n");
		porteAvions.afficherEtat();
		System.out.println(porteAvions.getSens());
		porteAvions.setSens("horizontal");
		porteAvions.afficherCoordonnees();
		System.out.println(porteAvions.getSens());
	}
	
	public static void testGrilles() {
		int cote = 10;
		Grille grille = new Grille(cote);
		grille.afficherGrille();
	}

}
