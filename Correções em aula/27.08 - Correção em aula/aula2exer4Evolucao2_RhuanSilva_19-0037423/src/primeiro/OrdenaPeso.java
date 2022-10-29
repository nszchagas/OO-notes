package primeiro;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OrdenaPeso {
	
	

	public static void main(String[] args) {
		// DECLARACOES
		final int MAX = 3;
		float guardaPeso;
		DecimalFormat mascara = new DecimalFormat("#0.00");
		float[] peso = new float[MAX];
		Scanner ler = new Scanner(System.in);

		// INSTRUCOES
		for (int contador = 0; contador < MAX; contador++) {
			System.out.println("Digite o peso do " + (contador + 1) + " elefante:");
			peso[contador] = ler.nextFloat();
			
		}
		for (int contador = 0; contador < MAX; contador++) {
			for (int aux = contador + 1; aux < MAX; aux++) {
				if (peso[contador] > peso[aux]) {
					guardaPeso = peso[contador];
					peso[contador] = peso[aux];
					peso[aux] = guardaPeso;
				}
			}
			
			}
		}
	
	
	public static boolean validaPeso(float recebePeso) {
		final int PESOMINIMO = 5;
		if (recebePeso >= PESOMINIMO)
			return true;
		else
			return false;

	}

	public static void limpaTela() {

		for (int aux = 0; aux < 30; aux++)
			System.out.print("\n");
	}
}