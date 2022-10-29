package principal;

import dados.ColecaoEmpregados;
import dados.ColecaoTerrenos;
import dados.Empregado;
import dados.Terreno;
import saida.Visao;
import servicos.Servicos;
import validacao.Validacao;

public class Principal {
	public static void main (String [] args) {
		// Atributos
		ColecaoEmpregados empregados = new ColecaoEmpregados();
		ColecaoTerrenos terrenos = new ColecaoTerrenos();
		final int MIN = 0;
		int escolha;
		
		// Metodos
		do {
			String [] opcao = {"Registra Empregado", "Registrar Terreno", "Analisar Empregados", "Analisar Terrenos", "Sair"};
			escolha = Visao.mostraMenu("Escolha uma das opcoes a seguir.", opcao);
			switch (escolha) {
			case 0:
				empregados.setColecaoEmpregados(new Empregado(
					Validacao.validaMatricula("Digite a Matricula do Empregado", "Registra Empregado", MIN, empregados), 
					Validacao.validaString("Digite o Nome do Empregado", "Registra Empregado"), 
					Validacao.validaFloat("Digite o Salario do Empregado", "Registra Empregado", MIN)
				));
				break;
			case 1:
				terrenos.setColecaoTerrenos(new Terreno(
					Validacao.validaString("Digite o Endereco do Terreno", "Registra Terreno"), 
					Validacao.validaInteiro("Digite o tamanho da Area Ocupada (m2)", "Registra Terreno", MIN),
					Validacao.validaFloat("Digite o Valor Atual do Terreno", "Registra Terreno", MIN)
				));
				break;
			case 2:
				if (!empregados.getColecaoEmpregados().isEmpty()) {
					Servicos.analisaEmpregados(empregados, MIN);
				}
				else {
					Visao.mostraMensagemErro("Error, registre um empregado para acessar esta opcao.");
				}
				break;
			case 3:
				if (!terrenos.getColecaoTerrenos().isEmpty()) {
					Servicos.analisaTerrenos(terrenos, MIN);
				}
				else {
					Visao.mostraMensagemErro("Error, registre um empregado para acessar esta opcao.");
				}
			}
		} while (escolha != 4 && escolha != -1);
		if (empregados.getColecaoEmpregados().isEmpty() && terrenos.getColecaoTerrenos().isEmpty()) {
			Visao.mostraMensagemAlerta("Como nenhum Empregado nem Terreno foi registrado, nada sera mostrado.");
		}
		else {
			Visao.mostraResultadosFinais(empregados, terrenos);
		}
	}
}
