package principal;

public class Principal {
	public static void main(String[] args) {
		// Declaracoes
		final int MAXIMO = 50;
		Grupo grupo = new Grupo(MAXIMO);
		//Instruções
		for (int i = 1; i <= MAXIMO; i++) { //usar um while 
			System.out.println("Dados da pessoa " + i + ":");
			Pessoa pessoa = new Pessoa(Validacao.validaNome(), Validacao.validaIdade(), Validacao.validaAltura() );
			grupo.push(pessoa);
			
			if (!Validacao.validaContinua())
				break;
		}

		Servicos.mostraTabela(grupo);
	}
}
