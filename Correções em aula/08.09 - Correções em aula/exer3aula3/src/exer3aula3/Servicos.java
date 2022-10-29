package exer3aula3;

public class Servicos {
	
	
	public  void mostraDados(Pessoa pessoa) {
		System.out.println("Nome: " + pessoa.getNome() + " Idade: " + pessoa.getIdade()
		+ " Altura: " + pessoa.getAltura());
	}

	
	
	public static void limpaTela() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
		
	}
	
	
	
}
