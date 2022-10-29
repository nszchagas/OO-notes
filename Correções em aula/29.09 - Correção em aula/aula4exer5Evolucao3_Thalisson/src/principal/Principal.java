package principal;

import leitura.Leitura;
import validacao.Validacao;
import saida.Saida;

public class Principal {

	public static void main(String[] args) {
		// DECLARACOES
		String nome;
		StringBuilder primeiroNome;
		StringBuilder ultimoNome;

		// INSTRUCOES
		do {
			Saida.solicitarNome();
			
			nome = Validacao.validaNome(Leitura.leituraString());

			primeiroNome = Validacao.primeiroNome(nome);
			ultimoNome = Validacao.ultimoNome(nome);

			Saida.nomeConcatenado(primeiroNome, ultimoNome);

		} while (Validacao.validaContinua());

	}
}
