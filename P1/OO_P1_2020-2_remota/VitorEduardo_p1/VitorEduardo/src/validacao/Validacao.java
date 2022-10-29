package validacao;

import java.util.InputMismatchException;

import leitura.Leitura;
import saida.Visao;

public class Validacao {

	public static String validaNome() {
		String nome;

		System.out.println("Nome Completo: ");
		nome = Leitura.leiaString().toUpperCase();

		while (nome.length() < 3 || nome.equals(null) || nome.trim().equals("")) {
			if (nome.equals("") || nome.trim().equals("")) {
				Visao.limpaTela(2);
				System.out.println("Nenhum nome foi informado, tente novamente: ");
				nome = Leitura.leiaString().toUpperCase().toUpperCase();
			} else {
				System.out.print("Nome invalido! O nome deve ter pelo menos 3 caracteres.\nDigite o nome novamente: ");
				nome = Leitura.leiaString().toUpperCase();
			}
		}
		return nome;
	}

	public static String validaSituacaoSaude() {
		String sit_saude;

		do {
			System.out.println(
					"T - Contaminada em Tratamento\nF - Contaminada Falecida\nC - Contaminada Curada\nS - Sem Contaminacao\nInforme apenas o caracter Referente a Situacao de Saude!\nSituacao de Saude");
			sit_saude = Leitura.leiaString();
			if(sit_saude.equals("T") && sit_saude.equals("F") && sit_saude.equals("C") && sit_saude.equals("S")) {
				System.out.println("Caracter invalido, informe somente os caracteres T, F, C ou S referentes a situacao de saude!");
			}
		}while(sit_saude.equals("T") && sit_saude.equals("F") && sit_saude.equals("C") && sit_saude.equals("S"));
		return sit_saude;
	}
	
	public static int validaIdade(int MINIMO, int MAXIMO) {
		int idade = 0;
		
		do {
			try {	
				System.out.println("Idade: ");
				idade = Leitura.leiaInt();
				if(idade < MINIMO && idade > MAXIMO) {
					System.out.println("Idade invalida, tente novamente\nIdade: ");
				}
			}catch(InputMismatchException excecao) {
				System.err.println("Valor incoerente, tente novamente");
			}
		}while(idade < MINIMO && idade > MAXIMO);
		return idade;
	}
	
	public static String validaGestante() {
		String gestante;

		do {
			System.out.println(
					"S - SIM\nN - NAO\nT - NAO TEM CERTEZA\nInforme apenas o caracter Referente!\nJa foi gestante? : ");
			gestante = Leitura.leiaString();
			if(gestante.equals("S") && gestante.equals("N") && gestante.equals("T")) {
				System.out.println("Caracter invalido, informe somente os caracteres T, F, C ou S referentes a situacao de saude!");
			}
		}while(gestante.equals("S") && gestante.equals("N") && gestante.equals("T"));
		return gestante;
	}
}
