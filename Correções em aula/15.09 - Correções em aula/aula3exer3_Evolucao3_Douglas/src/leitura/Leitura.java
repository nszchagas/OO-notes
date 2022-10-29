package leitura;

import java.util.Scanner;

public class Leitura {
	
	public static String lerNome() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine();
	}
	
	public static int lerIdade() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}
	
	public static float lerAltura() {
		Scanner ler = new Scanner(System.in);
		return ler.nextFloat();
	}

	public static String lerResposta() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine();
	}
}
