package visao;

import servicos.Servicos;
import dados.Loja;

public class Visao {
	public static void mostraResultadoFinal(Loja loja) {
		Servicos.limpaTela(50);
		
		System.out.println("Resultado das Vendas\n==============================");
		Servicos.totalVendasVendedor(loja);
		Servicos.limpaTela(2);
		Servicos.totalVendasSemanas(loja);
		Servicos.limpaTela(2);
		Servicos.totalVendasMes(loja);
	}
}
