package validacao;

import dados.ColecaoEmpregados;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static String validaString (String mensagem, String titulo) {
		String valor = "";
		
		do {
			try {
				valor = Leitura.lerEntrada(mensagem, titulo);
				if (valor.isEmpty() && isStringComDigitos(valor)) {
					Visao.mostraMensagemErro("Error, o valor de entrada nao deve ser vazio e nem possuir digitos.");
				}
			} catch (NullPointerException e) {
				Visao.mostraMensagemErro("Error, opcao indisponivel no momento!");
			}
		} while (valor.isEmpty() && isStringComDigitos(valor));
		return valor;
	}
	
	public static float validaFloat (String mensagem, String titulo, final float MIN) {
		float valor = MIN;
		do {
			try {
				valor = Float.parseFloat(Leitura.lerEntrada(mensagem, titulo));
				if (valor <= MIN) {
					Visao.mostraMensagemErro("Error, o valor deve ser maior que " + MIN + ".");
				}
			} catch (NumberFormatException e) {
				Visao.mostraMensagemErro("Error, o valor de entradada deve ser numerico.");
			} catch (NullPointerException e) {
				Visao.mostraMensagemErro("Error, opcao indisponivel no momento!");
			}
		} while (valor <= MIN);
		return valor;
	}
	
	public static int validaMatricula (String mensagem, String titulo, final int MIN, ColecaoEmpregados empregados) {
		int valor;
		do {
			valor = validaInteiro(mensagem, titulo, MIN);
			if (empregados.isInteiroRepetido(valor)) {
				Visao.mostraMensagemErro("Error, a Matricula deve ser unica.");
			}
		} while (empregados.isInteiroRepetido(valor));
		return valor;
	}
	
	public static int validaInteiro (String mensagem, String titulo, final int MIN) {
		int valor = MIN;
		do {
			try {
				valor = Integer.parseInt(Leitura.lerEntrada(mensagem, titulo));
				if (valor <= MIN) {
					Visao.mostraMensagemErro("Error, o valor deve ser maior que " + MIN + ".");
				}
			} catch (NumberFormatException e) {
				Visao.mostraMensagemErro("Error, o valor de entradada deve ser numerico.");
			} catch (NullPointerException e) {
				Visao.mostraMensagemErro("Error, opcao indisponivel no momento!");
			}
		} while (valor <= MIN);
		return valor;
	}
	
	private static boolean isStringComDigitos (String valor) {
		for (char c : valor.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
