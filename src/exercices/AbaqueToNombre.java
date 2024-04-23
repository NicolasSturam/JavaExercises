package exercices;

public class AbaqueToNombre {

	public static void main(String[] args) {
		int chiffres[] = {1,2,3,4,5};
		int nombre = abaqueToNombre(chiffres);
		System.out.println(nombre);

	}

	public static int abaqueToNombre(int chiffres[]) {
		int nombre = 0;
		
		for(int i=0;i<chiffres.length;i++) {
			nombre+=chiffres[i]*Math.pow(10, chiffres.length-i-1);
		}
		
		return nombre;
	}
}
