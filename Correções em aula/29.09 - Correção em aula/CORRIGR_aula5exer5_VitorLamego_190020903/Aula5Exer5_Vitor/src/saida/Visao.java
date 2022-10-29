package saida;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import dados.Aluno;
import dados.Turma;
import leitura.Leitura;
import servicos.Servicos;
import validacao.Validacao;

public class Visao {
	// cadastro de dados //

	
	// try catch usando recursividade // 
	
	public static boolean verificaIniciarCadastro() {
		char opcao;
		do {
			mensagemCadastrarAluno();
			opcao = Leitura.leCaracter();
		} while (!Validacao.isContinuaCadastro(opcao));
		return (opcao == 'S');
	}

	public static String cadastraNome() {
		String nome;
		do {
			solicitarDado("nome completo");
			nome = Leitura.leString();
		} while (!Validacao.isNome(nome));
		return nome;
	}

	public static float cadastraMedia() {
		float media = -1f;
		boolean erro = true;
		while (erro) {
			try {
				do {
					solicitarDado("media final");
					media = Leitura.leFloat();
				} while (!Validacao.isMedia(media));
				erro = false;
			} catch (InputMismatchException e) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		Visao.limpaTela(1);
		return media;
	}

	public static int cadastraMatricula(Turma turma) {
		int matricula = 0;
		boolean erro = true;
		while (erro) {
			try {
				do {
					solicitarDado("matricula");
					matricula = Leitura.leInteiro();
				} while (!Validacao.isMatricula(matricula, turma));
				erro = false;
			} catch (InputMismatchException e) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		return matricula;
	}

	// apresentacao de dados //
	public static void mostraRelatorio(Turma turma) {
		if (turma.getAlunos().size() == 0) {
			programaEncerrado(0);
		} else {
			DecimalFormat mascara = new DecimalFormat("0.00");

			limpaTela(35);
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("MATRICULA\t\t\tNOME\t\t\t\tMEDIA FINAL");
			System.out.println("---------------------------------------------------------------------------------");

			for (int i = 0; i < turma.getAlunos().size(); i++) {
				imprimeLinha(turma.getAluno(i));
			}
			System.out.println("\n\nMEDIA GERAL: " + mascara.format(Servicos.calculaMediaGeral(turma)));

			limpaTela(2);
			programaEncerrado(turma.getAlunos().size());
		}
	}

	private static void imprimeLinha(Aluno aluno) {
		DecimalFormat mascara = new DecimalFormat("0.00");
		System.out.println(aluno.getMatricula() + "\t\t" + aluno.getNomeCompleto() + "\t\t\t\t"
				+ mascara.format(aluno.getMediaFinal()));
	}

	// mensagems reaproveitáveis //

	public static void mensagemInicioCadastro() {
		System.out.println("\n-------------------------------CADASTRO-------------------------------");

	}

	public static void mensagemMatriculaRepetida() {
		System.out.println("\nMatricula ja existente! Impossivel cadastrar outro aluno com a mesma matricula.");
	}

	public static void mensagemValorInvalido(int min) {
		System.out.println("O valor digitado esta fora dos parametros, deve ser maior do que: " + min);
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

	public static void mensagemNomeInvalido(int min) {
		System.out.println("Nome invalido. Digite o nome completo. Cada nome deve ter pelo menos " + min + " letras.");
	}

	public static void mensagemCaractereInvalido() {
		System.out.println("Opção inválida. Digite 'SIM' ou 'NÃO'.");
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
