package principal;
import java.text.DecimalFormat;

public class Servicos {
	
	// Salta quantidade de linhas desejadas
	public static void limpaTela(int linhas){
		for(int i = 0;i < linhas;i++)
			System.out.println();
	}
	
	// Apresenta o resultado final
	public static void mostraDados(Pessoa pessoa) {
		// Declaracoes
		DecimalFormat centesimo = new DecimalFormat("0.00");

		// Instrucoes
		limpaTela(45);
		System.out.print("Resultado:\n");
		System.out.println("Nome: " +pessoa.getNome());
		System.out.println("Altura: " + centesimo.format(pessoa.getAltura()));
		System.out.println("Idade: " + pessoa.getIdade());
	}
}
