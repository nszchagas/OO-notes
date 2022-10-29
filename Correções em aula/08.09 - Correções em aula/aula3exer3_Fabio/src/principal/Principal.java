package principal;

public class Principal {
	public static void main(String[] args) {
		// Declaracoes
		
		//Instruções
		do {			
				Pessoa pessoa = new Pessoa(Validacao.validaNome(), Validacao.validaIdade(), Validacao.validaAltura() );
				Servicos.mostraDados(pessoa);
				
		} while (Validacao.validaContinua());
		Servicos.limpaTela(30); 
	}
}
