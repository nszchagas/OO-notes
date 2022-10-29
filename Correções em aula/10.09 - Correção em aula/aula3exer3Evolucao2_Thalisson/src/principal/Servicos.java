package principal;
import java.text.*;

public class Servicos {
	
	// Salta quantidade de linhas desejadas
	public static void limpaTela(int linhas){
		for(int i = 0;i < linhas;i++)
			System.out.println();
	}
	
	// Apresenta o resultado final
	public static void mostraPessoa(Pessoa pessoa) {
		// Declaracoes
		DecimalFormat centesimo = new DecimalFormat("0.00");

		// Instrucoes
		System.out.print("  \t" + pessoa.getIdade() + "  \t |");
		System.out.print("  \t   " + centesimo.format(pessoa.getAltura()) + "  \t |");
		System.out.println("   " + pessoa.getNome());
	}
	
	public static void mostraTabela(Grupo grupo) {
		limpaTela(45);
		mostraCabecalho();
		for (int i = 0; i < grupo.length(); i++) {
			mostraPessoa(grupo.at(i));
		}
	}
	
	public static void mostraCabecalho() {
		System.out.println("     IDADE \t | \t ALTURA \t | \t NOME");
		for (int i = 0; i < 64; i++)
			System.out.print("-");
		System.out.println();
	}
}
