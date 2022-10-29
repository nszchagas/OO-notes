package exer3aula3;

public class Principal {

	public static void main(String[] args) {
		
		
		do {
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(Leitura.lerNome());
			
			Validacao.validaNome(pessoa.getNome());
										
			pessoa.setIdade(Leitura.lerIdade());
			
			Validacao.validaIdade(pessoa.getIdade());
					
			pessoa.setAltura(Leitura.lerAltura());
			
			Validacao.validaAltura(pessoa.getAltura());
	

			Servicos.mostraDados();
			
			Servicos.limpaTela();
			
		}while (Validacao.validaContinua() != true);

	}

}
