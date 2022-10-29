package leitura;

import java.util.Scanner;

public class Leitura {
	public static String getString() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().trim();
	}
	public static int getInt() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}
}
