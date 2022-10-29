package visao;

import java.util.InputMismatchException;
import java.util.Vector;

import dados.Evento;
import dados.PresidentesBrasileiros;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {
	// controle de fluxo

	public static boolean verificaContinuar() {

		char opcao = 'k';
		do {
			mensagemContinuarCadastro();
			opcao = Leitura.leChar();
		} while (!Validacao.isContinuar(opcao));

		limpaTela(30);
		return (opcao == 's');

	}

	// mensagens de cadastro

	public static Evento cadastraEvento() {

		int ano = cadastraAno();
		String nome = cadastraNome(ano);
		String evento = cadastraEventoImportante();

		return new Evento(ano, nome, evento);
	}

	public static int cadastraAno() {
		int ano = 0;
		boolean erro = true;

		while (erro) {
			try {
				do {
					mensagemCadastro("ano, entre 1900 e 2020:");
					ano = Leitura.leInt();
				} while (!Validacao.isAno(ano));
				erro = false;
			} catch (InputMismatchException e) {
				mensagemValorIncoerente();
				erro = true;
			}
		}
		limpaTela(30);
		return ano;
	}

	public static String cadastraNome(int ano) {
		String nome;
		do {
			mensagemCadastro("nome do presidente (sem acentos graficos), no ano de " + ano + ".");
			nome = Leitura.leString();
		} while (!Validacao.isPresidenteCorreto(nome, ano));
		limpaTela(30);
		return nome;
	}

	public static String cadastraEventoImportante() {
		String evento;
		do {
			mensagemCadastro("um evento marcante que ocorreu no ano digitado.");
			evento = Leitura.leString();
		} while (!Validacao.isNome(evento));
		limpaTela(30);
		return evento;
	}

	// apresentacao de dados

	public static void apresentaDados(Vector<Evento> vetorAnos) {
		imprimeCabecalho();
		for (int contador = 0; contador < vetorAnos.size(); contador++)
			imprimeLinha(vetorAnos.elementAt(contador));
		limpaTela(2);
		mensagemProgramaEncerrado(vetorAnos.size());

	}

	private static void imprimeLinha(Evento evento) {

		imprimeTextoEspaco(evento.getAno().toString().toUpperCase(), 13);
		System.out.print("|");
		imprimeTextoEspaco(evento.getEventoImportante().toUpperCase(), 43);
		System.out.print("|    ");
		System.out.print(evento.getPresidenteAno().toUpperCase());
		System.out.println(" (" + PresidentesBrasileiros.getNomePresidenteAno(evento.getAno()).toUpperCase() + ")");
	}

	private static void imprimeCabecalho() {
		System.out.println("     ANO     |                  EVENTO                   |       PRESIDENTE ");
		imprimeLinhaHorizontal(90);
	}

	private static void imprimeLinhaHorizontal(int tamanho) {
		for (int i = 0; i < tamanho; i++)
			System.out.print("-");
		System.out.println();

	}

	private static void imprimeTextoEspaco(String texto, int tamanho) {
		System.out.print("    ");
		System.out.print(texto);
		for (int contador = texto.length(); contador < tamanho - 4; contador++)
			System.out.print(" ");
	}

	// mensagens reaproveitaveis

	public static void mensagemProgramaEncerrado(int cadastros) {
		System.out.println("Programa encerrado com sucesso. Registros efetuados: " + cadastros + ".");
	}

	public static void mensagemContinuarCadastro() {
		System.out.println("Deseja continuar o cadastro? Responda com: sim ou nao.");
	}

	public static void mensagemValorIncoerente() {
		System.out.println("Ocorreu um erro! O valor digitado nao esta no formato solicitado.");
	}

	public static void mensagemCadastro(String dado) {
		System.out.println("Digite um valor para " + dado);
	}

	public static void mensagemValorInvalido(int min) {
		System.out
				.println("O dado digitado nao esta de acordo com os parametros exigidos. Digite texto com mais do que "
						+ min + " caraceteres.");
	}

	public static void mensagemValorInvalido() {
		System.out.println("O dado digitado nao esta de acordo com os parametros exigidos. Insira novamente.");
	}

	public static void mensagemValorInvalido(int min, int max) {

		System.out.println(
				"O dado digitado nao esta de acordo com os parametros exigidos. Deve estar entre " + min + " e " + max);
	}

	public static void mensagemPresidenteInvalido(String nome, int ano) {

		System.out.println("O presidente digitado esta incorreto. No ano de " + ano
				+ " o(s) presidente(s) do Brasil foi (foram): " + nome + ".");
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}
