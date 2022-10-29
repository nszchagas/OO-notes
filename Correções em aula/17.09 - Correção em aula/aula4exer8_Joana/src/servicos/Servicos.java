package servicos;

import dados.Vendas;
import validacoes.Validacao;
import visao.Saida;

public class Servicos {
	public static void armazenaValores (Vendas vendas, final int LIMITE, short qtdSemanas) {
		// Vendedores
		for (int vendedor = 0; vendedor < LIMITE; vendedor++) {
			System.out.println("Vendedor " + (vendedor+1));
			
			// Semanas
			for (int semana = 0; semana < qtdSemanas; semana++) {
				System.out.print("Quantidade vendida na semana " + (semana+1) + ": ");
				vendas.setVendas(vendedor, semana, Validacao.validaInt());
			}
			Saida.limpaTela(10);
		}
	}
}
