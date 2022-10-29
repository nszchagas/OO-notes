package validacao;

import dados.ColecaoTimes;
import dados.TimeFutebol;
import leitura.Leitura;
import saida.Visao;

public class Validacao {
	public static String validaNome (String mensagem, String titulo, ColecaoTimes colecaoTimes) {
		String nome = "";
		
		do {
			try {
				nome = Leitura.lerEntrada(mensagem, titulo);
				if (nome.isEmpty() || isNomeComNumeros(nome) || isNomeRepetido(nome, colecaoTimes)) {
					Visao.mostraMensagemErro("Nome nao pode ser vazio, nem conter numeros");
				}
			} catch (NullPointerException e) {
				if (Visao.mostraMenuConfirmacao("Deseja Cancelar ?", "Cancelar") == 0) {
					throw e;
				}
			}
		} while (nome.isEmpty() || isNomeComNumeros(nome) || isNomeRepetido(nome, colecaoTimes));
		return nome;
	}
	
	public static int validaAno (String mensagem, String titulo) {
		final int ANO_MIN = 1900, ANO_MAX = 2200;
		int ano = ANO_MIN - 1;
		
		do {
			try {
				ano = Integer.parseInt(Leitura.lerEntrada(mensagem, titulo));
				
				if (ano <= ANO_MIN || ano >= ANO_MAX) {
					Visao.mostraMensagemErro("O ano deve estar entre " + ANO_MIN + " e " + ANO_MAX + ".");
				}
			} catch (NumberFormatException ex) {
				Visao.mostraMensagemErro("Digite um numero.");
			} catch (NullPointerException e) {
				if (Visao.mostraMenuConfirmacao("Deseja Cancelar ?", "Cancelar") == 0) {
					throw e;
				}
			}
		} while (ano <= ANO_MIN || ano >= ANO_MAX);
		return ano;
	}
	
	private static boolean isNomeComNumeros (String nome) {
		for (char c : nome.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isNomeRepetido (String nome, ColecaoTimes colecaoTimes) {
		for (TimeFutebol timeFutebol : colecaoTimes.getColecaoTimes()) {
			if (timeFutebol.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
}
