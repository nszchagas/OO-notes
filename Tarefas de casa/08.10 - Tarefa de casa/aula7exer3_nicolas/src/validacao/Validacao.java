package validacao;

import java.util.Arrays;

import visao.Visao;

public class Validacao {

	public static boolean isEspecie(String nome) {
		String[] nomes = nome.split(" ");

		if (nomes.length != 2) {
			Visao.mostraMensagemErro("Valor invalido! O nome da especie deve ser composto por apenas duas palavras");
			return false; // nome de especie é formado por duas palavras em latim
		}
		for (String string : nomes)
			if (string.length() < 3) {
				Visao.mostraMensagemErro("Valor invalido! Cada um dos nomes deve ter pelo menos 3 letras.");
				return false;
			}
		return true;

	}

	public static boolean isTamanho(float tamanho) {
		final int MAX = 30, MIN = 0;
		if (tamanho <= MIN || tamanho > MAX)
			Visao.mostraMensagemErro("Valor invalido! O tamanho deve estar entre " + MIN + " e " + MAX);
		return (tamanho > MIN && tamanho <= MAX);
	}

	public static boolean isIdade(int idade) {
		final int MAX = 100, MIN = 0;
		if (idade <= MIN || idade > MAX)
			Visao.mostraMensagemErro("Valor invalido! A idade deve estar entre " + MIN + " e " + MAX);
		return (idade > MIN && idade <= MAX);
	}

	public static boolean isPorte(String porte) {
		boolean valido = false;
		int contador = 0;
		String[] opcoes = new String[] { "pequeno", "medio", "grande" };
		while (valido == false && contador < opcoes.length) {
			valido = porte.toLowerCase().trim().contains(opcoes[contador].toString());
			contador++;
		}
		if (!valido)
			Visao.mostraMensagemErro("Valor invalido! Deve ser um dos seguintes: " + Arrays.toString(opcoes));
		return valido;
	}

	public static boolean isPeso(float peso) {
		final int MIN = 0, MAX = 200000;
		if (peso <= MIN || peso >= MAX)
			Visao.mostraMensagemErro("Valor invalido! O peso deve estar entre " + MIN + " e " + MAX);
		return (peso > MIN && peso < MAX);
	}

	public static boolean isHabitat(String habitat) {
		String[] nomes = habitat.split(" ");
		for (String string : nomes)
			if (string.length() < 3) {
				Visao.mostraMensagemErro("Valor invalido! Cada um dos nomes deve ter pelo menos 3 letras.");
				return false;
			}
		return true;
	}

}
