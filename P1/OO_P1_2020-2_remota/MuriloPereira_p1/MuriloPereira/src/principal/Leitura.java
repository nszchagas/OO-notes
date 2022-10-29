package principal;

import java.util.Scanner;

public class Leitura {
	
	public static String lerNome() {
		return new Scanner(System.in).nextLine().trim();
	}
	
	public static char lerChar() {
		return new Scanner(System.in).nextLine().toUpperCase().charAt(0);
	}
	
	public static int lerIdentificador() {
		return new Scanner(System.in).nextInt();
	}
	
	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}
}
