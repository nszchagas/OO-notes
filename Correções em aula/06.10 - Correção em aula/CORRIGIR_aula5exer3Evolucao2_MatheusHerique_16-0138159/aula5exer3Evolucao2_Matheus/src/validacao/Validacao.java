package validacao;

import java.util.InputMismatchException;
import leitura.Leitura;
import saida.Saida;

public class Validacao {
	public static boolean validaContinua() {
		// Declaracoes
		char opcao;

		// Instrucoes
		do {
			System.out.println("Deseja continuar cadastrando?\n Digite 'S' para sim e 'N' para nao");
			opcao = Leitura.leituraChar();
			Saida.limpaTela(2);
			if ((opcao != 'S') && (opcao != 'N'))
				System.out.print("Opcao invalida!");
		} while ((opcao != 'S') && (opcao != 'N'));
		return (opcao == 'S');

	}

	// Valida Salário
	public static float validaSalario() {
		// Declaracoes
		float salario = -1f;

		// Instrucoes
		do {
			System.out.println("Digite o salario do habitante a ser cadastrado:");
			try {
				salario = Leitura.leituraFloat();
				Saida.limpaTela(2);
				if (salario < 0f)
					System.out.println("Valor invalido!\nSalario nao pode ser menor que R$: 0.00");
			} catch (InputMismatchException excecao) {
				System.out.println("Ocorreu um  erro.Digite apenas numeros!");
			}
		} while (salario < 0f);
		return salario;
	}

	// Valida Idade
	public static int validaIdade() {
		// Declaracoes
		int idade = 0;

		// Instrucoes
		do {
			System.out.println("Digite a Idade do habitante a ser cadastrado ");
			try {
				idade = Leitura.leituraInt();
				Saida.limpaTela(2);
				if (idade <= 0 || idade >= 151)
					System.out.println("Valor invalido!\nIdade tem que ser maior que zero e menor que 151");
			} catch (InputMismatchException excecao) {
				System.out.println("Ocorreu um  erro.Digite apenas numeros!");
			}
		} while (idade <= 0 || idade >= 151);
		return idade;
	}

	// Valida Sexo
	public static char validaSexo() {
		// Declaracoes
		char sexo;

		// Instrucoes
		do {
			System.out.println(
					"Digite o Sexo do habitante a ser cadastrado('M' para \"masculino\" ou 'F' para \"feminino\") ");
			sexo = Leitura.leituraChar();
			Saida.limpaTela(2);
			if ((sexo != 'M') && (sexo != 'F'))
				System.out.print("Opcao invalida! ");
		} while ((sexo != 'M') && (sexo != 'F'));
		return sexo;
	}

	// Valida número de filhos
	public static int validaNumeroFilhos() {
		// Declaracoes
		int numeroFilhos = -1;

		// Instrucoes
		do {
			System.out.println("Digite o número de filhos do habitante a ser cadastrado ");
			try {
				numeroFilhos = Leitura.leituraInt();
				Saida.limpaTela(2);
				if (numeroFilhos < 0 || numeroFilhos >= 100)
					System.out.println(
							"Valor inválido!\nNúmero de filhos tem que ser maior ou igual a zero e menor que 100");
			} catch (InputMismatchException excecao) {
				System.out.println("Ocorreu um  erro.");
			}
		} while (numeroFilhos < 0 || numeroFilhos >= 100);
		return numeroFilhos;
	}
}
