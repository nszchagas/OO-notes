package leitura;

import java.util.Scanner;

public class Leitura {

	public String lerNome() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static String lerEntrada() {
		return new Scanner(System.in).nextLine().trim(); 
	}
}
