package principal;

import java.util.Scanner;

public class IdentificadorDeSexo {

	public static void main(String[] args) { // sempre começar o código com o main
		// declarações
		Scanner input = new Scanner(System.in);
		char sexo; // dar nome significativo

		// instruções
		do {
			System.out.print("Por favor , insira o sexo : "); // orientar sobre como inserir, no caso: M ou F
			sexo = input.next().toLowerCase().charAt(0); // lê até o primeiro espaço // char.At(0) pega o 1º caractere

		} while (validaSexo(sexo) == true); // ctrl+click leva pro método

		input.close();

		System.out.println((sexo == 'M' || sexo == 'm' ? "Sexo Masculino" : "Sexo Feminino"));
	}

	public static boolean validaSexo(char sexo) {

		return (((sexo == ('M')) || (sexo == ('m')) || (sexo == ('F')) || (sexo == ('f'))) ? true : false); // retorna
		// verdadeiro
		// se
		// for
		// um
		// sexo
		// válido
	}

}
