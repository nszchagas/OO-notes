package principal;

import leitura.Leitura;
import validacao.Validacao;
import saida.Saida;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		String nome = new String();
		StringBuilder primeiroNome = new StringBuilder();
		;
		StringBuilder ultimoNome = new StringBuilder();
		;

		// INSTRUCOES
		do {
			Saida.solicitarNome();
			do {
				nome = Leitura.leituraString();
			} while (!Validacao.validaNome(nome));

			primeiroNome = Validacao.primeiroNome(nome);
			ultimoNome = Validacao.ultimoNome(nome);

			Saida.nomeConcatenado(primeiroNome, ultimoNome);

		} while (Validacao.validaContinua());

	}
}
