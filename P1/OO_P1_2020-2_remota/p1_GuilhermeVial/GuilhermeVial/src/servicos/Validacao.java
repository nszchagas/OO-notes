package servicos;

import dados.ListaDePessoas;
import leitura.Leitura;
import saida.Saida;

public class Validacao {	
	
	public static boolean validaOpcao(String opcao) {
		if (("012").contains(opcao))
			return false;
		else
			System.err.println("Valor invalido");
		return true;
	}
	
	
	public static boolean validaNome(String nome) {
		if (nome == null || nome.length() <= 3) {
			System.err.println("Nome invalido! O nome deve possuir mais de 3 caracteres");
			return true;
		}
		return false;
	}
	
	public static boolean validaTipo(int tipo) {
		if (tipo != 1 && tipo != 2) {
			System.err.println("Informe somente valores validos (1 ou 2)");
			return true;
		}
		
		return false;
	}
	
	public static boolean validaGenero(String genero) {
		if (genero.length() > 1 || !genero.equals("M") && !genero.equals("F")) {
			System.err.println("Genero invalido! Informe somente M ou F");
			return true;
		}
		return false;
	}
	
	public static boolean validaId(int id, ListaDePessoas lista) {
		final int MINIMO = 1;
		
		if (id < MINIMO | lista.validaRepeticaoId(id)) {
			System.err.println("Valor deve ser maior ou igual a " + MINIMO);
			return true;
		}
		else
			return false;
	}
	
	public static boolean validaIdade(int idade) {
		if (idade < 0 || idade > 130) {
			System.err.println("Idade invalida!");
			return true;
		}
		return false;
	}
	
	public static boolean validaSituacao(String situacao) {
		if (situacao.length() > 1 || !situacao.equals("E") && !situacao.equals("F") && !situacao.equals("C")) {
			System.err.println("Opcao invalida!");
			return true;
		}
		return false;
	}
}
