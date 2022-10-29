package leitura;

import java.util.Scanner;

public class Leitura {
	public static int leInt() {
		return new Scanner(System.in).nextInt();
	}
	
	public static float leFloat() {
		return new Scanner(System.in).nextFloat();
	}
	
	public static String leLinha() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static String leString() {
		return new Scanner(System.in).next().trim();
	}

	public static char leChar() {
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}
}
