package validacao;

import java.util.InputMismatchException;
import dados.Pessoa;
import dados.Populacao;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	// TERMINAR
	public static String validaCodigo(Populacao populacao) {
		// Declaracoes
		String codigoPessoa;
		final int MAIOR = 100;

		// Instrucoes
		System.out.println("\nInforme o codigo da pessoa (deve ser um valor inteiro e sequencial): ");
		codigoPessoa = Leitura.lerString();

		if (isCodigoRepetido(populacao, codigoPessoa)) {
			System.err.println("\nCodigo ja inserido!");
			Validacao.validaCodigo(populacao);
		}

		while (codigoPessoa.length() != 3 || codigoPessoa.length() != 4 || isCodigoComLetras(codigoPessoa)) {
			System.err.println(
					"\nCodigo invalido! Informe um codigo maior que " + MAIOR + ". Apenas digitos sao permitidos.");
			codigoPessoa = Leitura.lerString();
		}
		return codigoPessoa;
	}

	public static boolean isCodigoRepetido(Populacao populacao, String codigoPessoa) {
		// Instrucoes
		for (Pessoa pessoa : populacao.getPopulacao()) {
			if (pessoa.getCodigoPessoa().equals(codigoPessoa)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCodigoComLetras(String codigo) {
		// Instrucoes
		for (char c : codigo.toCharArray()) {
			if (Character.isLetter(c)) {
				return true;
			}
		}
		return false;
	}

	public static StringBuilder validaNome() {
		// Declaracoes
		String nome;
		StringBuilder stringBuilder = new StringBuilder();

		// Instrucoes
		System.out.println("\nInforme o nome da pessoa: ");
		nome = Leitura.lerString();

		while (nome.split(" ").length < 2 || nome.isBlank()) {
			System.err.println("\nNome invalido! Informe tambem o sobrenome.");
			nome = Leitura.lerString();
		}
		stringBuilder.append(nome);

		return stringBuilder;
	}

	public static boolean isNomeComNumeros(String palavra) {
		// Instrucoes
		for (char c : palavra.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	public static char validaSituacaoSaude() {
		// Declaracoes
		char situacaoSaude;

		// Instrucoes
		System.out.println(
				"\nInforme a situacao de saude da pessoa (T = contaminada em Tratamento, F = contaminada falecida, C = contaminada Curada e S = Sem contaminação): ");
		try {
			situacaoSaude = Leitura.lerChar();

			while (situacaoSaude != 'T' && situacaoSaude != 'F' && situacaoSaude != 'C' && situacaoSaude != 'S') {
				System.err.println("\nSituacao de saude invalida! Deve ser 'T', 'F', 'C' ou 'S'.");
				situacaoSaude = validaSituacaoSaude();
			}
		} catch (InputMismatchException e) {
			System.err.println("\nEntrada invalida! Insira apenas letra.");
			situacaoSaude = validaSituacaoSaude();
		}
		return situacaoSaude;
	}
	
	public static char validaSexo() {
		// Declaracoes
		char sexo;

		// Instrucoes
		System.out.println("\nInforme o sexo da pessoa (M = masculino e F = feminino): ");
		try {
			sexo = Leitura.lerChar();

			while (sexo != 'M' && sexo != 'F') {
				System.err.println("\nSexo invalido! Deve ser 'M' ou 'F'.");
				sexo = validaSexo();
			}
		} catch (InputMismatchException e) {
			System.err.println("\nEntrada invalida! Insira apenas letra.");
			sexo = validaSexo();
		}
		return sexo;
	}
	
	public static int validaIdade() {
		// Declaracoes
		int idade = 0;
		final int MAX = 150;
		
		// Instrucoes
		do {
			System.out.println("\nIdade da pessoa: ");
			try {
				idade = Leitura.lerInt();
				Visao.limpaTela(2);
				if (idade < 0 || idade > MAX)
					System.err.println("\nValor invalido!\nDeve ser maior que 0 e menor que " + MAX + ". Tente novamente:\n");
			} catch (InputMismatchException excecao) {
				System.err.println("\nOcorreu um  erro. Digite apenas numeros!");
			}
		} while (idade < 0 || idade > MAX);
		Visao.limpaTela(1);
		return idade;
	}
	
	public static char validaHistoricoGestante() {
		// Declaracoes
		char historicoGestante;

		// Instrucoes
		System.out.println("\nInforme se ela já foi gestante (S = sim, N = não ou T = não tem certeza): ");
		try {
			historicoGestante = Leitura.lerChar();

			while (historicoGestante != 'S' || historicoGestante != 'N' || historicoGestante != 'T') {
				System.err.println("Historico de gestante invalido! Deve ser 'S', 'N' ou 'T'.");
				historicoGestante = validaHistoricoGestante();
			}
		} catch (InputMismatchException e) {
			System.err.println("\nEntrada invalida! Insira apenas letra.");
			historicoGestante = validaHistoricoGestante();
		}
		return historicoGestante;
	}

	public static int validaMenuInicial() {
		// Declaracoes
		int opcao;

		// Instrucoes
		do {
			Visao.exibirMenuInicial();
			try {
				opcao = Leitura.lerInt();
				if (opcao < 0 || opcao > 2) {
					System.err.println("\nOpcao invalida! Insira um numero de 0 a 2");
					opcao = validaMenuInicial();
				}
			} catch (InputMismatchException e) {
				System.err.println("\nOpcao invalida! Insira apenas um numero");
				opcao = validaMenuInicial();
			}
		} while (opcao < 0 || opcao > 2);
		return opcao;
	}
}
