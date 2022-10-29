package leitura;

import java.util.Scanner;

public class Leitura {
	public static int getInt() {
		return new Scanner(System.in).nextInt();
	}

	public static String getString() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static char getValidacao() {
		Scanner ler = new Scanner(System.in);
		char validacao;
		validacao = ler.next().toUpperCase().charAt(0);
		ler.nextLine();
		return validacao;
	}
}
