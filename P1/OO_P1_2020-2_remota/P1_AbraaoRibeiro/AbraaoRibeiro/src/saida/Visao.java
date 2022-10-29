package saida;

import dados.GrupoExaminado;
import dados.Pessoa;
import servicos.Servicos;

public class Visao {
	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	public static void mostrarTabela(GrupoExaminado grupoExaminado) {
		System.out.format("%-%18s-18s%-30s%-24s%-24s\n","IDENTIFICADOR","NOME","GENERO","IDADE","SITUACAO DE SAUDE");
		for (Pessoa pessoa : grupoExaminado.getPessoas()) {
			System.out.println(pessoa);
		}
	}

	public static void mostrarDadosFinais(GrupoExaminado grupoExaminado) {
		System.out.println(Servicos.naoContaminados()+" = NAO CONTAMINADOS");
		System.out.println(Servicos.contaminados()+" = CONTAMINADOS CURADOS");
		System.out.println(Servicos.curados+" = CONTAMINADOS EM TRATAMENTO");
		System.out.println(Servicos.mulheresFalecidas()+" = MULHERES CONTAMINADAS FALECIDAS");
		System.out.println(Servicos.homemsFalecidos()+" = HOMENS CONTAMINADOS FALECIDOS");
		System.out.println("----------------------------------------");
		System.out.println(grupoExaminado.getPessoas().size()+" = TOTAL DE PESSOAS CADASTRADAS");

		
	}
}
