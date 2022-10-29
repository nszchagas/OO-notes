package visao;

import dados.Vendas;

public class Saida {
	public static void mostraResultados (Vendas vendas, final int LIMITE, short qtdSemanas) {
		Saida.limpaTela(30);
		System.out.println("Analises Finais");
		System.out.println("=================");
		somaVendedores(vendas, LIMITE, qtdSemanas);
	}
	
	// Salta linhas (limpa tela)
	public static void limpaTela (int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
	
	public static int somaSemanas (Vendas vendas, int vendedor, final int qtdSemanas) {
		// Declaracoes
		int somaSemanas = 0;
		
		// Instrucoes
		for (int semana = 0; semana < qtdSemanas; semana++)
			somaSemanas += vendas.getVendas(vendedor, semana);

		System.out.println("Quantidade de vendas do Vendedor " + (vendedor + 1) + ": " + somaSemanas);
		return somaSemanas;
	}
	
	public static int somaVendedores (Vendas vendas, final int LIMITE, short qtdSemanas) {
		// Declaracoes
		int somaTotal = 0;
		int semana, somaVendedor = 0;
		
		// Instrucoes
		for (int vendedor = 0; vendedor < LIMITE; vendedor++)
			somaTotal += somaSemanas(vendas, vendedor, qtdSemanas);
		
		Saida.limpaTela(2);
		for (semana = 0; semana < qtdSemanas; semana++, somaVendedor = 0) {
			for (int vendedor = 0; vendedor < LIMITE; vendedor++) {
				somaVendedor += vendas.getVendas(vendedor, semana);
			}
			System.out.println("Quantidade de vendas na Semana " + (semana + 1) + ": " + somaVendedor);
		}
		limpaTela(2);
		System.out.println("Quantidade total de Vendas em " + qtdSemanas + " Semanas: " + somaTotal);
		return somaTotal;
	}
}
