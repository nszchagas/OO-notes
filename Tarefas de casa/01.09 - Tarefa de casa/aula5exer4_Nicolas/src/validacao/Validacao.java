package validacao;

import visao.Visao;

public class Validacao {

	public static boolean isCharContinuar(char opcao) {

		if (opcao != 's' && opcao != 'n')
			Visao.mensagemValorInvalido();
		return (opcao == 's' || opcao == 'n');
	}

	public static boolean isNome(StringBuilder nome) {
		final int MINIMO = 3;
		if (nome.length() < MINIMO)
			Visao.mensagemValorInvalido(MINIMO);
		return (nome.length() >= MINIMO);
	}

	public static boolean isEscolhaValida(int num) {
		if (num < 0 | num > 2) {
			Visao.mensagemValorInvalido();
			Visao.limpaTela(2);
		}
		return (num >= 0 && num <= 2);
	}

}
