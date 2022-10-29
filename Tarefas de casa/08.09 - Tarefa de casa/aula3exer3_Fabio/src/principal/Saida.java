package principal;

import java.text.DecimalFormat;

public class Saida {

	public static boolean mostraMensagemContinuar() {

		System.out.println("Deseja continuar cadastrando nomes? (S para Sim e N para Nao)");
		return Validacao.validaContinua(Leitura.leituraChar());

	}

	public static void mostraDadosGrupo(Grupo grupo) {
		int pessoasCadastradas=grupo.getTamanhoGrupo();
		
		System.out.println("As pessoas cadastradas estao relacionadas na tabela abaixo.");

		for (int aux = 0 ; aux < 50 ; aux ++) 
			System.out.print("-");

		System.out.println("\n N° | Idade | Altura | Nome  ");
		for (int cont = 0; cont < grupo.getTamanhoGrupo(); cont++) {
			if (grupo.getPessoaNaPosicao(cont) != null)
				mostraDadosPessoa(grupo.getPessoaNaPosicao(cont), cont);
			else
			{
				pessoasCadastradas = cont;
				break;
			}
				
		}
		

		
		for (int aux = 0 ; aux < 50 ; aux ++) 
			System.out.print("-");
		
		System.out.println("\nQuantidade de pessoas cadastradas: " + pessoasCadastradas);


	}

	public static void mostraDadosPessoa(Pessoa pessoa, int cont) {
		DecimalFormat mascaraFloat = new DecimalFormat("0.00");
		DecimalFormat mascaraInt = new DecimalFormat("00");

		System.out.println(" " + mascaraInt.format(cont + 1) + " |   " + mascaraInt.format(pessoa.getIdade()) + "  |  "
				+ mascaraFloat.format(pessoa.getAltura()) + "  | " + pessoa.getNome());
	}

}
