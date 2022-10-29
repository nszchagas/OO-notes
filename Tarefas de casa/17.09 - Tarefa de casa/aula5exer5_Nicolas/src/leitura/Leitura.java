package leitura;

import java.util.Scanner;

public class Leitura {

	public static StringBuilder leStringBuilder() {
		return new StringBuilder(new Scanner(System.in).nextLine().trim());
	}

	public static float leFloat() {
		return new Scanner(System.in).nextFloat();
	}

	public static char leChar() {
		return new Scanner(System.in).nextLine().trim().toLowerCase().charAt(0);
	}

	public static int leInt() {
		return new Scanner(System.in).nextInt();
	}

}
