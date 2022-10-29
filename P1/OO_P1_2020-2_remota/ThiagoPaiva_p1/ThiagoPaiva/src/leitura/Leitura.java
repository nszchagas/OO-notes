package leitura;

import java.util.Scanner;

public class Leitura {
	public static char leiaChar() {
		return new Scanner(System.in).next().toUpperCase().charAt(0);
	}

	public static String leiaString() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static int leiaInt() {
		return new Scanner(System.in).nextInt();
	}
}
