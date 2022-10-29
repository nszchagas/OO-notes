package saida;

import dados.ListaDePessoas;
import dados.Pessoas;

public class Saida {

	public static void limpaTela(int i) {
		for (int aux = 0; aux < i; aux++)
			System.out.println();
	}
	
	
	public static void mostraEntradas() {
		System.out.println("[1] Novo cadastro");
		System.out.println("[2] Mostrar todos cadastros");
		System.out.println("[0] Encerrar");
	}
	
	public static void mostraTipos() {
		System.out.println("[1] Cadastrar pessoa nao contaminada");
		System.out.println("[2] Cadastrar pessoa contaminada");
	}
	
	public static void mostrarDadosTotais(ListaDePessoas lista) {
		System.out.println(lista.getTotalNaoContaminado() + " = NAO CONTAMINADOS");
		System.out.println(lista.getTotalContaminado('E') + " = CONTAMINADOS EM TRATAMENTO");
		System.out.println(lista.getTotalContaminado('C') + " = CONTAMINADOS CURADOS");
		System.out.println(lista.getFalecidosGenero('F') + " = MULHERES CONTAMINADAS FALECIDAS");
		System.out.println(lista.getFalecidosGenero('M') + " = HOMENS CONTAMINADOS FALECIDOS");
	}
	
	public static void mostaTabela(ListaDePessoas lista) {
		
		System.out.format("%-30s%-30s%-30s%-30s%-30s%n",  "Identificador", "Nome completo", "Gênero por extenso", "Idade", "ituação de saúde");
		
		for(Pessoas pessoa : lista.getLista()) {
			System.out.println(pessoa);
		}
	}
}
