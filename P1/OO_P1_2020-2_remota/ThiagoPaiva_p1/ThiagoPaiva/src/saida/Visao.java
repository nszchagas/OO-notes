package saida;

import java.text.DecimalFormat;

import dados.GrupoPessoa;
import dados.Homem;
import dados.Pessoa;

public class Visao {
	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	public static void mostraMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	public static void mostraMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}

	public static void mostraRelatorioRegistro(GrupoPessoa grupoPessoa) {
		int indice = 1;
		DecimalFormat mascara = new DecimalFormat("00");

		Visao.limpaTela(40);
		System.out.format("%-5s%-15s%-25s%-30s%-10s%-20s\n", "#", "Identificao", "Nome Completo", "Situação de Saude",
				"Idade", "Gestante");
		for (Pessoa pessoa : grupoPessoa.getPessoas()) {
			System.out.format("%-5s%s\n", mascara.format(indice++), pessoa);
		}

	}

	public static void mostraRelatorioNumerico(GrupoPessoa grupoPessoa) {
		int contaminadosCurado = 0;
		int contaminadosTratamento = 0;
		int contaminadosFalecido = 0;
		int homensSemContaminacao = 0;
		int mulheresSemContaminacao = 0;
		DecimalFormat mascara = new DecimalFormat("00");

		for (Pessoa pessoa : grupoPessoa.getPessoas()) {
			switch (pessoa.getSituacaoSaude()) {
			case 'T':
				contaminadosTratamento++;
				break;
			case 'F':
				contaminadosFalecido++;
				break;
			case 'C':
				contaminadosCurado++;
				break;
			case 'S':
				if (pessoa instanceof Homem)
					homensSemContaminacao++;
				else
					mulheresSemContaminacao++;
			}
		}

		Visao.limpaTela(40);
		Visao.mostraMensagem(mascara.format(contaminadosCurado) + " = CONTAMINADOS CURADOS");
		Visao.mostraMensagem(mascara.format(contaminadosTratamento) + " = CONTAMINADOS EM TRATAMENTO");
		Visao.mostraMensagem(mascara.format(contaminadosFalecido) + " = CONTAMINADOS FALECIDOS");
		Visao.mostraMensagem(mascara.format(homensSemContaminacao) + " = HOMENS SEM CONTAMINACAO");
		Visao.mostraMensagem(mascara.format(mulheresSemContaminacao) + " = MULHERES SEM CONTAMINACAO");
		Visao.mostraMensagem(mascara.format(grupoPessoa.getPessoas().size()) + " = TOTAL DE REGISTRO DE PESSOAS");
	}

}
