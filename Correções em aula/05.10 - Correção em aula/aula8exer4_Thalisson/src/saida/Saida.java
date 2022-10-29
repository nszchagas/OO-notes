package saida;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import dados.Empregado;
import dados.Empresa;
import dados.GrupoTerrenos;
import dados.Terreno;
import interfaces.AnalisaDados;
import validacao.Valida;

public final class Saida {
	private static void limpaTela(int quantidade) {
		while (quantidade-- > 0)
			System.out.println();
	}

	public static void apresentaDados(Empresa empresa, GrupoTerrenos terrenos) {
		limpaTela(50);
		if (empresa.getEmpregados().isEmpty()) {
			System.out.println("( Nenhum empregado cadastrado. )");
		} else {
			mostraCabecalho(false);
			for (Empregado empregado : empresa.getEmpregados())
				System.out.println(empregado);
		}

		limpaTela(3);
		if (terrenos.getTerrenos().isEmpty()) {
			System.out.println("( Nenhum terreno cadastrado. )");
		} else {
			mostraCabecalho(true);
			for (Terreno terreno : terrenos.getTerrenos())
				System.out.println(terreno);
		}
	}

	public static <T extends AnalisaDados> void mostraMenorMaiorReal(T dados, int tipo) {
		String mensagem = "";
		DecimalFormat formato = new DecimalFormat("0.00");
		if (tipo == 0) {
			switch (Valida.validaEscolhaMenu("Salario", "Matricula")) {
			case 0:
				mensagem = "Menor salario: R$ " + formato.format(dados.calculaMenorReal('s')) + "\nMaior salario: R$ "
						+ formato.format(dados.calculaMaiorReal('s'));
				break;
			case 1:
				mensagem = "Menor matricula: " + (int) dados.calculaMenorReal('m') + "\nMaior matricula: "
						+ (int) dados.calculaMaiorReal('m');
			}
		} else {
			switch (Valida.validaEscolhaMenu("Preco", "Area")) {
			case 0:
				mensagem = "Menor preco: R$ " + formato.format(dados.calculaMenorReal('p')) + "\nMaior preco: R$ "
						+ formato.format(dados.calculaMaiorReal('p'));
				break;
			case 1:
				mensagem = "Menor area: " + (int) dados.calculaMenorReal('a') + " m²\nMaior area: "
						+ (int) dados.calculaMaiorReal('a') + " m²";
			}
		}
		Saida.mostraMensagem(mensagem, "Analise", 1);
	}

	public static void mostraDuplicatas(Empresa empresa) {
		int pesquisa = Valida.validaNumeroPositivo();
		if (mostraExistenciaDuplicatas(empresa, pesquisa)) {
			mostraCabecalho(false);
			for (Empregado empregado : empresa.getEmpregadosPorMatricula(pesquisa)) {
				System.out.println(empregado);
			}
		}
	}

	public static void mostraDuplicatas(GrupoTerrenos terrenos) {
		int pesquisa = Valida.validaNumeroPositivo();
		if (mostraExistenciaDuplicatas(terrenos, pesquisa)) {
			mostraCabecalho(true);
			for (Terreno terreno : terrenos.getTerrenosPorArea(pesquisa)) {
				System.out.println(terreno);
			}
		}
	}

	private static <T extends AnalisaDados> boolean mostraExistenciaDuplicatas(T dados, int pesquisa) {
		if (dados.isValorDuplicado(pesquisa)) {
			mostraMensagem("Valor pesquisado: " + pesquisa + "\nValor ja existente " + "entre os dados cadastrados",
					"Analise", 1);
			return true;
		} else {
			mostraMensagem("Valor pesquisado: " + pesquisa + "\nValor nao existe " + "entre os dados cadastrados",
					"Analise", 1);
			return false;
		}
	}

	public static <T extends AnalisaDados> void mostraSomatorio(T dados, int tipo) {
		String mensagem = "";
		DecimalFormat formato = new DecimalFormat("0.00");
		if (tipo == 0) {
			switch (Valida.validaEscolhaMenu("Salario", "Matricula")) {
			case 0:
				mensagem = "Somatorio dos salarios: R$ " + formato.format(dados.calculaSomatorio('s'));
				break;
			case 1:
				mensagem = "Somatorio das matriculas: " + (int) dados.calculaSomatorio('m');
			}
		} else {
			switch (Valida.validaEscolhaMenu("Preco", "Area")) {
			case 0:
				mensagem = "Somatorio dos precos: R$ " + formato.format(dados.calculaSomatorio('p'));
				break;
			case 1:
				mensagem = "Somatorio das areas: " + (int) dados.calculaSomatorio('a') + " m²";
			}
		}
		Saida.mostraMensagem(mensagem, "Analise", 1);
	}

	public static <T extends AnalisaDados> void mostraMedia(T dados, int tipo) {
		String mensagem = "";
		DecimalFormat formato = new DecimalFormat("0.00");
		if (tipo == 0) {
			switch (Valida.validaEscolhaMenu("Salario", "Matricula")) {
			case 0:
				mensagem = "Media dos salarios: R$ " + formato.format(dados.calculaMedia('s'));
				break;
			case 1:
				mensagem = "Media das matriculas: " + formato.format(dados.calculaMedia('m'));
			}
		} else {
			switch (Valida.validaEscolhaMenu("Preco", "Area")) {
			case 0:
				mensagem = "Media dos precos: R$ " + formato.format(dados.calculaMedia('p'));
				break;
			case 1:
				mensagem = "Media das areas: " + formato.format(dados.calculaMedia('a')) + " m²";
			}
		}
		Saida.mostraMensagem(mensagem, "Analise", 1);
	}

	private static void mostraCabecalho(boolean isTerreno) {
		String formato = "%-20.20s %-20.20s %-20.20s";
		if (isTerreno) {
			mostraLinha(60, '=');
			System.out.println("                           Terrenos");
			mostraLinha(60, '=');
			System.out.println(String.format(formato, "Endereco", "Area", "Preco"));
		} else {
			mostraLinha(60, '=');
			System.out.println("                        Funcionarios");
			mostraLinha(60, '=');
			System.out.println(String.format(formato, "Nome", "Matricula", "Salario"));
		}
		mostraLinha(60, '-');
	}

	private static void mostraLinha(int qtd, char caracter) {
		while (qtd-- > 0)
			System.out.print(caracter);
		System.out.println();
	}

	public static void mostraMensagem(Object mensagem, String titulo, int tipoMensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, tipoMensagem);
	}
}
