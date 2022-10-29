package exer3aula3;

public class Principal {

	public static void main(String[] args) {
		
		
		do {
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(Leitura.lerNome());
			
			Validacao.validaNome(pessoa);
										
			pessoa.setIdade(Leitura.lerIdade());
			
			Validacao.validaIdade(pessoa);
					
			pessoa.setAltura(Leitura.lerAltura());
			
			Validacao.validaAltura(pessoa);
	

			Servicos.mostraDados();
			
			Servicos.limpaTela();
			
		}while (Validacao.validaContinua() != true);
		
		// validar os dados e depois criar a pessoa com dados validados

	}

}
