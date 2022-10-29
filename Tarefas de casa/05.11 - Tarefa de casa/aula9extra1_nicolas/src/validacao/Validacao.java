package validacao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.Cidade;
import visao.Visao;

public class Validacao {

	public static boolean isCidadeNova(Cidade cidadeRecebida, ArrayList<Cidade> cidadesCadastradas) {
		if (cidadesCadastradas.contains(cidadeRecebida))
			Visao.mostraMensagem("Cidade ja cadastrada", JOptionPane.ERROR_MESSAGE);

		return (!cidadesCadastradas.contains(cidadeRecebida));

	}

	public static boolean isNome(String nome) {
		String[] nomesSeparados = nome.split(" ");
		boolean valido = true;
		int aux = 0;
		while (valido && aux < nomesSeparados.length)
			valido = (nomesSeparados[aux++].length() >= 3);
		if (!valido)
			Visao.mostraMensagem("O nome da cidade deve possuir pelo menos 3 caracteres", JOptionPane.ERROR_MESSAGE);
		return valido;
	}

	public static boolean isQuantidade(final int MIN, final int MAX, int quantidade) {
		if (quantidade > MAX || quantidade < MIN)
			Visao.mostraMensagem("Esse numero deve estar entre " + MIN + " e " + MAX + ".", JOptionPane.ERROR_MESSAGE);
		return (quantidade <= MAX && quantidade >= MIN);
	}
}
