package validacao;

import javax.swing.JOptionPane;

import dados.Time;
import visao.Visao;

public class Validacao {

	public static boolean isAno(int ano, Time time) {
		final int ANO_MIN = 1900, ANO_MAX = 2200;
		if (ano > ANO_MIN && ano < ANO_MAX) {
			if (time.getAnos().contains(ano))
				Visao.mostraMensagem("Esse titulo ja foi cadastrado!", "Atencao", JOptionPane.ERROR_MESSAGE);
		} else
			Visao.mostraMensagem("O ano inserido esta fora dos paramentros: entre " + ANO_MIN + " e " + ANO_MAX, "erro",
					JOptionPane.ERROR_MESSAGE);
		return (!time.getAnos().contains(ano) && ano > ANO_MIN && ano < ANO_MAX);
	}

	public static boolean isNome(String nome) {
		if (nome.length() < 3)
			Visao.mostraMensagem("O nome deve ter pelo menos 3 caracteres", "Erro", JOptionPane.ERROR_MESSAGE);
		return (nome.length() >= 3);
	}

}
