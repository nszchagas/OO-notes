package leitura;

import java.util.Scanner;

public class Leitura {

	public static char leChar() {
		return new Scanner(System.in).next().toUpperCase().charAt(0);
	}

	public static float leFloat() {
		return new Scanner(System.in).nextFloat();
	}

	public static int leInt() {
		return new Scanner(System.in).nextInt();
	}

}
