package principal;

import java.util.Scanner;

public class Senha {

	public static void main(String[] args) throws InterruptedException {
		// Declarações

		String cadastroSenha = "";
		
		// Instruções
		System.out.print("Cadastre uma senha sem espaço de mínimo 3 e máximo 5 dígitos: ");
		cadastroSenha = validaSenha(cadastroSenha);

		limpaTela(30);
		interageUsuario(cadastroSenha);
	}

	// ================================================
	// ============= MÉTODOS AUXILIARES ===============
	// ================================================
	public static void limpaTela(int salto) {
		for (int linha = 0; linha < salto; linha++)
			System.out.println();
	}
	
	public static String lerString () {
		Scanner ler = new Scanner(System.in);
		return(ler.next().trim());
	}

	public static String validaSenha(String senha) {
		final int MINIMO = 3, MAXIMO = 5;

		do {
			senha = lerString();
			if (senha.length() < MINIMO || senha.length() > MAXIMO)
				System.out
						.print("Senha inválida!\n"
								+ "Digite nova senha sem espaço e no mínimo 3 dígitos e máximo 5: ");
		} while (senha.length() < MINIMO || senha.length() > MAXIMO);
		return senha;
	}

	public static void interageUsuario(String cadastroSenha)
			throws InterruptedException {
		int contador = 0;
		String senha = "";
		final int LIMITE = 9;

		while (contador < LIMITE) {
			System.out.print("Tente acertar a Senha: ");
			senha = validaSenha(senha);
			contador++;
			limpaTela(20);
			if (cadastroSenha.equals(senha)) {
				contador = LIMITE + 1;
				System.out.println("              Parabéns, você acertou a senha de acesso!                         ");
			} else if (contador == LIMITE) {
				System.out.println("               O computador irá se autodesturir em 10 segundos.                 ");
				Thread.sleep(10 * 1000); // Calculo para 10 segundos
			} else
				System.out.println("Senha incorreta!\nTente novamente.");
		}
	}
}
