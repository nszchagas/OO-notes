package leitura;

import java.util.Scanner;

public class Leitura {
	public static char leiaChar() {
		return new Scanner(System.in).next().toUpperCase().charAt(0);
	}

	public static int leiaInt() {
		return new Scanner(System.in).nextInt();
	}

	public static float leiaFloat() {
		return new Scanner(System.in).nextFloat();
	}
	
	public static String leiaString() {
		return new Scanner(System.in).nextLine().trim();
	}
}
