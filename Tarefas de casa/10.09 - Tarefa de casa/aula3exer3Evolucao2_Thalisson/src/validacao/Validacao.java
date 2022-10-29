package validacao;

import saida.Saida;

public class Validacao {

	public static boolean validaContinua(char opcao) {

		if ((opcao != 's') && (opcao != 'n'))
			Saida.mostraMensagemValorInvalido();
		return ((opcao == 's') || (opcao == 'n'));
	}

	public static boolean validaAltura(float altura) {
		final float MINIMO = 0.4F, MAXIMO = 2.6F;
		if (altura <= MINIMO | altura >= MAXIMO)
			Saida.mostraMensagemValorInvalido(MINIMO, MAXIMO);
		return (altura > MINIMO && altura < MAXIMO);

	}

	public static boolean validaIdade(int idade) {
		final int MINIMO = 0, MAXIMO = 150;
		if (idade <= MINIMO | idade >= MAXIMO)
			Saida.mostraMensagemValorInvalido(MINIMO, MAXIMO);

		return (idade > MINIMO && idade < MAXIMO);

	}

	public static boolean validaNome(String nome) {
		final int MINIMO = 3;
		if (nome.length() < MINIMO)
			Saida.mostraMensagemValorInvalido(MINIMO);
		return (nome.length() > MINIMO);

	}
}
