package saida;

public class Saida {
	
	public static void limpaTela(int qtd) {
		for(int i = 0; i < qtd; i++) {
			System.out.println();
		}
	}
	
	public static void apresentaNomes(String[] nomes) {
		limpaTela(20);
		for(int i = 0; i < nomes.length; i++) {
			System.out.println((i+1) + "º nome: " + nomes[i]);			
		}
	}

}
