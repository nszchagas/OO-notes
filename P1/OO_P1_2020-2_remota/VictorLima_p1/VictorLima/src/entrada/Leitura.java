package entrada;

import java.util.Scanner;

public class Leitura {

	public static char lerChar() {
		return (new Scanner(System.in).next().trim().toUpperCase().charAt(0));
	}

	public static int lerInt() {
		return (new Scanner(System.in).nextInt());
	}

	public static float lerFloat() {
		return (new Scanner(System.in).nextFloat());
	}

	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine().toUpperCase();
	}

}
