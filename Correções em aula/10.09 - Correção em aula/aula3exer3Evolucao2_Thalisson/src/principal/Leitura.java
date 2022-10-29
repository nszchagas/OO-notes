package principal;

import java.util.Scanner;

public class Leitura {
	
	// Leitura de um caracter
	public static char leituraChar() {
		Scanner ler = new Scanner(System.in);
		return (ler.next().trim().toUpperCase().charAt(0));
	}
	
	
	// Leitura de float
	public static float leituraFloat() { // não faz validação na classe de leitura! 
		Scanner ler = new Scanner(System.in);
		try {
			return(ler.nextFloat());
		} catch (Exception e) {
			return -1f;
		}
	}

	
	// Leitura de um inteiro
	public static int leituraInt() {
		Scanner ler = new Scanner(System.in);
		try {
			return(ler.nextInt());
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	// Leitura de uma string com espacos em branco
	public static String leituraLinha() {
		Scanner recebe = new Scanner(System.in);
		return(recebe.nextLine());
	}
}
