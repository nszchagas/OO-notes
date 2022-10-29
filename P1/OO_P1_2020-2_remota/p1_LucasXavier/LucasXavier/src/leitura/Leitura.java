package leitura;

import java.util.Scanner;

public class Leitura {
	public static String lerString() {
		return new Scanner(System.in).nextLine();
	}
	
	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}
	
	public static float lerFloat() {
		return new Scanner(System.in).nextFloat();
	}
}
