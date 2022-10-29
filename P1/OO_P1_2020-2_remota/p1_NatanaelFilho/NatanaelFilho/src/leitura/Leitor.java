package leitura;

import java.util.Scanner;

public class Leitor {
	public static String lerString() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static char lerChar() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}

	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}
}
