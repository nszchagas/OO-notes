package leitura;

import java.util.Scanner;

public class Leitura {

	public static int leInt() {
		return new Scanner(System.in).nextInt();
	}

	public static String leString() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static char leChar() {
		return leString().toLowerCase().charAt(0);
	}

}
