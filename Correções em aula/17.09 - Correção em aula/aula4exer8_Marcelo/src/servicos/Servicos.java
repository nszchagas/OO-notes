package servicos;

import dados.Loja;

public class Servicos {
	public static void limpaTela(int NUMLINHAS){
		for(int count = 0 ; count < NUMLINHAS; count++)
			System.out.println();
	}
	public static void totalVendasVendedor(Loja loja){
		int totalVendasVendedor[] = new int[loja.getTotalVendasVendedores().length];

		for(int count = 0; count<loja.getTotalVendasVendedores().length; count++){
			totalVendasVendedor[count]=0;
		}
		for(int count = 0; count<loja.getTotalVendasVendedores().length; count++){
			for(int count2 = 0; count2<loja.getTotalVendasVendedores()[0].getTotalVendasMes().length; count2++){
				totalVendasVendedor[count]+=loja.getTotalVendasVendedores()[count].getTotalVendasMes()[count2];
			}
			System.out.println("\tO total de vendas do vendedor "+ (count+1) + " = " + totalVendasVendedor[count]);
		}
	}
	public static void totalVendasSemanas(Loja loja){
		int totalVendasSemanas[] = new int[loja.getTotalVendasVendedores()[0].getTotalVendasMes().length];

		for(int count = 0; count<loja.getTotalVendasVendedores()[0].getTotalVendasMes().length; count++){
			totalVendasSemanas[count]=0;
		}
		for(int count = 0; count<loja.getTotalVendasVendedores()[0].getTotalVendasMes().length; count++){
			for(int count2 = 0; count2<loja.getTotalVendasVendedores().length; count2++){
				totalVendasSemanas[count]+=loja.getTotalVendasVendedores()[count2].getTotalVendasMes()[count];
			}
			System.out.println("\tO total de vendas na semana "+ (count+1)+ " = " + totalVendasSemanas[count]);
		}		
	}
	public static void totalVendasMes(Loja loja){
		int totalVendas = 0;
		for(int count = 0; count<loja.getTotalVendasVendedores()[0].getTotalVendasMes().length; count++){
			for(int count2 = 0; count2<loja.getTotalVendasVendedores().length; count2++){
				totalVendas+=loja.getTotalVendasVendedores()[count2].getTotalVendasMes()[count];
			}
		}
		System.out.println("O total de vendas no mes = " + totalVendas);
	}
}