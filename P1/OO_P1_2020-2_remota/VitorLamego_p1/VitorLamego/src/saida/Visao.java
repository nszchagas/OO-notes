package saida;

import java.text.DecimalFormat;

import dados.*;

public class Visao {
	
	public static void exibirMenuPrincipal() {
		System.out.println("---------------------MENU---------------------");
		System.out.println("1- Registar nova pessoa");
		System.out.println("2- Relatório de Registros");
		System.out.println("0- Sair");
	}
	
	public static void menuSituacao() {
		limpaConsole(5);
		System.out.println("A seguir escolha qual opçao voce se avalia, digite a letra designada para a opcao escolhida: ");
		System.out.println("T - Contaminada em Tratamento");
		System.out.println("F - Contaminada Falecida");
		System.out.println("C - Contaminada Curada");
		System.out.println("S - Sem Contaminacação\n");
	}
	
	public static void menuGestacao() {
		limpaConsole(5);
		System.out.println("Você já foi gestante ? Sua resposta deve conter somente uma das letras indicadas a seguir \n");
		System.out.println("S - Sim");
		System.out.println("N - Não");
		System.out.println("T - Não tenho certeza");
	}
	
	public static void menuSexo() {
		System.out.println("Escolha o sexo da pessoa que irá cadastrar: \n");
		System.out.println("1 - HOMEM");
		System.out.println("2 - MULHER\n");
	}
	
	public static void mostraRelatorio(Populacao populacao) {
		limpaConsole(5);
		String formato = "%-20s%-20s%-30s%-20s%-20s\n";
		System.out.format(formato, "IDENTIFICADOR" ,"NOME COMPLETO", "SITUACAO", "IDADE", "GESTANTE");
		
		for(Pessoa pessoa : populacao.getPopulacao())
			System.out.println(pessoa);
		
	}
	
	public static void resumoRegistros(Populacao populacao) {
		limpaConsole(40);
		
		DecimalFormat mascara = new DecimalFormat("00");
		int contaminadosCurados = 0, contaminadosTratamento = 0, contaminadosFalecidos = 0, homensNaoContaminados = 0, mulheresNaoContaminadas = 0;
		
		for (Pessoa pessoa : populacao.getPopulacao()) {
			if (pessoa.getEstadoSaude() == 'T')
				contaminadosTratamento++;
			else if (pessoa.getEstadoSaude() == 'F')
				contaminadosFalecidos++;
			else if (pessoa.getEstadoSaude() == 'C')
				contaminadosCurados++;
			else {
				if(pessoa instanceof Homem)
					homensNaoContaminados++;
				else
					mulheresNaoContaminadas++;
			}
		}
		
		System.out.println(mascara.format(contaminadosCurados) + " = CONTAMINADOS CURADOS");
		System.out.println(mascara.format(contaminadosTratamento) + " = CONTAMINADOS EM TRATAMENTO");
		System.out.println(mascara.format(contaminadosFalecidos) + " = CONTAMINADOS FALECIDOS");
		System.out.println(mascara.format(homensNaoContaminados) + " = HOMENS SEM CONTAMINACAO");
		System.out.println(mascara.format(mulheresNaoContaminadas) + " = MULHERES SEM CONTAMINACAO");
		System.out.println("-----------------------------------");
		System.out.println(mascara.format(populacao.getPopulacao().size()) + " = TOTAL DE REGISTROS DE PESSOAS");
	}
	
	public static void limpaConsole(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
}