package visao;

import java.util.InputMismatchException;
import java.util.Vector;

import dados.Pessoa;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {

	// mensagens de cadastro

	public static StringBuilder cadastraNome() {

		StringBuilder nome;
		do {
			mensagemCadastreNome();
			nome = Leitura.leStringBuilder();

		} while (!Validacao.isNome(nome));

		limpaTela(30);
		return nome;

	}

	private static int menuEscolha() {

		int escolha = 5;
		boolean erro = true;

		while (erro) {
			try {
				System.out.print("Lista de cadastros encerrada. ");

				do {
					System.out.println("Escolha uma opção:");
					mostraMenuOpcoes();
					escolha = Leitura.leInt();

				} while (!Validacao.isEscolhaValida(escolha));

				erro = false;

			} catch (InputMismatchException erroFormato) {
				mensagemValorIncoerente();
				limpaTela(3);
				erro = true;
			}
		}
		limpaTela(3);

		return escolha;
	}

	public static void imprimeResultados(Vector<Pessoa> vetor) {
		switch (menuEscolha()) {
		case 0:
			mostraMensagemListaEncerrada(vetor.size());
			break;
		case 1:
			mostraNomesSequencia(vetor);
			break;
		case 2:
			mostraNomesSequenciaInversa(vetor);
			break;

		default:
		}
		limpaTela(2);

	}

	public static boolean verificaContinuar() {
		char opcao = 'k';
		do {

			System.out.println("Deseja cadastrar outro nome? Digite SIM ou NÃO.");
			opcao = Leitura.leChar();
		} while (!Validacao.isCharContinuar(opcao));
		limpaTela(30);
		return ((opcao == 's') ? true : false);
	}

	public static boolean verificaIniciarCadastros() {
		char opcao = 'k';
		do {

			System.out.println("Deseja iniciar uma nova lista de cadastros? Digite SIM ou NÃO.");
			opcao = Leitura.leChar();
		} while (!Validacao.isCharContinuar(opcao));
		limpaTela(30);
		return ((opcao == 's') ? true : false);
	}

	private static void mostraNomesSequencia(Vector<Pessoa> vetor) {
		mostraMensagemListaEncerrada(vetor.size());
		System.out.println("Nomes cadastrados, em sequencia de cadastro:");
		for (int i = 0; i < vetor.size(); i++)
			System.out.println("Nome nº " + (i + 1) + ": " + vetor.elementAt(i).getNome());
	}

	private static void mostraNomesSequenciaInversa(Vector<Pessoa> vetor) {
		mostraMensagemListaEncerrada(vetor.size());
		System.out.println("Nomes cadastrados, em sequencia inversa a do cadastro:");
		for (int i = vetor.size() - 1; i >= 0; i--)
			System.out.println("Nome nº " + (vetor.size() - i) + ": " + vetor.elementAt(i).getNome());

	}

	private static void mostraMenuOpcoes() {
		System.out.println("1 - Visualizar os nomes na sequência cadastrada.");
		System.out.println("2 - Visualizar os nomes na sequência inversa de cadastro.");
		System.out.println("0 - Sair do programa sem visualizar os nomes cadastrados.");
		System.out.println("\nDigite o número correspondente à opção escolhida.");
	}

	private static void mostraMensagemListaEncerrada(int tamanho) {
		System.out.println("Lista encerrada com sucesso. Foram cadastrados " + tamanho + " nomes.");
		limpaTela(3);
	}

	public static void programaEncerrado() {
		System.out.println("Programa encerrado com sucesso.");
	}

	private static void mensagemCadastreNome() {
		System.out.println("Cadastre um nome:");
	}

	public static void mensagemValorInvalido() {
		System.out.println("O valor digitado é inválido.");
	}

	public static void mensagemValorInvalido(int minimo) {
		System.out.println("O valor digitado é inválido. Digite nome com no mínimo " + minimo + " caracteres.");
	}

	private static void mensagemValorIncoerente() {
		System.out.println("Ocorreu um erro! O valor digitado é incoerente com o formato esperado.");
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
