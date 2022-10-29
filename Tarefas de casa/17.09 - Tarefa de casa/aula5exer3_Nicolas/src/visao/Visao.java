package visao;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Vector;

import dados.Pessoa;
import leitura.Leitura;
import servicos.Servicos;
import validacao.Validacao;

public class Visao {

	// etapas de cadastro

	public static boolean verificaContinuar(int numCadastro) {
		char opcao;
		final int MAXIMO = 1000;
		if (numCadastro >= MAXIMO) {
			System.out.println("Limite de cadastros atingido.");
			return false;
		}

		do {

			System.out.println("Deseja cadastrar um habitante? Digite SIM ou NÃO.");
			opcao = Leitura.leChar();
		} while (!Validacao.isCharContinuar(opcao));
		limpaTela(50);
		return ((opcao == 'S') ? true : false);
	}

	public static int registraIdade() {
		int idade = 0;
		boolean erro = true;

		while (erro) {
			try {
				do {
					mensagemCadastreParametro("idade");
					idade = Leitura.leInt();
				} while (!Validacao.isIdade(idade));
				erro = false;

			} catch (InputMismatchException erroFormato) {
				mensagemValorIncoerente();
				erro = true;
			}

		}
		limpaTela(2);

		return idade;
	}

	public static int registraNumeroDeFilhos() {
		int numDeFilhos = 0;
		boolean erro = true;

		while (erro) {
			try {

				do {

					mensagemCadastreParametro("numero de filhos");
					numDeFilhos = Leitura.leInt();
					erro = false;
				} while (!Validacao.isQuantidadeDeFilhos(numDeFilhos));

			} catch (InputMismatchException erroFormato) {
				mensagemValorIncoerente();
				erro = true;
			}

		}
		limpaTela(50);

		return numDeFilhos;
	}

	public static float registraSalario() {
		float salario = 0;
		boolean erro = true;

		while (erro) {
			try {

				do {

					mensagemCadastreParametro("salario");
					salario = Leitura.leFloat();
					erro = false;
				} while (!Validacao.isSalario(salario));

			} catch (InputMismatchException erroFormato) {
				mensagemValorIncoerente();
				erro = true;
			}

		}
		limpaTela(2);
		return salario;
	}

	public static char registraSexo() {
		char sexo = 'K';
		boolean erro = true;

		while (erro) {
			try {

				do {

					mensagemCadastreParametro("sexo (masculino ou feminino)");
					sexo = Leitura.leChar();
					erro = false;
				} while (!Validacao.isSexo(sexo));

			} catch (InputMismatchException erroFormato) {
				mensagemValorIncoerente();
				erro = true;
			}

		}
		limpaTela(2);
		return sexo;
	}

	// saida de resultados

	public static void mostraResultados(Vector<Pessoa> vetor) {
		final int SALARIOMINIMO = 300;
		DecimalFormat mascara = new DecimalFormat("0.00");
		if (vetor.size() > 0) {
			imprimeLinha(90);
			System.out.println("RESULTADO DO PROCESSAMENTO DOS DADOS:");

			System.out.println("\nMenor idade registrada: " + Servicos.getMenorIdade(vetor) + " anos.");
			System.out.println("\nMaior salario registrado: R$" + mascara.format(Servicos.getMaiorSalario(vetor)));
			System.out.println("\nMedia do numero de filhos entre os habitantes cadastrados: "
					+ mascara.format(Servicos.getMediaNumDeFilhos(vetor)));
			System.out.println("\nMedia salarial entre os habitantes cadastrados: R$"
					+ mascara.format(Servicos.getMediaSalario(vetor)));
			System.out.println("\nMedia salarial dos homens com salario acima de " + SALARIOMINIMO + " reais: R$"
					+ mascara.format(Servicos.getMediaSalarialMasculinaAcimaDeValor(vetor, SALARIOMINIMO)));
			System.out.println("\nQuantidade de habitantes com salario acima da media entre os habitantes registrados: "
					+ Servicos.getNumPessoasSalarioAcimaDaMedia(vetor));
			imprimeLinha(90);
		}

	}

	public static void mostraRegistros(Vector<Pessoa> vetor) {
		System.out.println("Foram registradas " + vetor.size() + " pessoas.");
		limpaTela(2);
		char opcao;
		if (vetor.size() > 0) {
			do {
				System.out.println("Deseja ver tabela com os dados cadastrados? Responda com SIM ou NÃO.");
				opcao = Leitura.leChar();
			} while (!Validacao.isCharContinuar(opcao));
			limpaTela(50);
			if (opcao == 'S')
				mostraTabela(vetor);
			else
				System.out.println("Programa encerrado com sucesso.");
		}
	}

	public static void mostraTabela(Vector<Pessoa> vetor) {
		mostraCabecalho();
		imprimeLinha(43);
		for (int aux = 0; aux < vetor.size(); aux++) {
			imprimeLinha(vetor.elementAt(aux));
		}
		limpaTela(2);
		System.out.println("Programa encerrado com sucesso.");
	}

	private static void imprimeLinha(Pessoa pessoa) {
		DecimalFormat mascaraFloat = new DecimalFormat("0.00");
		DecimalFormat mascaraInt = new DecimalFormat("00");

		System.out.print("  " + mascaraInt.format(pessoa.getIdade()) + "  |");
		System.out.print(pessoa.getSexoExtenso() + " |");
		System.out.print("      " + mascaraInt.format(pessoa.getNumeroDeFilhos()) + "      |");
		System.out.println(" " + mascaraFloat.format(pessoa.getSalario()));

	}

	private static void mostraCabecalho() {
		System.out.println("Idade |    Sexo    | Nº de filhos | Salario");
	}

	// mensagens reaproveitáveis

	public static void mensagemCadastreNumPessoa(int numero) {
		limpaTela(50);
		System.out.println("Abaixo cadastre os dados da " + (numero + 1) + "ª pessoa:");
	}

	private static void mensagemCadastreParametro(String parametro) {
		System.out.println("Registre um valor para " + parametro + " do habitante.");
	}

	public static void mensagemValorIncoerente() {
		System.out.println("Ocorreu um erro! O valor digitado é incoerente com o formato esperado.");
	}

	public static void mensagemValorInvalido(int min, int max) {
		System.out.println(
				"O valor digitado esta fora dos parametros definidos. (Acima de " + min + " e abaixo de " + max + ")");
	}

	public static void mensagemTamanhoInvalido(int min) {
		System.out.println("O valor digitado esta fora dos parametros definidos. (Tamanho maior que " + min + ")");
	}

	public static void mensagemValorInvalido(int min) {
		System.out.println("O valor digitado esta fora dos parametros definidos. (Maior ou igual a " + min + ")");
	}

	public static void mensagemValorInvalido() {
		System.out.println("O valor digitado é inválido.");
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

	public static void imprimeLinha(int tamanho) {
		for (int i = 0; i < tamanho; i++)
			System.out.print("-");
		System.out.println();

	}
}
