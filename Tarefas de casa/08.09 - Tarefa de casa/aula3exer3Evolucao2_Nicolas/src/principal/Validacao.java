package principal;

import java.util.InputMismatchException;

public class Validacao {

	// Valida opcao de continuar cadastro
	public static boolean validaContinua(char opcao) {

		while ((opcao != 'S') && (opcao != 'N')) {
			Servicos.limpaTela(30);
			System.out.print("Opção inválida! Continuar cadastrando?\nDigite 'S' para sim e 'N' para não: ");
			opcao = Leitura.leituraChar();
		}

		return ((opcao == 'S') ? true : false);
	}

	// Valida Altura
	public static float validaAltura() {
		// Declaracoes
		boolean erro = false;
		float altura = 0;

		// Instrucoes
		do {
			System.out.println("Digite a altura da pessoa a ser cadastrada:");
			try {
				altura = Leitura.leituraFloat();
				if (altura < 0.4 || altura > 2.6) {
					Servicos.limpaTela(2);
					System.out.println("Valor inválido!");
					erro = true;
				} else
					erro = false;
			} catch (InputMismatchException excecao) {
				System.out.println("O formato digitado é inválido. Insira novamente.");
				erro = true;
			}
		} while (erro);
		return altura;
	}

	// Vallida Idade
	public static int validaIdade() {
		// Declaracoes
		boolean erro = false;
		int idade = 0;

		// Instrucoes
		do {
			System.out.println("Digite a idade da pessoa a ser cadastrada ");
			try {
				idade = Leitura.leituraInt();
				if (idade <= 0 || idade > 150) {
					Servicos.limpaTela(2);
					System.out.println("Valor inválido!");
					erro = true;
				} else
					erro = false;
			} catch (InputMismatchException excecao) {
				System.out.println("O formato digitado é inválido. Insira novamente.");
				erro = true;
			}
		} while (erro);
		return idade;
	}

	// Valida Nome
	public static String validaNome() {
		// Declaracao
		String nome;

		// Instrucoes
		System.out.println("Digite o nome da pessoa a ser cadastrada ");
		nome = Leitura.leituraLinha();

		while (nome.length() < 3) {
			Servicos.limpaTela(2);
			System.out.print("Nome invalido! O nome deve ter pelo menos 3 caracteres.\nDigite o nome novamente: ");
			nome = Leitura.leituraLinha();
		}
		return nome;
	}
}
