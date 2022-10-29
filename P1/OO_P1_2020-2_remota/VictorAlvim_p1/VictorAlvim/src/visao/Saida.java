package visao;

import java.text.DecimalFormat;

import dados.Cadastros;
import dados.Pessoa;
import servicos.Servicos;
import validacao.Validacao;

public class Saida {
	public static void mensagem(String mensagem) {
		System.out.println(mensagem);
	}

	public static void mensagemErro(String mensagem) {
		System.err.println(mensagem);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	public static void mostrarSituacoesSaude() {
		Saida.mensagem("T = contaminada em Tratamento");
		Saida.mensagem("F = contaminada falecida");
		Saida.mensagem("C = contaminada Curada");
		Saida.mensagem("S = Sem contaminação");
	}

	public static void mostrarSituacoesGravidez() {
		Saida.mensagem("S = sim:");
		Saida.mensagem("N = nao");
		Saida.mensagem("T = nao tem certeza");
	}

	public static int mostraMenu() {
		mensagem("MENU DE OPCOES");
		mensagem("0 = Sair");
		mensagem("1 = Registro novo");
		mensagem("2 = Relatorio de todos registros");
		mensagem("\nQual opcao deseja?");
		return Validacao.validaInt(0, 2);
	}

	public static void relatorioTodosRegistros(Cadastros cadastros) {
		Saida.limpaTela(40);
		System.out.format("%-15s%-40s%-28s%-15s%-20s\n", "IDENTIFICADOR", "NOME COMPLETO", "SITUACAO DE SAUDE", "IDADE",
				"GESTANTE");
		for (Pessoa pessoa : cadastros.getCadastros()) {
			System.out.println(pessoa);
		}
	}

	public static void mostraSomatorioFinal(Cadastros cadastros) {
		DecimalFormat mascara = new DecimalFormat("00");
		
		limpaTela(40);
		String textosBase[] = { " = CONTAMINADOS E CURADOS", " = CONTAMINADOS EM TRATAMENTO",
				" = CONTAMINADOS FALECIDOS", " = HOMENS SEM CONTAMINACAO", " = MULHERES SEM CONTAMINACAO",
				" = TOTAL DE REGISTRO DE PESSOAS" };
		int somatorios[] = Servicos.somarSituacaoDeSaude(cadastros);
		
		for(int i = 0; i < (somatorios.length); i++) {
			mensagem(mascara.format(somatorios[i]) + textosBase[i]);
		}
		mensagem("_________________________________________");
		mensagem(mascara.format(cadastros.getCadastros().size()) + textosBase[textosBase.length - 1]);
		
		

	}
}
