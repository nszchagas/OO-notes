package principal;

import dados.GrupoPessoas;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	
	// Douglas da Silva Montels Data: 20/10/2020

	public static void main(String[] args) {
		
		final int MINIMO = 1;
		int opc;
		GrupoPessoas grupo = new GrupoPessoas();
		
		do {
			Visao.msgConsole("Cadastro de Pessoa");
			
			switch (Validacao.validaCaso()) {
			case 1:
				PessoaContaminada pessoaContaminada = new PessoaContaminada(Validacao.validaNome(), 
						Validacao.validaGenero(), Validacao.validaId(MINIMO, grupo), Validacao.validaAtualSituacaoSaude());
				grupo.setPessoasContaminadas(pessoaContaminada);
				break;

			case 2:
				PessoaNaoContaminada pessoaNaoContaminada = new PessoaNaoContaminada(Validacao.validaNome(), 
						Validacao.validaGenero(), Validacao.validaId(MINIMO, grupo), Validacao.validaIdade());
				grupo.setPessoasNaoContaminadas(pessoaNaoContaminada);
				break;
			}
			
			do {
				opc = Validacao.validaContinua();
				
				if (opc == 2) {
					Visao.mostraCadastros(grupo);
				} 
			} while (opc == 2);
			
		} while (opc == 1);
		
		Visao.limpaConsole(50);
		
		
		
	}
	
}
