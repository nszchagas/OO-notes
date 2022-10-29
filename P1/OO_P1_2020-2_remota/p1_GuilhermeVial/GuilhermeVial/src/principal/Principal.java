package principal;

import dados.ListaDePessoas;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import leitura.Leitura;
import saida.Saida;



public class Principal {
	public static void main(String[] args) {
		
		//Guilherme Rogelin Vial 20/10/2020
		
		ListaDePessoas lista = new ListaDePessoas();
		int opcao = -1;
		int tipo = 0;
		
		while(opcao != 0) {
			Saida.mostraEntradas();
			opcao = Leitura.lerOpcao();
			
			
			switch (opcao) {
			case 1:
				Saida.mostraTipos();
				tipo = Leitura.lerTipoCadastro();
				if (tipo == 1)
					lista.addPessoaNaoContaminada(new PessoaNaoContaminada(Leitura.lerNome(), Leitura.lerGenero(), Leitura.lerId(lista), Leitura.lerIdade()));
				else
					lista.addPessoaContaminada(new PessoaContaminada(Leitura.lerNome(), Leitura.lerGenero(), Leitura.lerId(lista), Leitura.lerSituacao()));
					
				break;
				
			case 2:
				if (lista.getLista().size() == 0) {
					System.err.println("Faca um cadastro primeiro!");
					break;
				}
				Saida.mostaTabela(lista);
				Saida.limpaTela(2);
				break;
				
			case 0:
				Saida.limpaTela(50);
				Saida.mostrarDadosTotais(lista);
				
				break;
			}
		} 

	}
}
