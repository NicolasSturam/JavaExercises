package batailleNavalle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Saisies {
	public static String saisieString(String message) {
		String str = "";
		boolean check = false;
		System.out.println(message);
		do {
			try{
				str = new Scanner(System.in).nextLine();
				check = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Erreur de lecture");
			}
		}while(!check);
		
		return str;
	}
	
	public static char saisieChar(String message) {
		char c = 'x';
		boolean check = false;
		do {
			try{
				System.out.println(message);
				c = new Scanner(System.in).nextLine().charAt(0);
				check = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Erreur de lecture.");
			}
			catch( java.lang.StringIndexOutOfBoundsException e){
				System.out.println("Pas de caract�re entr�.");
			}
		}while(!check);
		
		return c;
	}
	
	public static int lectureInt() {
		int entier = 0;
		boolean check = false;
		System.out.println("Entrez un nombre entier.");
		do {
			try{
				entier = new Scanner(System.in).nextInt();
				check = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Attention ! Vous devez entrer un entier.");
			}
		}while(!check);
		
		return entier;
	}
	
	public static int lectureInt(String str) {
		int entier = 0;
		boolean check = false;
		System.out.println(str);
		do {
			try{
				entier = new Scanner(System.in).nextInt();
				check = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Attention ! Vous devez entrer un entier.");
			}
		}while(!check);
		
		return entier;
	}
	
	public static double lectureDoube() {
		double nombre = 0.0;
		boolean check = false;
		System.out.println("Entrez un nombre");
		do {
			try{
				nombre = new Scanner(System.in).nextDouble();
				check = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Attention ! Vous devez entrer un nombre.");
			}
		}while(!check);
		
		return nombre;
	}
	
	public static double lectureDoube(String message) {
		double nombre = 0.0;
		boolean check = false;
		System.out.println(message);
		do {
			try{
				nombre = new Scanner(System.in).nextDouble();
				check = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Attention ! Vous devez entrer un nombre.");
			}
		}while(!check);
		
		return nombre;
	}
}
