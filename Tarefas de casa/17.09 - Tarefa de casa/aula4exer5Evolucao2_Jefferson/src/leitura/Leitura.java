package leitura;

import java.util.Scanner;

public class Leitura {

	public static String leituraString() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().toUpperCase().trim();
	}

}