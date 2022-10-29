package visao;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Vector;

import dados.Aluno;
import leitura.Leitura;
import servicos.Servicos;
import validacao.Validacao;

public class Visao {

	// cadastro de dados do aluno //

	public static StringBuilder cadastraNome() {
		StringBuilder nome;
		do {
			solicitarDado("nome completo");
			nome = Leitura.leStringBuilder();
		} while (!Validacao.isNome(nome));
		limpaTela(5);
		return nome;
	}

	public static float cadastraMediaFinal() {
		float media = 0f;
		boolean erro = true;

		while (erro) {
			try {
				do {
					solicitarDado("media final");
					media = Leitura.leFloat();
				} while (!Validacao.isMedia(media));
				erro = false;
			} catch (InputMismatchException erroFormato) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		limpaTela(30);
		return media;
	}

	public static int cadastraMatricula(Vector<Aluno> turma) {
		int matricula = 0;
		boolean erro = true;

		while (erro) {
			try {
				do {
					solicitarDado("matricula");
					matricula = Leitura.leInt();
				} while (!Validacao.isMatriculaValida(turma, matricula));
				erro = false;
			} catch (InputMismatchException erroFormato) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		limpaTela(30);
		return matricula;
	}

	// controle de fluxo //

	public static boolean verificaContinuar() {
		char opcao = 'k';

		do {
			mensagemCadastrarAluno();
			opcao = Leitura.leChar();
		} while (!Validacao.isOpcaoContinuar(opcao));
		limpaTela(30);
		return ((opcao == 's') ? true : false);
	}

	// saida de resultados //

	public static void mostraResultado(Vector<Aluno> turma) {
		limpaTela(50);
		if (turma.size() > 0) {
			imprimeCabecalhoTabela();
			for (int i = 0; i < turma.size(); i++)
				imprimeLinhaTabela(turma.elementAt(i));
			imprimeUltimaLinha(turma);
		}
		limpaTela(2);
		programaEncerrado(turma.size());

	}

	private static void imprimeLinhaTabela(Aluno aluno) {
		DecimalFormat mascara = new DecimalFormat("0.00");
		imprimeTextoAjustado(aluno.getMatricula(), 14);
		System.out.print("| ");
		imprimeTextoAjustado(aluno.getNome().toString(), 69);
		System.out.println("| " + mascara.format(aluno.getMediaFinal()));

	}

	private static void imprimeTextoAjustado(Integer numero, int tamanho) {
		System.out.print(numero);
		for (int aux = 0; aux < tamanho - numero.toString().length(); aux++)
			System.out.print(" ");

	}

	private static void imprimeTextoAjustado(String texto, int tamanho) {
		System.out.print(texto);
		for (int aux = 0; aux < tamanho - texto.length(); aux++)
			System.out.print(" ");

	}

	private static void imprimeCabecalhoTabela() {
		System.out.println("\t\t\t\t\tAlunos cadastrados");
		System.out.println(
				"Matricula     |                               Nome                                   | Media final");
		imprimeLinhaHorizontal(95);
	}

	private static void imprimeUltimaLinha(Vector<Aluno> turma) {
		DecimalFormat mascara = new DecimalFormat("0.00");

		imprimeLinhaHorizontal(95);
		System.out.print("Media final da turma");
		imprimeEspacoHorizontal(65);
		System.out.println("| " + mascara.format(Servicos.calculaMediaTurma(turma)));
	}

	private static void imprimeLinhaHorizontal(int tamanho) {
		for (int i = 0; i < tamanho; i++)
			System.out.print("-");
		System.out.println();
	}

	private static void imprimeEspacoHorizontal(int tamanho) {
		for (int i = 0; i < tamanho; i++)
			System.out.print(" ");
	}

	public static void mensagemMatriculaRepetida() {
		System.out.println("A matricula inserida já foi utilizada. Insira outro valor.");
	}

	public static void mensagemValorInvalido(int min) {
		System.out.println("O valor digitado está fora dos parâmetros, deve ser maior do que " + min);
	}

	private static void programaEncerrado(int num) {
		System.out.println("Programa encerrado com sucesso. Foram efetuados " + num + " registros.");
	}

	private static void mensagemCadastrarAluno() {
		System.out.println("Deseja cadastrar um aluno? (SIM ou NAO)");
	}

	public static void mensagemValorInvalido(int min, int max) {
		System.out.println("Valor invalido. Digite valor entre " + min + " e " + max + ".");
	}

	private static void mensagemValorIncoerente() {
		System.out.println("Ocorreu um erro! O valor digitado é incoerente com o formato esperado.");
	}

	private static void solicitarDado(String parametro) {
		limpaTela(3);
		System.out.println("Insira um valor para " + parametro + " do aluno:");
	}

	public static void mensagemNomeInvalido() {
		System.out.println("Nome invalido. Digite o nome completo.");
	}

	public static void mensagemCaractereInvalido() {
		System.out.println("Opção inválida. Digite 'SIM' ou 'NÃO'.");
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
