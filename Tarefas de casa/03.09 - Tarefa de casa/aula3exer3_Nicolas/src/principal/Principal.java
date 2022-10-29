package principal;

public class Principal {
	public static void main(String[] args) {
		final char LETRAFINAL = 'c';
		char continua = 'a';
		Pessoa pessoa1 = new Pessoa(); // cria um objeto da classe Pessoa, esse objeto recebera os atributos digitados
										// (variaveis de instancia)

		do {
			do {
				System.out.println("Digite o nome da pessoa:");
				pessoa1.nome = Leitura.getString();
			} while (!Validacao.validaNome(pessoa1.nome));
			Servicos.limpaTela(50);
			do {
				System.out.println("Digite a idade dessa pessoa:");
				pessoa1.idade = Leitura.getInt();
			} while (!Validacao.validaIdade(pessoa1.idade));
			Servicos.limpaTela(50);
			do {
				System.out.println("Digite a altura dessa pessoa:");
				pessoa1.altura = Leitura.getFloat();
			} while (!Validacao.validaAltura(pessoa1.altura));
			Servicos.limpaTela(50);

			Servicos.mostraDados(pessoa1.nome, pessoa1.altura, pessoa1.idade);

			System.out.println("Para sair do programa digite: " + LETRAFINAL
					+ ".\nPara inserir outro valor digite qualquer letra.");
			continua = Leitura.getChar();

			Servicos.limpaTela(50);
		} while (!Validacao.validaContinua(continua, LETRAFINAL));
		
		System.out.println("\t\tPrograma encerrado.");

	}

}
