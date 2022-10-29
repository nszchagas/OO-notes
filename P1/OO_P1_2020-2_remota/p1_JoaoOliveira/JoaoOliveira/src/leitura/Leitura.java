package leitura;

import java.util.Scanner;
import saida.Visao;

public class Leitura {
	public static String lerEntrada (String mensagem) {
		Visao.mostraMensagem(mensagem);
		return new Scanner(System.in).next().trim();
	}
	
	public static String lerEntradaComEspaco (String mensagem) {
		Visao.mostraMensagem(mensagem);
		return new Scanner(System.in).nextLine().trim();
	}
}
