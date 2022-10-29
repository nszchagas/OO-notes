package leitura;

import java.util.Scanner;

public class Leitura {
	public static String leString() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static float leFloat() {
		return new Scanner(System.in).nextFloat();
	}
	
	public static char leCaracter() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}
	
	public static int leInteiro() {
		return new Scanner(System.in).nextInt();
	}
}
