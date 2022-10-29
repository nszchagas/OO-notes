package visao;

import dados.Passageiro;
import leitura.Leitura;
import validacao.Validacao;

public class Visao {

	// cadastros de nome //

	public static StringBuilder cadastraNome() {
		StringBuilder nome;
		do {
			solicitarNome();
			nome = Leitura.leituraStringBuilder();
		} while (!Validacao.isNome(nome));

		return nome;

	}

	// registrar desejo de continuar //

	public static boolean registraDesejoContinuar() {
		char opcao = 'k';
		do {
			mensagemDesejaContinuar();
			opcao = Leitura.leChar();
		} while (!Validacao.isOpcaoContinuar(opcao));
		limpaTela(50);
		return (opcao == 'S');

	}

	// saida de resultados //

	public static void mostraResultado(Passageiro passageiro) {
		limpaTela(50);
		System.out.println("Nome concatenado: " + passageiro.getNomeConcatenado());
		limpaTela(2);
	}

	// mensagens //

	public static void programaEncerrado(int numero) {
		System.out.println("Programa encerrado com sucesso. Foram concatenados " + numero + " nomes.");
	}

	public static void solicitarNome() {
		System.out.println("Digite o nome completo do passageiro:");
	}

	private static void mensagemDesejaContinuar() {
		System.out.println("Deseja concatenar um nome? (SIM ou NAO)");
	}

	public static void digiteUmCaractereValido() {
		limpaTela(1);
		System.out.println("Entrada invalida. Digite apenas 'SIM' ou 'NAO'.");
	}

	public static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++)
			System.out.println();
	}

	public static void mensagemNomeInvalido() {
		System.out.println("Entrada invalida. Digite no mínimo dois nomes com três caracteres cada.");
	}
}
