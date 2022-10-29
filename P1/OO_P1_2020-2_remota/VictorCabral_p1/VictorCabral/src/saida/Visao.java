package saida;

import dados.*;

public class Visao {
	
	public static void mensagemInicial() {
		System.out.println("Registre seguintes dados da pessoa:");
	}
	
	public static void exibirMenuInicial() {
		System.out.println("\nInforme a opcao desejada:" + "\n1 = Registro novo"
				+ "\n2 = Relatório de todos registros" + "\n0 = Sair");
	}

	public static void tabela(int opcao, Populacao populacao) {
		Visao.limpaTela(40);
		String formato = "%-30s%-30s%-35s%-30s%-20s\n";
		
		System.out.format(formato, "IDENTIFICADOR", "NOME COMPLETO",
				"SITUACAO DE SAUDE", "IDADE", "GESTANTE");
		Visao.imprimeTraco(150);
		limpaTela(1);
		for(Pessoa pessoa : populacao.getPopulacao()) {
			System.out.println(pessoa.toString());
		}
	}

	//TERMINAR
	public static void resultado(Pessoa pessoa) {
		System.out.println(pessoa.contaminadosCurados()+ " = CONTAMINADOS CURADOS");
		System.out.println(pessoa.contaminadosEmTratamento()+ " = CONTAMINADOS EM TRATAMENTO");
		System.out.println(pessoa.contaminadosFalecidos()+ " = CONTAMINADOS EM TRATAMENTO");
	}

	public static void limpaTela(int qtdLinhas) {
		for (int aux = 0; aux < qtdLinhas; aux++)
			System.out.println();
	}

	public static void imprimeTraco(int qtdTracos) {
		for (int aux = 0; aux < qtdTracos; aux++)
			System.out.print("-");
	}

}
