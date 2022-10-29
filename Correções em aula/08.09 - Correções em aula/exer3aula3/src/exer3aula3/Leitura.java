package exer3aula3;

import java.util.Scanner;

public class Leitura extends Pessoa {
	
static Scanner ler = new Scanner(System.in);
	
	
	protected static int lerIdade() {	
		System.out.println("Informe a idade");

		return ler.nextInt();
		
		
	}
	
	protected static String lerNome() {	
		System.out.println("Informe o nome");
		
		
		
		return ler.nextLine();

			
		
	}
	
	protected static float lerAltura() {	
		System.out.println("Informe a altura");	
		return ler.nextFloat();
		
	}

		
	
	
	
	
	

}
