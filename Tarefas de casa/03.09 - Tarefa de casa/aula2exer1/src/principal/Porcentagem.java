package principal;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Porcentagem {
	public static void main(String[] args) {
		// DECLARAÇÕES
		final float PISO = 1000.00F;
		float percentual;
		float total;
		Scanner ler = new Scanner(System.in);
		DecimalFormat mascara = new DecimalFormat("0.00");

		// INSTRUCOES
		do {
			System.out.println("Digita o percentual desejado: ");
			percentual = ler.nextFloat();
			if (percentual < 0)
				System.out.println("Não é possível calcular percentuais negativos.");
		} while (percentual < 0);

		total = PISO * (percentual / 100);
		System.out.print("\n\n\n\n\n\n\nPercentual informado pelo usuario:"
				+ mascara.format(percentual));
		System.out.print("\nPercentual aplicado sobre o piso:"
				+ mascara.format(total));
	}
}
