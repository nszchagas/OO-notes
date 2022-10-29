package leitura;

import java.util.Scanner;

public class Leitura {

	public static char leituraChar() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}

	public static int leituraInt() {
		return new Scanner(System.in).nextInt();
	}

	public static float leituraFloat() {
		return new Scanner(System.in).nextFloat();
	}

}
