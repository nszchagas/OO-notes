package principal;

import java.util.Scanner;

public class IdentificadorDeSexo {

	public static void main(String[] args) { // sempre come�ar o c�digo com o main
		// declara��es
		Scanner input = new Scanner(System.in);
		char sexo; // dar nome significativo

		// instru��es
		do {
			System.out.print("Por favor , insira o sexo : "); // orientar sobre como inserir, no caso: M ou F
			sexo = input.next().toLowerCase().charAt(0); // l� at� o primeiro espa�o // char.At(0) pega o 1� caractere

		} while (validaSexo(sexo) == true); // ctrl+click leva pro m�todo

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
		// v�lido
	}

}
