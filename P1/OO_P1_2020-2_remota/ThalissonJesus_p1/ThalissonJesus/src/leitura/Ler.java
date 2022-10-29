package leitura;

import java.util.Scanner;

public class Ler {
	public static String lerString() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}
	
	public static char lerChar() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}
}
