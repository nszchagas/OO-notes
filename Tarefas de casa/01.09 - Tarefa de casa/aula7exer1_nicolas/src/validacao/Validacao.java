package validacao;

import java.util.Calendar;

import dados.PresidentesBrasileiros;
import visao.Visao;

public class Validacao {

	public static boolean isPresidenteCorreto(String nome, int ano) {
		boolean nomeValido = false;
		if (isNome(nome)) {
			String[] presidenteCorreto = PresidentesBrasileiros.getNomePresidenteAno(ano).split(" ");
			int contador = 0;
			while (contador < presidenteCorreto.length && nomeValido == false) {
				if (presidenteCorreto[contador].length() >= 3)
				nomeValido = nome.toLowerCase().contains(presidenteCorreto[contador].toLowerCase());
				contador++;
			}
			if (nomeValido == false)
				Visao.mensagemPresidenteInvalido(PresidentesBrasileiros.getNomePresidenteAno(ano), ano);
		}

		return nomeValido;
	}

	public static boolean isNome(String nome) {
		final int MIN = 3;
		if (nome.length() < MIN)
			Visao.mensagemValorInvalido(MIN);
		return (nome.length() >= MIN);

	}

	public static boolean isAno(int ano) {
		final int MIN = 1900, MAX = Calendar.getInstance().get(Calendar.YEAR);
		if (ano <= MIN || ano > MAX)
			Visao.mensagemValorInvalido(MIN, MAX);
		return (ano > MIN && ano <= MAX);

	}

	public static boolean isContinuar(char opcao) {
		if (opcao != 's' && opcao != 'n')
			Visao.mensagemValorInvalido();
		return (opcao == 's' || opcao == 'n');
	}

}
