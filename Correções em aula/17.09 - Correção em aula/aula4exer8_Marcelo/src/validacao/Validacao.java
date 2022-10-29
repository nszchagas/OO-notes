package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;


public class Validacao {
	private static boolean qtdSemanasEhValido(short qtdSemanas){
		if(qtdSemanas==3 || qtdSemanas==4)
			return true;
		else
			return false;
	}
	public static short validaQtdSemanas(){
		short qtdSemanas=0;
		do{
			System.out.println("Digite a quantidade de semanas contabeis do mes: ");
			try{
				qtdSemanas = Leitura.lerShort();
				if(!qtdSemanasEhValido(qtdSemanas))
					System.out.println("Valor invalido. O mes tem de 3 a 4 semanas contabeis.");
			}catch(InputMismatchException e){
				System.out.println("Valor incoerente. O mes tem de 3 a 4 semanas contabeis.");
			}
		}while(!qtdSemanasEhValido(qtdSemanas));
		return qtdSemanas;
	}
	
	
	private static boolean totalVendasEhValido(int totalVendas){
		if(totalVendas >= 0)
			return true;
		else
			return false;
	}
	public static int validaTotalVendas(){
		int totalVendas = -1;
		do{
			try {
				totalVendas=Leitura.lerInt();
					if(!totalVendasEhValido(totalVendas))
						System.out.println("Valor invalido.");
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido.");
			}
		}while(!totalVendasEhValido(totalVendas));
		return totalVendas;
	}
	public static int[] validaArrayTotalVendas(int qtdMeses){
		int[] arrayTotalVendas = new int[qtdMeses];
		for(int count = 0; count < qtdMeses; count++){
			System.out.println("na semana " + (count+1) + ": ");
			arrayTotalVendas[count] = validaTotalVendas();
		}

		return arrayTotalVendas;
	}
}