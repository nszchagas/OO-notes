package Leitura;

import java.util.Scanner;

public class Leitura {
	public static int lerInt() {
		return new Scanner(System.in).nextInt();
	}
	
	public static char lerChar() {
		return new Scanner(System.in).next().toUpperCase().trim().charAt(0);
	}
	
	public static short lerShort(){
		return new Scanner(System.in).nextShort();
	}
}