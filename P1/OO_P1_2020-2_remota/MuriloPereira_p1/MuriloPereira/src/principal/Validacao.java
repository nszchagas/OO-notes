package principal;

import java.util.InputMismatchException;

public class Validacao {

	public static String validaNome() {

		System.out.println("Insira o nome completo para cadastro:");
		String nome = Leitura.lerNome();
		while (nome.isEmpty() || nome == null) {
			System.err.println("Nao eh aceito deixar esse campo em branco. Insira novamente: ");
			nome = Leitura.lerNome();
		}
		return nome;
	}

	public static char validaGenero() {
		System.out.println("Insira o genero da pessoa ('M' para Masculino e 'F' para Feminino): ");
		char genero = Leitura.lerChar();
		while (genero != 'M' && genero != 'F') {
			System.err.println("ENTRADA INVALIDA. Insira somente 'M' ou 'F': ");
			genero = Leitura.lerChar();
		}
		return genero;
	}

	public static char validaSituacaoSaude() {
		System.out.println(
				"Insira 'E'(em tratamento), 'F'(falecido) ou 'C'(curado) para informar a situacao da pessoa: ");
		char situacaoSaude = Leitura.lerChar();
		while (situacaoSaude != 'E' && situacaoSaude != 'F' && situacaoSaude != 'C') {
			System.err.println("ENTRADA INVAIDA. Insira somente 'E' ou 'F' ou 'C':");
			situacaoSaude = Leitura.lerChar();
		}
		return situacaoSaude;
	}

	public static int validaIdade() {
		int idade = 0;
		System.out.println("Insira a idade da pessoa: ");

		try {
			idade = Leitura.lerInt();
			while (idade < 0 || idade > 130) {
				System.err.println("ENTRADA INVALIDA. Insira uma idade maior que 0 e menor que 130: ");
				idade = Leitura.lerInt();
			}
		} catch (InputMismatchException e) {
			System.err.println("ERRO. Insira somente numeros naturais: ");
			validaIdade();
		}
		return idade;
	}

	public static int validadIdentificador() {
		final int MINIMO = 1;
		int identificador = 0;
		System.out.println("Informe o numero de identificacao da pessoa a ser cadastrada: ");
		try {
			identificador = Leitura.lerIdentificador();
			while (identificador <= MINIMO) {
				System.err.println("O numero identificador deve ser maior que " + MINIMO + ". Insira novamente: ");
				identificador = Leitura.lerIdentificador();
			}
		} catch (InputMismatchException e) {
			System.err.println("ERRO. Insira somente numeros(naturais): ");
			validadIdentificador();
		}
		return identificador;
	}
	
	public static int validaMenu() {
		int validaMenu = 0;
		System.out.println("Escolha uma das opcoes: ");
		System.out.println("1 = Novo Cadastro");
		System.out.println("2 = Mostra Todos Cadastros");
		System.out.println("3 = Encerra");
		
		try {
			validaMenu = Leitura.lerInt();
			while (validaMenu!=1 && validaMenu!=2 && validaMenu!=3) {
				System.err.println("ENTRADA INVALIDA. Escolha somente uma das opcoes(1 ou 2 ou 3): ");
				validaMenu = Leitura.lerInt();
			}
		} catch (Exception e) {
			System.err.println("ERRO. Insira somente numeros(naturais): ");
			validaMenu();
		}
		return validaMenu;
	}

}
