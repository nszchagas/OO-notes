package leitura;

import java.util.Scanner;

public class Leitor {
	public static String lerNome() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().trim().toUpperCase();
	}
	
	public static char lerEscolha() {
		Scanner ler = new Scanner(System.in);
		return ler.next().toLowerCase().charAt(0);
	}

}
