package validacao;

import visao.Visao;

public class Validacao {

	public static boolean isIdade(int idade) {
		final int MIN = 0, MAX = 150;
		if (idade <= MIN || idade >= MAX)
			Visao.mensagemValorInvalido(MIN, MAX);

		return (idade > 0 && idade < 150);
	}

	public static boolean isNome(String nome) {
		final int MIN = 0;
		if (nome.length() <= 0)
			Visao.mensagemTamanhoInvalido(MIN);
		return (nome.length() > 0);
	}

	public static boolean isSalario(float salario) {
		final int MIN = 0;
		if (salario < 0)
			Visao.mensagemValorInvalido(MIN);

		return (salario >= 0);
	}

	public static boolean isQuantidadeDeFilhos(int quantidadeDeFilhos) {
		final int MIN = 0, MAX = 50;
		if (quantidadeDeFilhos < MIN || quantidadeDeFilhos >= MAX)
			Visao.mensagemValorInvalido(MIN, MAX);
		return (quantidadeDeFilhos >= MIN && quantidadeDeFilhos < MAX);
	}

	public static boolean isCharContinuar(char opcao) {

		if (opcao != 'S' && opcao != 'N')
			Visao.mensagemValorInvalido();
		return (opcao == 'S' || opcao == 'N');
	}

	public static boolean isSexo(char sexo) {

		if (sexo != 'F' && sexo != 'M')
			Visao.mensagemValorInvalido();
		return (sexo == 'F' || sexo == 'M');
	}

}
