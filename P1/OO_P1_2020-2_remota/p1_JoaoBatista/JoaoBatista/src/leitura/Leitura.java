package leitura;

import java.util.Scanner;

public class Leitura {
	public static int scanInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public static String scanString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine().toUpperCase().trim();
	}
	
	public static char scanChar() {
		return scanString().toUpperCase().charAt(0);
	}

	public static float scanFloat() {
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}
}
