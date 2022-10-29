package validacao;

import leitura.Leitura;
import saida.Saida;

public class Validacao {

	// VALIDACAO DO NOME
	public static boolean validaNome(String nome) {
		int espacos = 0;

		for (int aux = 0; aux < nome.length(); aux++) {
			if (nome.charAt(aux) == ' ') {
				espacos++;
			}
		}

		// EVITAR ENTER COMO ENTRADA
		if (nome.length() != 0) {

			if (espacos == 0) {
				Saida.nomeInvalido();
				return false;
			} else {
				return true;
			}

		} else {
			Saida.entradaVaziaInvalida();
			return false;
		}
	}

	// PRIMEIRO NOME
	public static StringBuilder primeiroNome(String nome) {
		// DECLARACOES
		int primeiroEspaco = 0;

		// INSTRUCOES
		for (int aux = 0; aux < nome.length(); aux++) {
			if (nome.charAt(aux) == ' ') {
				primeiroEspaco = aux;
				break;
			}
		}

		StringBuilder nomeInicial = new StringBuilder(nome);
		nomeInicial.delete(primeiroEspaco, nome.length());

		return nomeInicial;
	}

	// ÚLTIMO NOME
	public static StringBuilder ultimoNome(String nome) {
		// DECLARACOES
		int ultimoEspaco = 0;

		// INSTRUCOES
		for (int aux = 0; aux < nome.length(); aux++) {
			if (nome.charAt(aux) == ' ') {
				ultimoEspaco = aux;
			}
		}

		StringBuilder nomeFinal = new StringBuilder(nome);
		nomeFinal.delete(0, ultimoEspaco + 1);

		return nomeFinal;
	}

	public static boolean validaContinua() {
		// DECLARACOES
		String opcao;
		boolean aux;

		// INSTRUCOES
		Saida.verificarContinuacao();
		do {
			opcao = Leitura.leituraString();

			if (opcao.length() > 1) {
				Saida.digiteApenasUmCaractere();
				aux = false;
			} else if (!opcao.equals("S") && !opcao.equals("N")) {
				Saida.digiteUmCaractereValido();
				aux = false;
			} else {
				aux = true;
			}
		} while (!aux);

		Saida.limpaTela(40);

		return (opcao.equals("S") ? true : false);

	}

}
