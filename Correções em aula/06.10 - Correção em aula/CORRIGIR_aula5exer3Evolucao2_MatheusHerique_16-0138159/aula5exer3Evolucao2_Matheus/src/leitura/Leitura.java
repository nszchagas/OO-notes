package leitura;

import java.util.Scanner;

public class Leitura {

	// Leitura de um caracter
	public static char leituraChar() {
		return (new Scanner(System.in).next().trim().toUpperCase().charAt(0));
	}

	// Leitura de um inteiro
	public static int leituraInt() {
		return (new Scanner(System.in).nextInt());
	}

	// Leitura de float
	public static float leituraFloat() {
		return (new Scanner(System.in).nextFloat());
	}

}
