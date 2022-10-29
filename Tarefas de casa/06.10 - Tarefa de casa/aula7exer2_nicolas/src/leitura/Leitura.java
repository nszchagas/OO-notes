package leitura;

import java.util.Scanner;

public class Leitura {

	public static String leString() {
		return new Scanner(System.in).nextLine().trim();
	}

	public static float leNumero() {
		return new Scanner(System.in).nextFloat();
	}

}
