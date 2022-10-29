package principal;

import dados.Mamifero;

public class Visao {
	 public static void limpaTela(int linhas) {
		 for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	 }
	 
	 public static void mostraTabela(GrupoTodasPessoas grupoTodasPessoas) {
		 if (grupoTodasPessoas.getGrupoTodasPessoas().size() == 0)
				System.out.println("Nenhum mamifero foi cadastrado!");
			else {
				
				limpaTela(50);
				String formato = "%-5s%-15s%-20s%-13s\n";
				System.out.format(formato, "IDENTIFICADOR", "GENERO |", "IDADE |", "SITUACAO SAUDE |");
				System.out.println(
						"=================================================================================================================");
				for (Pessoa pessoa : grupoTodasPessoas.getGrupoTodasPessoas())
					System.out.println(pessoa.toString());
			}
	 }

}
