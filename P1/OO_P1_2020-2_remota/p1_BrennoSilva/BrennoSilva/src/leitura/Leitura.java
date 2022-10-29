package leitura;

import java.util.Scanner;

public class Leitura {
	
	public static int lerInt() {
		return (new Scanner(System.in).nextInt());
	}
	
	public static String lerString() {
		return (new Scanner(System.in).nextLine().trim());
	}
	
	public static char lerChar() {
		return (new Scanner(System.in).nextLine().trim().charAt(0));
	}
}
