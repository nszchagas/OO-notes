package validacao;

import leitura.Leitura;
import saida.Saida;

public class Validacao {

	// VALIDACAO DO NOME
	public static String validaNome(String nome) {
		boolean possuiEspaco;
		while (nome.isEmpty() | !(possuiEspaco = isEspaco(nome))){
			if (nome.isEmpty()) {
				Saida.entradaVaziaInvalida();
				nome = Leitura.leituraString();
			} else if (!possuiEspaco) {
				Saida.nomeInvalido();
				nome = Leitura.leituraString();
			}
		}
		
		return nome;
	}
	
	public static boolean isEspaco(String nome) {
		return nome.indexOf(' ') != -1;
	}

	// PRIMEIRO NOME
	public static StringBuilder primeiroNome(String nome) {
		return new StringBuilder(nome).delete(nome.indexOf(' '), nome.length());
	}

	// ÚLTIMO NOME
	public static StringBuilder ultimoNome(String nome) {
		return new StringBuilder(nome).delete(0,  nome.lastIndexOf(' '));
	}

	public static boolean validaContinua() {
		char opcao;
		Saida.verificarContinuacao();
		do {
			opcao = Leitura.leituraChar();
			if (opcao != 'S' && opcao != 'N')
				Saida.digiteUmCaractereValido();
		} while (opcao != 'S' && opcao != 'N');

		Saida.limpaTela(40);

		return (opcao == 'S');

	}

}
