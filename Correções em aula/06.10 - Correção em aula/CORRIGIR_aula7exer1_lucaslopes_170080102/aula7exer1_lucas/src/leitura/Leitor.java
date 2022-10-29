package leitura;

import java.util.Scanner;

public class Leitor {
	public static int leInteiro() {
		return new Scanner(System.in).nextInt();
	}
	
	public static String leString() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static char leChar() {
		return new Scanner(System.in).next().toLowerCase().charAt(0);
	}

}
