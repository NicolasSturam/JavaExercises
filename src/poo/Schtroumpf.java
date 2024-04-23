package poo;

public class Schtroumpf {
	protected static int nb = 0;
	protected String nom;
	
	Schtroumpf(){
		nom = "Schtroumpf";
		nb++;
	}
	
	Schtroumpf(String nom){
		this.nom = nom;
		nb++;
	}
	
	public void parle() {
		System.out.println("Je schtroumpfe le schtroumpf et je m'appelle " + nom + ".");
	}
	
	public void dessine() {
		System.out.println("Peau bleue, chapeau et pentalon blanc.");
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getNb() {
		return nb;
	}
}
