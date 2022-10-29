package principal;

import java.util.Scanner;

public class Leitura {

	public static char getChar() {
		Scanner ler = new Scanner(System.in);
		return ler.next().trim().toLowerCase().charAt(0); // ja deixa o char minusculo
	}

	public static float getFloat() {
		Scanner ler = new Scanner(System.in);
		return ler.nextFloat();
	}

	public static int getInt() {
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}

	public static String getString() {
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		return ler.next().trim();
	}

}
