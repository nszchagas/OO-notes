package exer3aula3;

import java.util.Scanner;

public class Validacao {

	final static int IDADEMAXIMA = 151, IDADEMINIMA = 0;
	final static int NOMEMINIMO = 3;
	final static float ALTURAMINIMA = 0.4F, ALTURAMAXIMA = 2.6F;
	
	
	protected static void validaIdade(Pessoa pessoa ) {
		
		while (pessoa.getIdade() < IDADEMINIMA || pessoa.getIdade() > IDADEMAXIMA) {
			System.out.println("Informe uma Idade entre " + IDADEMINIMA + "e " + IDADEMAXIMA);
			pessoa.setIdade(Leitura.lerIdade());		
		}
	}

	protected static void validaNome(Pessoa pessoa) {
		 
		while (pessoa.getNome().length() < NOMEMINIMO) {
			System.out.println("Informe um nome com mais de 3 caracteres");	
			 pessoa.setNome(Leitura.lerNome());
		}
		
		
	}
	
	protected void validaAltura(Pessoa pessoa) {
		
		while(pessoa.getAltura() <= ALTURAMINIMA || pessoa.getAltura() >= ALTURAMAXIMA) {
			System.out.println("Informe uma altura entre " + ALTURAMINIMA + "e " + ALTURAMAXIMA);
			pessoa.setAltura(Leitura.lerAltura());
			
		}
		
	}
	
	//terminar o valida continua depois
	protected static boolean validaContinua() {
		Scanner ler = new Scanner(System.in);
		System.out.println("Para parar de registrar pessoa digite 'p', ou qualquer outra coisa para continuar");
		String aux = ler.nextLine();
		
		return (aux == "p");
		
	}

}
