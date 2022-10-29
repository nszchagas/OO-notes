package validacao;

import dados.Pais;
import leitura.Leitura;
import visao.Saida;

public class Validacao {

	static StringBuilder validaString(String msg, String titulo) {
		StringBuilder lido = new StringBuilder();

		if ((lido.append(Leitura.lerShowInputDialog(msg, titulo).trim())).length() == 0) {
			Saida.exibirMensagemDeAviso("A entrada nao pode ser vazia.");
			return validaString(msg, titulo);
		}
		return lido;
	}

	public static int validaInt(String solicitacao, String titulo) {
		final int MIN = 0;
		int numero;

		try {
			numero = Integer.parseInt(validaString(solicitacao, titulo).toString());
			if (numero < MIN) {
				Saida.exibirMensagemDeAviso("O numero nao pode ser menor que " + MIN + ".");
				numero = validaInt(solicitacao, titulo);
			}
		} catch (NumberFormatException e) {
			Saida.exibirMensagemDeErro("\nEntrada invalida! Insira apenas um numero inteiro.");
			numero = validaInt(solicitacao, titulo);
		}
		return numero;
	}

	static boolean isNomeComNumeros(StringBuilder nome) {
		for (char c : nome.toString().toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	static boolean isNumeroDeMortosValido(int contaminados, int mortos) {
		if (contaminados >= mortos)
			return true;
		return false;
	}

	// VALIDACOES DE DADOS
	public static StringBuilder validaCidade() {
		final int MIN_CARACTERES = 3;
		StringBuilder cidade = validaString("Informe o nome da cidade:", "CADASTRO DE CIDADE");

		if (cidade.length() < MIN_CARACTERES || isNomeComNumeros(cidade)) {
			Saida.exibirMensagemDeErro("O nome da cidade deve possuir pelo menos " + MIN_CARACTERES
					+ " caracteres e nao pode possuir numeros.");
			return validaCidade();
		}
		return cidade;
	}

	public static StringBuilder validaEstado(Pais mundo, StringBuilder cidade) {
		final int QTD_CARACTERES = 2;
		StringBuilder estado = validaString("Informe a sigla do estado:", "CADASTRO DE ESTADO");

		if (estado.length() != QTD_CARACTERES || isNomeComNumeros(estado)) {
			Saida.exibirMensagemDeErro("A sigla do estado deve possuir exatamente " + QTD_CARACTERES
					+ " caracteres e nao pode possuir numeros.");
			return validaEstado(mundo, cidade);
		}

		if (mundo.contains(cidade, estado)) {
			Saida.exibirMensagemDeErro("Cidade ja cadastrada!");
			throw new NullPointerException();
		}
		return estado;
	}

	public static int validaContaminados() {
		return validaInt("Informe a quantidade de contaminados:", "CADASTRO DE CONTAMINADOS");
	}

	public static int validaMortos(int contaminados) {
		int mortos = validaInt("Informe a quantidade de mortos:", "CADASTRO DE MORTOS");

		if (!isNumeroDeMortosValido(contaminados, mortos)) {
			Saida.exibirMensagemDeErro(
					"A quantidade de mortos nao pode ser maior do que a de contaminados (" + contaminados + ").");
			return validaMortos(contaminados);
		}
		return mortos;
	}

	// VALIDACOES DE MENU
	public static char validaMenuCadastral() {
		String[] opcoes = { "Nova Cidade", "Pesquisa Cidade Contaminada" };
		return (char) Leitura.lerMenuOpcoes(opcoes);
	}
}
