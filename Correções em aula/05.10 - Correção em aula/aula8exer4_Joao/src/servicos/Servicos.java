package servicos;

import dados.ColecaoEmpregados;
import dados.ColecaoTerrenos;
import saida.Visao;
import validacao.Validacao;

public class Servicos { //nao usou a interface
	//matar a classe
	public static void analisaEmpregados (ColecaoEmpregados empregados, final int MIN) {
		String [] opcao = {"Acha Menor e Maior Salario", "Matriculas Duplicadas", "Somatorio dos Salarios", "Media dos Salarios", "Cancelar"};
		switch (Visao.mostraMenu("Escolha uma das opcoes.", opcao)) {
		case 0:
			Visao.mostraMensagem("Menor Valor: " + empregados.achaMenorValor() + "\nMaior Valor: " + empregados.achaMaiorValor());
			break;
		case 1:
			int matriculaProcurada = Validacao.validaInteiro("Digite a Matricula a ser procurada", "Acha Duplicatas", MIN);
			if (empregados.isInteiroRepetido(matriculaProcurada)) {
				Visao.mostraMensagem("A Matricula " + matriculaProcurada + " e repetida.");
			}
			else {
				Visao.mostraMensagem("Matricula nao registrada no sistema.");
			}
			break;
		case 2:
			Visao.mostraMensagem("Somatorio dos Salarios: " + empregados.calculaSomatorio());
			break;
		case 3:
			Visao.mostraMensagem("Media dos Salarios: " + empregados.calculaMedia());
		}
	}
	
	public static void analisaTerrenos (ColecaoTerrenos terrenos, final int MIN) {
		String [] opcao = {"Acha Menor e Maior Valor", "Areas Ocupadas Duplicadas", "Somatorio dos Valores de Terreno", "Media dos Valores de Terreno", "Cancelar"};
		switch (Visao.mostraMenu("Escolha uma das opcoes.", opcao)) {
		case 0:
			Visao.mostraMensagem("Menor Valor: " + terrenos.achaMenorValor() + "\nMaior Valor: " + terrenos.achaMaiorValor());
			break;
		case 1:
			int areaOcupada = Validacao.validaInteiro("Digite a Area Ocupada a ser procurada", "Acha Duplicatas", MIN);
			if (terrenos.isInteiroRepetido(areaOcupada)) {
				Visao.mostraTerrenosIguais(terrenos, areaOcupada);
				Visao.mostraMensagem("A area ocupada " + areaOcupada + " e repetida.");
			}
			else {
				Visao.mostraMensagem("Area Ocupada nao registrada no sistema.");
			}
			break;
		case 2:
			Visao.mostraMensagem("Somatorio dos Valores de Terreno: " + terrenos.calculaSomatorio());
			break;
		case 3:
			Visao.mostraMensagem("Media dos Valores de Terreno: " + terrenos.calculaMedia());
		}
	}
}
