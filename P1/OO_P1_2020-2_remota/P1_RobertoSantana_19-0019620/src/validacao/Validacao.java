package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import visao.Visao;

public class Validacao {
	
	public static char validaChar(String conjunto, String mensagem) {
		char caracter;

		Visao.mostraMensagem(mensagem);
		caracter = Leitura.leChar();
		if (!conjunto.contains(Character.toString(caracter))) {
			System.err.println("Entrada invalida! tente novamente:");
			caracter = validaChar(conjunto, mensagem);
		}
		return caracter;
	}

	public static int validaInt(final int MIN, final int MAX, String mensagem) {
		int lido;
		
		Visao.mostraMensagem(mensagem);
		lido = validaExcecao();
		if (lido < MIN || lido > MAX) {
			System.err.println((MAX == 150) 
					? "Valor Invalido! Insira um numero maior que "+MIN+" e menor que "+MAX 
					: "Valor Invalido! Insira um numero maior que "+MIN);
			lido = validaInt(MIN, MAX, mensagem);
		}
		return lido;
	}
	public static int validaExcecao() {
		int lido;
		try {
			lido = Leitura.leInt();
		} catch (InputMismatchException e) {
			System.err.println("Valor Invalido! Insira apenas um numero");
			lido = validaExcecao();
		}
		return lido;
	}
	
	
	public static StringBuilder validaString(String mensagem) {
		String lido;
				
		Visao.mostraMensagem(mensagem);
		do {
			lido = Leitura.leLinha();
			if (lido.length() < 2 || lido.split(" ").length == 1) {
				System.err.println("Apenas sao permitidos nomes COMPLETOS que tenham no minimo 3 caracteres");
			}
		} while (lido.length() < 2 || lido.split(" ").length == 1);	
		
		return new StringBuilder().append(lido);
	}
	public static boolean validaGestacao() {
		char lido;
		
		lido = validaChar("SN", "Ja foi gestante? (S ou N): ");
		return lido == 'S';
	}
}
