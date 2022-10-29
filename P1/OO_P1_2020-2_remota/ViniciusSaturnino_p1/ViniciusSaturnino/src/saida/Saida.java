package saida;

import java.util.ArrayList;

import dados.Grupo;
import dados.Homem;
import dados.Mulher;
import dados.Pessoa;

public class Saida {
	public static void limpaTela(int qtd) {
		for (int aux = 0; aux < qtd; aux++)
			System.out.println();
	}

	public static void menuPrincipal() {
		System.out.println("Escolha uma opcao:");
		System.out.println("------------------------------------------------------");
		System.out.println("(1) - Registrar novo usuario");
		System.out.println("(2) - Mostrar todos os registros");
		System.out.println("(0) - Encerrar Programa");
		limpaTela(2);
		System.out.print("OPCAO: ");
	}

	public static void menuSituacao() {
		System.out.println("Escolha uma situacao:");
		System.out.println("------------------------------------------------------");
		System.out.println("(T) - Contaminada em tratamento");
		System.out.println("(F) - Contaminada falecida");
		System.out.println("(C) - Contaminada curada");
		System.out.println("(S) - Sem contaminacao");
		limpaTela(2);
		System.out.print("OPCAO: ");
	}

	public static void menuGestante() {
		System.out.println("A mulher ja foi gestante? Selecione uma opcao:");
		System.out.println("------------------------------------------------------");
		System.out.println("(S) - SIM");
		System.out.println("(N) - NAO");
		System.out.println("(T) - NAO TEM CERTEZA");
		limpaTela(2);
		System.out.print("OPCAO: ");
	}

	public static void mostraDados(Grupo grupo) {
		limpaTela(50);
		String formato = "%-20s%-20s%-20s%-20s%-30s%-30s\n";
		limpaTela(2);
		System.out.format(formato, "CODIGO", "NOME", "SEXO", "SITUACAO DE SAUDE", "IDADE", "SITUACAO GESTANTE");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------");
		for (Pessoa pessoa : grupo.getGrupo())
			System.out.println(pessoa);
		limpaTela(5);
	}

	public static void mostraResultados(ArrayList<Pessoa> grupo) {
		int dados[] = new int[5];
		dados = retornaDados(grupo);
		System.out.println(dados[0] + " = CONTAMINADOS CURADOS");
		System.out.println(dados[1] + " = CONTAMINADOS EM TRATAMENTO");
		System.out.println(dados[2] + " = CONTAMINADOS FALECIDOS");
		System.out.println(dados[3] + " = HOMENS SEM CONTAMINACAO");
		System.out.println(dados[4] + " = MULHERES SEM CONTAMINACAO");
		System.out.println("----------------------------------------------");
		System.out.println(grupo.size() + " = TOTAL DE REGISTRO DE PESSOAS");
	}

	public static int[] retornaDados(ArrayList<Pessoa> grupo) {
		int[] dados = new int[5];

		for (int aux = 0; aux < dados.length; aux++)
			dados[aux] = 0;

		for (Pessoa pessoa : grupo) {
			switch (pessoa.getSituacaoSaude()) {
			case "C":
				dados[0]++;
				break;
			case "T":
				dados[1]++;
				break;
			case "F":
				dados[2]++;
				break;
			}
			if (pessoa instanceof Homem && pessoa.getSituacaoSaude().equals("S"))
				dados[3]++;
			else if (pessoa instanceof Mulher && pessoa.getSituacaoSaude().equals("S"))
				dados[4]++;
		}
		return dados;
	}
}
