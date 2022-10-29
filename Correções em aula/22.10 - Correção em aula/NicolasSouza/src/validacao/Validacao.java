package validacao;

import dados.Populacao;
import visao.Visao;

public class Validacao {

	public static boolean isNome(String nome) {
		String[] nomesSeparados = nome.split(" ");
		if (nomesSeparados.length < 2) {
			Visao.mostraMensagemErro("Insira o nome completo da pessoa.", "Nome invalido");
			return false;
		} else {
			for (String texto : nomesSeparados) {
				if (texto.length() < 2) {
					Visao.mostraMensagemErro("Cada nome deve ter pelo menos dois caracteres", "Valor invalido");
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isIdade(float numero) {
		final int MIN = 0, MAX = 150;
		if (numero < MIN || numero > MAX)
			Visao.mostraMensagemErro("O valor inserido deve estar entre " + MIN + " e " + MAX, "Valor invalido");
		return (numero >= MIN && numero <= MAX);
	}

	public static boolean isCodigo(Populacao populacao, int numero) {
		final int MAIOR = 100;
		if (numero <= MAIOR) {
			Visao.mostraMensagemErro("O valor inserido deve ser maior que " + MAIOR, "Valor invalido");
			return false;
		} else {
			for (Integer codigo : populacao.getCodigos())
				if (codigo == numero) {
					Visao.mostraMensagemErro("O codigo ja foi inserido. Insira outro.", "Valor invalido");
					return false;
				}
		}
		return true;
	}

}
