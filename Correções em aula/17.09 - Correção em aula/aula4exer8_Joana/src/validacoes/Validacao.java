package validacoes;

import java.util.InputMismatchException;

import Leitura.Leitura;


public class Validacao {
	// Valicao de inteiros
	public static int validaInt () {
		// Atributo local
		int valor = 0;
		boolean erro = false;
		
		do {
			try {
				valor = Leitura.lerInt();
				if (valor < 0 || valor > 10000) {
					System.out.println("Valor fora do intervalo esperado (0 - 10000)\nDigite novamente: ");
					erro = true;
				}
				else {
					erro = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro, entrada fora do padrão esperado (inteiros)\nDigite novamente: ");
				erro = true;
			}	
		} while (erro);
		
		return valor;
	}
	
	private static boolean qtdSemanasEhValido(short qtdSemanas){
		if(qtdSemanas==3 || qtdSemanas==4)
			return true;
		else
			return false;
	}
	
	public static short validaQtdSemanas(){
		short qtdSemanas=0;
		do{
			System.out.println("Digite a quantidade de semanas contabeis do mes (3 ou 4): ");
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
	
/*	public static char validaEscolha () {
		char escolha = 0;
		
		System.out.println("Continuar para a semana 4?\nDigite 'S' para sim ou 'N' para nao: ");
		do {
			escolha = Leitura.lerChar();
			if (escolha != 'S' && escolha != 'N') {
				System.out.println("Erro, valor fora dos padroes esperados!\nTente novamente: ");
			}
		} while (escolha != 'S' && escolha != 'N');
		
		return escolha;
	}
*/	
}
