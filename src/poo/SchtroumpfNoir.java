package poo;

public class SchtroumpfNoir extends Schtroumpf{
	SchtroumpfNoir(){
		nom = "GNAP !";
	}
	
	public void dessine() {
		System.out.println("Peau noire, bonnet et pentalon blanc.");
	}
	
	public void parle() {
		System.out.println("GNAP !");
	}
	
	public void mord() {
		System.out.println("Le schtroumpf noir essaye de vous mordre.");
	}
}
