package validacao;

import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static String validaString() {
		String valor;

		while ((valor = Leitura.leString()).length() < 3) {
			Visao.mostraMensagem("A entrada deve ter mais do que 3 caracteres! Tente novamente.");
		}
		
		Visao.limpaTela(50);

		return valor;
	}

	public static char validaChar(String caracteresValidos) {
		char caracter;

		caracter = Leitura.leChar();
		while (!caracteresValidos.contains(Character.toString(caracter))) {
			Visao.mostraMensagem("Entrada invalida, deve ser 'sim' ou 'nao'! Tente novamente.");
			caracter = Leitura.leChar();
		}
		Visao.limpaTela(50);

		return caracter;
	}

	public static boolean validaCadastroNome() {
		Visao.mostraMensagem("Deseja cadastrar um novo nome? 'S' para sim e 'N' para nao");
		return validaChar("SN") == 'S';
	}

	public static String validaNome() {
		Visao.mostraMensagem("Digite um nome para cadastra-lo.");
		return validaString();
	}

	public static char validaRelatorio() {
		Visao.mostraMensagem("Opcoes de visualizacao dos cadastros");
		Visao.mostraMensagem("[1] - Sequencia de insercao\n[2] - Sequencia inversa de insercao\n[0] - Sair");
		Visao.mostraMensagem("Escolha uma das opcoes");
		return validaChar("012");
	}

	public static boolean validaNovoGrupo() {
		Visao.mostraMensagem("[1] - Criar nova lista de nomes\n[0] - Finalizar Programa");
		Visao.mostraMensagem("Escolha uma das opcoes");
		return validaChar("01") == '1';
	}

}
