package validacao;

import java.util.List;

import javax.swing.JOptionPane;

import dados.Cidade;
import visao.Visao;

public class Validacao {

	public static boolean isNome(String nome) {
		if (nome.length() < 3)
			Visao.mostraMsg("O nome deve ter pelo menos tres caracteres!", JOptionPane.ERROR_MESSAGE);
		return (nome.length() >= 3);

	}

	public static boolean isCidadeNova(Cidade cidade, List<Cidade> lista) {
		if (lista.contains(cidade))
			Visao.mostraMsg("Cidade ja cadastrada!", JOptionPane.ERROR_MESSAGE);
		return !lista.contains(cidade);
	}

	public static boolean isDDD(int DDD) {
		final int MENOR_DDD = 11;
		final int MAIOR_DDD = 99;
		if (DDD > MAIOR_DDD || DDD < MENOR_DDD)
			Visao.mostraMsg("O DDD deve estar entre: " + MENOR_DDD + " e " + MAIOR_DDD, JOptionPane.ERROR_MESSAGE);
		return (DDD <= MAIOR_DDD && DDD >= MENOR_DDD);

	}
}
