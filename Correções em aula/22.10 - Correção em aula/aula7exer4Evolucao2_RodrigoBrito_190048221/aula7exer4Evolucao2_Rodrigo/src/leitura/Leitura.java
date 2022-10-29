package leitura;

import java.util.Scanner;

public class Leitura {

	public static String lerString() {
		return new Scanner(System.in).next().trim();
	}

	public static String lerLinha() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}

}
