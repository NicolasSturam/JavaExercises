package exercices;

import java.util.ArrayList;

import batailleNavalle.Saisies;

public class NombreToAbaque {

	public static void main(String[] args) {
		ArrayList<Integer> nombres;
		int nombre = -1;
		
		do {
			nombre = Saisies.lectureInt("Entrez un nombre entier sup�rieur � 0.");
		}while(nombre < 0);
		
		nombres = nombreToAbaque(nombre);
		
		System.out.println(nombres);
	}

	public static ArrayList<Integer> nombreToAbaque(int nombre){
		ArrayList<Integer> nombres = new ArrayList<Integer>();
		
		while(nombre > 0) {
			nombres.add(0, nombre%10);
			nombre/=10;
		}
		
		return nombres;
	}
}
