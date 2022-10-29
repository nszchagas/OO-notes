package principal;

import dados.*;
import saida.Visao;
import validacao.Validacao;

public class Principal {

	public static void main(String[] args) {
		// Declaracoes
		Cadastro cadastro = new Cadastro();
		int opcao;
		
		
		do {
			opcao = Validacao.isOpcao();
			if (opcao == 1)
				if (Validacao.isContaminado())
					cadastro.setPessoa(new NaoContaminada(Validacao.isNome(), Validacao.isGenero(), Validacao.isIdentificacao(cadastro), Validacao.isIdade()));
				else
					cadastro.setPessoa(new Contaminada(Validacao.isNome(), Validacao.isGenero(), Validacao.isIdentificacao(cadastro), Validacao.isSituacao()));
			else if (opcao == 2)
				Visao.mostraCadastros(cadastro);
			
			
		} while(opcao != 0);
		
		
		
		
	}
}
