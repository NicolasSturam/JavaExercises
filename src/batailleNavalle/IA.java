package batailleNavalle;

public class IA extends Joueur{
	IA(){
		this.tirsReussis = 0;
		this.tirsManques = 0;
		this.bateauxCoules = 0;
		this.navires = new Navire[5];
		setNavires();
		setGrilles();
		setNom();
	}

	//Methodes de la classe joueur
	public void placerBateaux() {

	}

	public void setNom() {
		this.nom = "BOB";
	}

	public boolean jouer(Joueur adversaire) {
		
		return true;
	}

	//Methodes specifiques
}
