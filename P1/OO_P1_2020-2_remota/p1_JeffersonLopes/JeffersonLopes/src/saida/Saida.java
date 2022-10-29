package saida;

public class Saida {


	public static void menuCadastroDePessoa() {
		System.out.println("1 - CADASTRAR PESSOA CONTAMINADA");
		System.out.println("2 - CADASTRAR PESSOA NAO CONTAMINADA");
	}

	public static void exibirMenu() {
		System.out.println("1 - NOVO CADASTRO");
		System.out.println("2 - MOSTRAR TODOS CADASTROS");
		System.out.println("0 - ENCERRAR");
	}

	public static void limpaTela(int linhasPuladas) {
		for (int aux = 0; aux < linhasPuladas; aux++)
			System.out.println();
	}
}
