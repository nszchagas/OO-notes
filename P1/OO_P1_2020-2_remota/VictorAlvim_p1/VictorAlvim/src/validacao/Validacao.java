package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import visao.Saida;

public class Validacao {
	public static String validaNome() {
		String nome;
		final int MINIMO = 2;
		do {
			nome = Leitura.lerString();
			if (nome.isEmpty())
				Saida.mensagemErro("O nome nao pode ser vazio!\nTente novamente");
			else if (nome.length() <= MINIMO)
				Saida.mensagemErro("O nome deve possuir mais que "+MINIMO+" caracteres!\nTente novamente");
			else if (isNomeComDigito(nome))
				Saida.mensagemErro("O nome nao pode conter numeros!\nTente novamente");
		} while (nome.isEmpty() || nome.length() <= MINIMO || isNomeComDigito(nome) );
		return nome;
	}

	public static boolean isNomeComDigito(String nome) {
		for (char caractere : nome.toCharArray()) {
			if (Character.isDigit(caractere)) {
				return true;
			}
		}
		return false;
	}
	
	public static char validaCaracter(String possibilidades) {
		char caracter;
		
		do {
			caracter = Leitura.lerChar();
			if(!possibilidades.toUpperCase().contains(String.valueOf(caracter))) {
				Saida.mensagemErro("Insira apenas alguma das opcoes validas!\nTente novamente");
			}
		}while(!possibilidades.toUpperCase().contains(String.valueOf(caracter)));
		
		return caracter;
	}

	public static int validaInt(final int MINIMO, final int MAXIMO) {
		int numero;
		do {
			Saida.mensagem("Insira o numero");
			try {
				numero = Leitura.lerInt();
			} catch (InputMismatchException excecao) {
				Saida.mensagemErro("Voce precisa inserir apenas numeros inteiros!\nTente novamente");
				return validaInt(MINIMO, MAXIMO);
			}
			if (numero < MINIMO || numero > MAXIMO)
				Saida.mensagemErro("Insira um numero entre " + MINIMO + " e " + MAXIMO);
		} while (numero < MINIMO || numero > MAXIMO);
		return numero;
	}

	public static boolean validaContinua() {
		char continuar;

		do {
			Saida.limpaTela(2);
			Saida.mensagem("Deseja ver o menu novamente? [S/N]");
			Saida.mensagem("S = abrir o menu novamente");
			Saida.mensagem("N = encerrar execucao do programa");
			continuar = Leitura.lerChar();
			if (continuar != 'S' && continuar != 'N')
				Saida.mensagemErro("Insira S para SIM ou N para NAO");
		} while (continuar != 'S' && continuar != 'N');

		return ((continuar == 'S') ? true : false);
	}
}
