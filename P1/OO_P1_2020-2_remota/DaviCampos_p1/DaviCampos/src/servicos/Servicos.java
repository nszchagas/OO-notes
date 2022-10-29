package servicos;

import dados.Doentes;
import dados.Pacientes;
import dados.Saudaveis;
import saida.Visao;
import validacao.Validacao;

public class Servicos {

	public static void mostraMenu() {
		Pacientes paciente = new Pacientes();
		char opcao;

		Visao.mensagem(
				"Ola, seja bem vindo ao programa de cadastramento de pessoas para coleta de dados sobre a covid-19!",
				0);
		do {
			Visao.mensagem("1 - Novo Cadastro.\n2 - Mostrar todas os cadastros.\n0 - Encerrar o cadastramento.", 1);
			Visao.mensagem("Por favor insira a opcao que voce deseja:", 0);
			opcao = Validacao.validaOpcao("012");
			switch (opcao) {
			case '1':
				cadastraPaciente(paciente);
				Visao.mensagem("Paciente cadastrado com Sucesso!", 2);
				break;
			case '2':
				mostraCadastros(paciente);
				break;
			case '0':
				Visao.limpaTela(50);
				Visao.mostrarRelatorioFinal(paciente);
				break;
			}
		} while (opcao != '0');
	}

	private static void cadastraPaciente(Pacientes paciente) {
		char opcao;

		do {
			Visao.mensagem("1 - Cadastrar paciente Saudavel.\n2 - Cadastrar paciente Doente.\n0 - Voltar para o menu.",
					1);
			Visao.mensagem("Por favor insira a opcao que voce deseja:", 0);
			opcao = Validacao.validaOpcao("012");
			switch (opcao) {
			case '1':
				cadastraSaudavel(paciente);
				break;
			case '2':
				cadastraDoente(paciente);
				break;
			case '0':
				Visao.limpaTela(30);
				break;
			}
		} while (opcao != '0');

	}

	private static void cadastraSaudavel(Pacientes paciente) {
		Saudaveis saudavel = new Saudaveis(Validacao.nome(), Validacao.genero(), Validacao.identificador(),
				Validacao.idade());
		paciente.setPacientes(saudavel);
	}

	private static void cadastraDoente(Pacientes paciente) {
		Doentes doente = new Doentes(Validacao.nome(), Validacao.genero(), Validacao.identificador(),
				Validacao.situacaoDeSaude());
		paciente.setPacientes(doente);
	}

	private static void mostraCadastros(Pacientes paciente) {
		Visao.mostrarDados(paciente);
	}

}
