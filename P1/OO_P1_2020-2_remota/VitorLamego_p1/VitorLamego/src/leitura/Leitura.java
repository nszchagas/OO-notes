package leitura;

import java.util.Scanner;

public class Leitura {
	public static String lerString() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static int lerInteiro() {
		return new Scanner(System.in).nextInt();
	}
	
	public static char lerCaracter() {
		return new Scanner(System.in).next().toUpperCase().charAt(0);
	}
}
