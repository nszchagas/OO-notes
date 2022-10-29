package validacao;

import visao.Visao;

public class Validacao {

	public static boolean isContinua(char opcao) {
		if ((opcao != 'S') && (opcao != 'N'))
			Visao.mensagemInvalido("ser 's' ou 'n'");
		return (opcao == 'S' || opcao == 'N');
	}

	public static boolean isSalario(float salario) {
		final float MIN = 0;
		if (salario < MIN)
			Visao.mensagemInvalido("ser maior ou igual a " + MIN);
		return (salario >= MIN);
	}

	public static boolean isIdade(int idade) {
		final int MIN = 0, MAX = 151;
		if (idade <= MIN || idade >= MAX)
			Visao.mensagemInvalido("estar entre " + MIN + " e " + MAX);
		return (idade > MIN && idade < MAX);
	}

	public static boolean isSexo(char sexo) {
		if ((sexo != 'M') && (sexo != 'F'))
			Visao.mensagemInvalido("ser FEMININO ou MASCULINO");
		return (sexo == 'M' || sexo == 'F');

	}

	public static boolean isNumeroFilhos(int filhos) {
		final float MIN = 0, MAX = 50;
		if (filhos < MIN || filhos >= MAX)
			Visao.mensagemInvalido("estar entre " + MIN + " e " + MAX);
		return (filhos >= MIN && filhos < MAX);
	}

}
