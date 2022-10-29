package leitura;

import java.util.Scanner;

public class Leitura {

	// Leitura de palavra
	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		return ler.next().trim();
	}

	// Leitura de char
	public static Character lerChar() {
		Scanner ler = new Scanner(System.in);
		return ler.next().toUpperCase().trim().charAt(0);
	}

	// Leitura de Inteiros
	public static Integer lerInt() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}

	// Leitura de Float
	public static Float lerFloat() {
		Scanner ler = new Scanner(System.in);
		return ler.nextFloat();
	}

	// Leitura de Doubles
	public static Double lerDouble() {
		Scanner ler = new Scanner(System.in);
		return ler.nextDouble();
	}

	// Leitura de Frase
	public static String lerLinha() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().trim();
	}

}
