package principal;

import java.util.Scanner;

public class Leitura {

	public static char leituraChar() {
		Scanner ler = new Scanner(System.in);
		return (ler.next().trim().toUpperCase().charAt(0));
	}

	public static float leituraFloat() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextFloat());
	}

	public static int leituraInt() {
		Scanner ler = new Scanner(System.in);
		return (ler.nextInt());
	}

	public static String leituraLinha() {
		Scanner recebe = new Scanner(System.in);
		return (recebe.nextLine());
	}
}
