package poo;

public class Main {

	public static void main(String[] args) {
		Schtroumpf village[] = new Schtroumpf[10];
		int nbrSchtroumpf = 0;
		
		village[0] = new GrandSchtroumpf();
		village[1] = new Schtroumpfette();
		village[2] = new SchtroumpfPeureux();
		village[3] = new SchtroumpfNoir();
		
		nbrSchtroumpf = village[0].getNb();
		System.out.println("Il y a " + nbrSchtroumpf + " Schtroumpfs au village.");
		
		for(int i=0;i<nbrSchtroumpf;i++) {
			village[i].dessine();
			village[i].parle();
			if(village[i] instanceof Schtroumpfette) {
				((Schtroumpfette)village[i]).shopping();
			}
			else if(village[i] instanceof GrandSchtroumpf) {
				((GrandSchtroumpf)village[i]).chef();
			}
			else if(village[i] instanceof SchtroumpfPeureux) {
				((SchtroumpfPeureux)village[i]).peur();
			}
			else if(village[i] instanceof SchtroumpfNoir) {
				((SchtroumpfNoir)village[i]).mord();
			}
			System.out.println();
		}
	}
}
