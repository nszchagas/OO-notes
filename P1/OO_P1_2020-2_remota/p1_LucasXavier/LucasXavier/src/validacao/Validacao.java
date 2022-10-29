package validacao;

import dados.Populacao;

public class Validacao {
	public static boolean validaOpcaoMenu(int opcao, int opcMin, int opcMax) {
		if (opcao < opcMin || opcao > opcMax) {
			System.out.println("Opcao invalida. Digite novamente.");
			return true;
		}
		return false;
	}

	public static boolean validaNome(String nome) {
		if (nome.isEmpty() || nome == null) {
			System.out.println("Entrada vazia. Digite novamente: ");
			return true;
		}
		if (nome.length() <= 3) {
			System.out.println("O nome deve conter mais de 3 caracteres. ");
			return true;
		}
		return false;
	}

	public static boolean validaGenero(String genero) {
		if (genero.length() != 1) {
			System.out.println("Digite apenas 'F' ou 'M'. ");
			return true;
		}
		if (genero.charAt(0) != 'F' && genero.charAt(0) != 'M') {
			System.out.println("Genero invalido. Digite 'F' para feminino e 'M' para masculino.");
			return true;
		}
		return false;
	}
	
	public static boolean isIdRepetido(int id, Populacao populacao) {
		for (int i = 0; i < populacao.nPessoas(); i++) {
			if (id == populacao.getPessoaAt(i).getIdentificador()) {
				return true;
			}
		}
		return false;
	}

	public static boolean validaIdentificador(int id, Populacao populacao) {
		final int MINIMO = 1;
		
		if (id < MINIMO) {
			System.out.println("O identificador nao pode ser menor que " + MINIMO + ". ");
			return true;
		}
		if (isIdRepetido(id, populacao)) {
			System.out.println("O identificador ja existe. Digite um numero diferente.");
			return true;
		}
		return false;
	}

	public static boolean validaIdade(int idade) {
		if (idade < 0 || idade > 130) {
			System.out.println("Idade invalida. Digite novamente. ");
			return true;
		}
		return false;
	}

	public static boolean validaSituacao(String situacao) {
		if (situacao.isEmpty() || situacao == null) {
			System.out.println("Entrada vazia. Digite novamente.");
			return true;
		}
		if (situacao.length() != 1 || (situacao.charAt(0) != 'E' && situacao.charAt(0) != 'F' && situacao.charAt(0) != 'C')) {
			System.out.println("Situacao invalida, digite apenas 'E', 'F' ou 'C'. ");
			return true;
		}
		return false;
	}
}
