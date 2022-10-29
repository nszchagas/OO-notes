package saida;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import dados.Grupo;
import dados.Pessoa;
import leitura.Leitura;
import validacao.Validacao;

public class Saida {

	// --------------------- CADASTRO DE PESSOA --------------------------------

	public static boolean verificaContinuarCadastro() {
		char opcao;

		do {
			System.out.println("Deseja cadastrar uma pessoa? (S ou N)");
			opcao = Leitura.getChar();
		} while (!Validacao.validaContinua(opcao));

		return (opcao == 's') ? true : false;

	}

	public static void mostraMensagemCadastro(int numeroDaPessoa) {

		System.out.println("Cadastre os dados da " + (numeroDaPessoa + 1) + "ª pessoa:");
	}

	public static float cadastraAltura() {
		float altura = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					System.out.println("Cadastre a altura:");
					altura = Leitura.getFloat();
				} while (!Validacao.validaAltura(altura));

				erro = false;
			} catch (InputMismatchException excecaoTipo) {
				mostraMensagemTipoErrado();
				erro = true;
			}
		}

		return altura;
	}

	public static int cadastraIdade() {
		int idade = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					System.out.println("Cadastre a idade:");
					idade = Leitura.getInt();
				} while (!Validacao.validaIdade(idade));

				erro = false;
			} catch (InputMismatchException excecaoTipo) {
				mostraMensagemTipoErrado();
				erro = true;
			}
		}

		return idade;
	}

	public static String cadastraNome() {
		String nome;
		do {
			System.out.println("Cadastre o nome:");
			nome = Leitura.getLinha();
		} while (!Validacao.validaNome(nome));

		return nome;
	}

	// --------------------- SAIDA DE RESULTADOS --------------------------------
	public static void mostraPessoa(Pessoa pessoa) {
		DecimalFormat centesimo = new DecimalFormat("0.00");

		System.out.print("  \t" + pessoa.getIdade() + "  \t |");
		System.out.print("  \t   " + centesimo.format(pessoa.getAltura()) + "  \t |");
		System.out.println("   " + pessoa.getNome());
	}

	public static void mostraTabela(Grupo grupo) {
		mostraCabecalho();
		for (int i = 0; i < grupo.getGrupo().length; i++) {
			if (grupo.getGrupo()[i] != null)
				mostraPessoa(grupo.getGrupo()[i]);
		}

	}

	public static void mostraCabecalho() {
		System.out.println("Dados cadastrados:");
		System.out.println("     IDADE \t | \t ALTURA \t | \t NOME");
		for (int i = 0; i < 64; i++)
			System.out.print("-");
		System.out.println();
	}

	// --------------------- MENSAGENS REAPROVEITAVEIS --------------------------

	public static void mostraMensagemProgramaEncerrado() {
		System.out.println("Programa encerrado com sucesso.");
	}

	public static void mostraMensagemCapacidadeMax(int capacidade) {
		limpaTela(45);
		System.out.println("A capacidade maxima de cadastros (" + capacidade
				+ ") foi atingida e o programa foi encerrado automaticamente.");
		limpaTela(3);
	}

	public static void mostraMensagemValorInvalido(float minimo, float maximo) {
		System.out.println("O valor digitado esta fora dos parametros estipulados (acima de  " + minimo
				+ " e abaixo de " + maximo + ").");

	}

	public static void mostraMensagemValorInvalido(int minimo) {
		System.out.println(
				"O valor digitado esta fora dos parametros estipulados (tamanho minimo de " + minimo + " caracteres).");

	}

	public static void mostraMensagemValorInvalido() {
		System.out.println("O valor digitado esta fora dos parametros estipulados.");
	}

	public static void mostraMensagemTipoErrado() {
		System.out.println("Ocorreu um erro! O valor digitado esta no formato errado.");
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
