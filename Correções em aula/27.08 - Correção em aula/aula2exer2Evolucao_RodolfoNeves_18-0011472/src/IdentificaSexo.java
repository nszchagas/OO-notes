
import java.util.Scanner;

public class IdentificaSexo {

	public static boolean validaSexo(String string) {
		return (string.compareToIgnoreCase("M") == 0 || string.compareToIgnoreCase("F") == 0) ? false : true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String string;
		do {
			System.out.print("Por favor , insira o sexo : ");
			string = input.next();

		} while (validaSexo(string) == true);

		input.close();
		char sexo = string.charAt(0);
		System.out.println((sexo == 'M' || sexo == 'm' ? "Sexo Masculino" : "Sexo Femenino"));
	}
}
