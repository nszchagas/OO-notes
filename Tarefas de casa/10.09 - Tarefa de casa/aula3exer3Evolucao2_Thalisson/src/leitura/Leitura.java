package leitura;

import java.util.Scanner;

public class Leitura {

	// Leitura de um caracter
	public static char getChar() {
		Scanner ler = new Scanner(System.in);
		return (ler.next().trim().toLowerCase().charAt(0));
	}

	// Leitura de float
	public static float getFloat() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextFloat());

	}

	// Leitura de um inteiro
	public static int getInt() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextInt());

	}

	// Leitura de uma string com espacos em branco
	public static String getLinha() {
		Scanner recebe = new Scanner(System.in);
		return (recebe.nextLine());
	}
}
