package validacao;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dados.Empresa;
import dados.FuncionarioRegular;
import dados.GerenteDeEquipe;
import dados.Pessoa;
import dados.PrestadorDeServicos;
import leitura.Leitura;
import saida.Saida;

public class Validacao {

	public static String validaNome() {
		Saida.limpaTela(40);
		Saida.exibirMensagemCadastroDeFuncionario();
		Saida.solicitarNome();
		String nome = Leitura.lerLinha();
		while (nome.split(" ")[0].equals(nome) || nome.isBlank() || nome.isEmpty()) {
			Saida.informarNomeInvalido();
			nome = Leitura.lerLinha();
		}
		return nome;
	}

	public static String validaCpf(Empresa empresa) {
		String cpf;
		Saida.solicitarCpf();
		do {
			cpf = Leitura.lerString();
			if (cpf.length() != 11 || !verificaDigitos(cpf)) {
				Saida.informarCpfInvalido();
			}
			if (!verificaCpfRepetido(empresa.getPessoas(), cpf)) {
				Saida.informarCpfInvalido();
			}
		} while (!verificaCpfRepetido(empresa.getPessoas(), cpf) || cpf.length() != 11 || !verificaDigitos(cpf));
		return cpf;
	}

	public static boolean verificaCpfRepetido(ArrayList<Pessoa> empresa, String cpf) {
		int contador = 0;
		while (contador < empresa.size()) {
			if (empresa.get(contador++).getCpf().equals(cpf)) {
				System.err.println("CPF ja inserido!!");
				return false;
			}
		}
		return true;
	}

	public static boolean verificaDigitos(String palavra) {
		for (char c : palavra.toCharArray()) {
			if (!('0' <= c && c <= '9')) {
				return false;
			}
		}
		return true;
	}

	public static String validaDataDeNascimento() {
		int dia, mes, ano;
		dia = validaDia();
		mes = validaMes();
		ano = validaAno();
		return Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano);
	}

	public static int validaDia() {
		int dia;
		Saida.solicitarDiaDeNascimento();
		try {
			dia = Leitura.lerInt();
			if (!(dia > 0 && dia <= 30)) {
				Saida.informarDiaDeNascimentoInvalido();
				dia = validaDia();
			}
		} catch (InputMismatchException e) {
			Saida.informarExcecaoInt();
			dia = validaDia();
		}
		return dia;
	}

	public static int validaMes() {
		int mes;
		Saida.solicitarMesDeNascimento();
		try {
			mes = Leitura.lerInt();
			if (!(mes > 0 && mes <= 12)) {
				Saida.informarMesDeNascimentoInvalido();
				mes = validaMes();
			}
		} catch (InputMismatchException e) {
			Saida.informarExcecaoInt();
			mes = validaMes();
		}
		return mes;
	}

	public static int validaAno() {
		int ano;
		Saida.solicitarAnoDeNascimento();
		try {
			ano = Leitura.lerInt();
			if (!(ano > 1900 && ano <= 2020)) {
				Saida.informarAnoDeNascimentoInvalido();
				ano = validaAno();
			}
		} catch (InputMismatchException e) {
			Saida.informarExcecaoInt();
			ano = validaAno();
		}
		return ano;
	}

	public static int validaHorasTrabalhadas() {
		int horas;
		Saida.solicitarHorasTrabalhadas();
		try {
			horas = Leitura.lerInt();
			if (!(horas > 0 && horas <= 220)) {
				Saida.informarHorasTrabalhadasInvalida();
				horas = validaHorasTrabalhadas();
			}
		} catch (InputMismatchException e) {
			Saida.informarExcecaoInt();
			horas = validaHorasTrabalhadas();
		}
		return horas;
	}

	public static int validaProjetos() {
		int projetos;
		Saida.solicitarQuantidadeDeProjetos();
		try {
			projetos = Leitura.lerInt();

			if (!(projetos > 0 && projetos <= 220)) {
				Saida.informarQuantidadeDeProjetosInvalido();
				projetos = validaProjetos();
			}
		} catch (InputMismatchException e) {
			Saida.informarExcecaoInt();
			projetos = validaProjetos();
		}
		return projetos;
	}

	public static int validaMenuDeFuncionarios() {
		int opcao;
		Saida.exibirMenuDeFuncionarios();
		try {
			opcao = Leitura.lerInt();
			if (opcao < 0 || opcao > 3) {
				System.err.println("Valor Invalido! Insira um numero de 0 a 3");
				opcao = validaMenuDeFuncionarios();
			}
		} catch (InputMismatchException e) {
			System.err.println("Valor Invalido! Insira apenas um numero");
			opcao = validaMenuDeFuncionarios();
		}
		return opcao;
	}

	public static int validaMenu() {
		int opcao;
		do {
			Saida.exibirMenu();
			try {
				opcao = Leitura.lerInt();
				if (opcao < 0 || opcao > 2) {
					System.err.println("Valor Invalido! Insira um numero de 0 a 2");
					opcao = validaMenu();
				}
			} catch (InputMismatchException e) {
				System.err.println("Valor Invalido! Insira apenas um numero");
				opcao = validaMenu();
			}
		} while (opcao < 0 || opcao > 2);
		return opcao;
	}

	public static float validaSalarioGerentes(ArrayList<GerenteDeEquipe> gerentes) {
		float soma = 0f;
		for (int i = 0; i < gerentes.size(); i++) {
			soma += gerentes.get(i).calculaSalario();
		}
		return soma;
	}

	public static float validaSalarioFuncionarios(ArrayList<FuncionarioRegular> funcionarios) {
		float soma = 0f;
		for (int i = 0; i < funcionarios.size(); i++) {
			soma += funcionarios.get(i).calculaSalario();
		}
		return soma;
	}

	public static float validaSalarioServidores(ArrayList<PrestadorDeServicos> servidor) {
		float soma = 0f;
		for (int i = 0; i < servidor.size(); i++) {
			soma += servidor.get(i).calculaSalario();
		}
		return soma;
	}

}
