package principal;

import dados.Vendas;
import servicos.*;
import validacoes.Validacao;
import visao.Saida;

public class Principal {
	public static void main (String[] args) {
		// DECLARACOES
		final int LIMITE = 4;  // Varia entre 3 ou 4 semanas
		short qtdSemanas;
		
		// INSTRUCOES
		qtdSemanas = Validacao.validaQtdSemanas();
		
		Vendas vendas = new Vendas (LIMITE, qtdSemanas);
		
		Servicos.armazenaValores(vendas, LIMITE, qtdSemanas);
		Saida.mostraResultados(vendas, LIMITE, qtdSemanas);
	}
}
