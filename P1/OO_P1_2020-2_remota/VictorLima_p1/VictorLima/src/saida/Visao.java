package saida;

import java.util.ArrayList;
import java.text.DecimalFormat;
import dados.*;

public class Visao {
	public static void exibirTipoCadastro() {
		System.out.println("\nInforme a opcao desejada:");
		System.out.println("1 - CADASTRAR UMA MULHER");
		System.out.println("2 - CADASTRAR UM HOMEM");

	}

	public static void exibirMenu() {
		System.out.println("\nInforme a opcao desejada:");
		System.out.println("0 - SAIR");
		System.out.println("1 - REGISTRO NOVO");
		System.out.println("2 - RELATORIO DE TODOS OS REGISTROS");

	}

	public static void mostraRegistros(ArrayList<Pessoa> populacao) {
		System.out.println("Id pessoa\t\t\tNome\t\t\tSituacao\t\t\tidade\t\t\tgravidez");
		for (Pessoa pessoa : populacao) {
			System.out.println(pessoa);
		}

	}

	public static void mostraProgramaEncerrado(ArrayList<Pessoa> populacao) {
		int contaminadosCurados = 0;
		int contaminadosEmTratamento = 0;
		int contaminadosFalecidos = 0;
		int mulheresSemContaminacao = 0;
		int homensSemContaminacao = 0;
		int total =0;
		DecimalFormat mascara = new DecimalFormat("00");
		for (Pessoa pessoa : populacao) {
			if (pessoa.getSituacao().equals("CONTAMINADA EM TRATAMENTO")) {
				contaminadosEmTratamento++;
			}
			if (pessoa.getSituacao().equals("CONTAMINADA FALECIDA")) {
				contaminadosFalecidos++;
			}
			if (pessoa.getSituacao().equals("CONTAMINADA CURADA")) {
				contaminadosCurados++;
			}
			if (pessoa.getSituacao().equals("SEM CONTAMINACAO") && pessoa instanceof Homem) {
				homensSemContaminacao++;
			}
			if (pessoa.getSituacao().equals("SEM CONTAMINACAO") && pessoa instanceof Mulher) {
				mulheresSemContaminacao++;
			}
		}
		total = contaminadosCurados+contaminadosEmTratamento+contaminadosFalecidos+homensSemContaminacao+mulheresSemContaminacao;
		System.out.println(mascara.format(contaminadosCurados)+"=CONTAMINADOS CURADOS");
		System.out.println(mascara.format(contaminadosEmTratamento)+"=CONTAMINADOS EM TRATAMENTO");
		System.out.println(mascara.format(contaminadosFalecidos)+"=CONTAMINADOS FALECIDOS");
		System.out.println(mascara.format(homensSemContaminacao)+"=HOMENS SEM CONTAMINACAO");
		System.out.println(mascara.format(mulheresSemContaminacao)+"=MULHERES SEM CONTAMINACAO");
		System.out.println("--------------------------------------------------------");
		System.out.println(mascara.format(total)+"=TOTAL DE REGISTRO DE PESSOAS");
		
		
	}
	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}

}
