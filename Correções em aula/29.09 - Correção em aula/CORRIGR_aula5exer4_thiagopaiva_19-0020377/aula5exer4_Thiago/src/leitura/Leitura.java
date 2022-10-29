package leitura;

import java.util.Scanner;

public class Leitura {
	public static char leChar() {
		return new Scanner(System.in).next().toUpperCase().charAt(0);
	}

	
	
	public static String leString() {
		return new Scanner(System.in).nextLine().trim();
	}
}
