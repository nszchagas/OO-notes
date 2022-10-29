package leitura;

import java.util.Scanner;

public class Leitor {
	
	public static String leString() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static char leChar() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}

	public static int leInt() {
		return new Scanner(System.in).nextInt();
	}
}
