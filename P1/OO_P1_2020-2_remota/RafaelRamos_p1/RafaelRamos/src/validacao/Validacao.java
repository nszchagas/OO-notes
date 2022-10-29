package validacao;

import java.util.InputMismatchException;

import dados.Pessoa;
import dados.Populacao;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static int validaInteiro() {
		int valor;

		try {
			valor = Leitura.leiaInt();
		} catch (InputMismatchException e) {
			Visao.mostraMsgErro("Erro, a entrada deve ser um inteiro.");
			valor = validaInteiro();
		}
		return valor;
	}

	public static int validaInteiro(String nomeNumero, String mensagem, final int MIN, final int MAX) {
		int valor;
		Visao.mostraMsg(mensagem);
		try {
			valor = Leitura.leiaInt();
			if (valor < MIN || valor > MAX) {
				Visao.mostraMsgErro(
						nomeNumero + " deve ser um numero entre " + MIN + " e " + MAX + ", tente novamente.");
				return validaInteiro(nomeNumero, mensagem, MIN, MAX);
			}
		} catch (InputMismatchException erro) {
			Visao.mostraMsgErro(nomeNumero + " deve ser um numero inteiro, tente novamente.");
			return validaInteiro(nomeNumero, mensagem, MIN, MAX);
		}

		return valor;
	}

	public static String validaNome() {
		Visao.mostraMsg("Digite o nome completo desta pessoa:");
		String nome = Leitura.leiaString();

		if (nome.length() <= 2 || isNomeComDigitos(nome)) {
			Visao.mostraMsgErro("Erro, o nome deve possuir mais que 2 caracteres e nao pode ter digitos.");
			nome = validaNome();
		}

		return nome;
	}

	public static int validaNumCadastro(Populacao populacao) {
		Visao.mostraMsg("Digite o numero de cadastro desta pessoa:");
		int numCadastro = validaInteiro();
		final int MAIOR = 100;
		if (numCadastro <= MAIOR || isNumCadastroIgual(populacao, numCadastro)) {
			Visao.mostraMsgErro("ERRO, o numero de cadastro deve ser maior que 100 e nao pode se repetir.");
			return validaNumCadastro(populacao);
		}

		return numCadastro;
	}

	private static boolean isNumCadastroIgual(Populacao populacao, int numCadastro) {
		for (Pessoa pessoa : populacao.getPopulacao()) {
			if (pessoa.getNumCadastro() == numCadastro)
				return true;
		}
		return false;
	}

	public static char validaSaude() {
		Visao.mostraMsg(
				"Digite o estado da saude da pessoa\nT = contaminado(a) em Tratamento\nF = contaminado(a) falecido(a)\nC = contaminado(a) curado(a)\nS = Sem contaminação");
		return validaChar("TFCS");
	}

	public static int validaIdade() {
		int idade = validaInteiro("idade", "Digite a idade deste homem:", 0, 150);
		return idade;
	}

	public static char validaGestante() {
		Visao.mostraMsg("Essa mulher ja foi gestante ?\nS = sim.\nN = não.\nT = não tem certeza.");
		return validaChar("SNT");
	}

	public static char validaChar(String caracteresValidos) {
		char caracter;

		caracter = Leitura.leiaChar();
		while (!caracteresValidos.contains(Character.toString(caracter))) {
			Visao.mostraMsgErro("Entrada invalida! Tente novamente:");
			caracter = Leitura.leiaChar();
		}
		return caracter;
	}

	public static char validaMenu() {

		Visao.mostraMsg(
				"Escolha uma das opcoes\n[0] Sair do programa.\n[1] - Novo registro.\n[2] - Relatorio de todos os registros.");
		return validaChar("012");
	}

	public static char validaSexo() {
		Visao.mostraMsg("Digite o sexo correspondente a essa pessoa: (M/F):");
		return validaChar("MF");
	}

	private static boolean isNomeComDigitos(String nome) {
		for (char c : nome.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
