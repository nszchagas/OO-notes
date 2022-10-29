package leitura;

import java.util.Scanner;

public class Leitura {

	public static String lerString() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static int lerInteiro() {
		return new Scanner(System.in).nextInt();
	}
	
	public static float lerFloat() {
		return new Scanner(System.in).nextFloat();
	}
	
	public static char lerCaractere() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}
	
}
