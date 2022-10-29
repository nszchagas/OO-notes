package visao;

import java.text.DecimalFormat;

import dados.Grupo;
import dados.Pessoa;
import servicos.Servicos;

public class Visao {
	public static void mostraMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	
	public static void limpaTela(int saltos) {
		for (int contador = 0; contador < saltos; saltos++)
			System.out.println();
	}
	
	public static void mostraMenu(int codigo) {
		if (codigo == 0) {
			System.out.println("[1] - CADASTRAR UM HOMEM");
			System.out.println("[2] - CADASTRAR UMA MULHER");
		}
		if (codigo == 1) {
			System.out.println("MENU "+(codigo + 1)+"\n[1] - REGISTRO NOVO");
			System.out.println("[2] - RELATORIO DE TODOS OS REGISTROS");
			System.out.println("[0] - SAIR");
		}		
	}
	
	// RELATORIO
		public static void mostraRelatorio(Grupo grupo) {
			String formato = "%-20s%-30s%-20s%-13s%-10s\n";
			
			System.out.format(formato, "IDENTIFICADOR", "NOME COMPLETO", "SITUACAO  DE SAUDE", "IDADE", "GESTACAO");
			
			for (Pessoa pessoa : grupo.getGrupo())
				System.out.println(pessoa);
			
		}
	
	// RESULTADO
		public static void mostraResultado(Grupo grupo) {
			 int casos[] = Servicos.identificaSituacao(grupo);
			 DecimalFormat mascara = new DecimalFormat("00");
			 
			 limpaTela(50);
			 System.out.println(mascara.format(casos[0])+ " = CONTAMINADOS CURADOS");
			 System.out.println(mascara.format(casos[1])+ " = CONTAMINADOS EM TRATAMENTO");
			 System.out.println(mascara.format(casos[2])+ " = CONTAMINADOS FALECIDOS");
			 System.out.println(mascara.format(casos[3])+ " = HOMENS SEM CONTAMINAÇÃO");
			 System.out.println(mascara.format(casos[4])+ " = MULHERES SEM CONTAMINAÇÃO");
			 System.out.println(mascara.format(grupo.getGrupo().size()) +" = TOTAL DE REGISTRO DE PESSOAS");
		}
}
