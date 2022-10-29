package saida;

import java.text.DecimalFormat;

import dados.GrupoPessoas;
import dados.Pessoa;
import leitura.Leitura;

public class Visao {
	
	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++)
			System.out.println();
	}
	
	public static void menuEscolherSexo(int option) {
		System.out.println("Selecione o Sexo:\n1 - Masculino\n2 - Feminino");
		option = Leitura.leiaInt();
		
	}
	
	public static void menuPrincipal() {
		System.out.println("0 - Sair\n1 - Registro Novo\n2 - Relatorio de todos os registros\nOpcao");
	}
	
	public static void mostraRelatorio(GrupoPessoas grupoPessoas) {
		DecimalFormat mascara = new DecimalFormat("00");
		int aux = 0;
		
		if (grupoPessoas.getGrupoPessoas().size() == 0)
			System.out.println("Nenhuma pessoa foi cadastrada!");
		else {
			
			limpaTela(50);
			String formato = "%-30s%-40s%-20%-40s%-40s%\n";
			System.out.format(formato, "# |", "NOME |", "SITUACAO DE SAUDE |", "IDADE |", "GESTANTE |");
			System.out.println(
					"=========================================================================================================================================================================");
			for (Pessoa pessoa : grupoPessoas.getGrupoPessoas())
				System.out.format(mascara.format(++aux) + pessoa);
		}
	}
	
	public static void totalCadastrados(GrupoPessoas grupoPessoas) {
		System.out.println("Total de Cadastrados: " + grupoPessoas.getGrupoPessoas().size());
	}
}
