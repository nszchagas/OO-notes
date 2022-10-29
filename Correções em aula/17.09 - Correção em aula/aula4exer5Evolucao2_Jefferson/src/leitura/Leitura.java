package leitura;

import java.util.Scanner;

public class Leitura {

	public static StringBuilder leituraStringBuilder() {
		return new StringBuilder(new Scanner(System.in).nextLine().trim());
	}

	public static char leChar() {
		return new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);
	}

}