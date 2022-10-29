package leitura;

import java.util.Scanner;

public class Leitura {

	public static String leituraString() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().toUpperCase().trim();
	}
	
	public static char leituraChar() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}

}