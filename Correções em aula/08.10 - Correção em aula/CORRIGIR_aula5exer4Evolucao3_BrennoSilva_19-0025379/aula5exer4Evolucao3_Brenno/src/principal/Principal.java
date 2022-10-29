package principal;

import dados.Grupo;
import dados.Pessoa;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {
		
		while (Validacao.validaNovoGrupo()) {
			Grupo grupo = new Grupo();
			do {				
				grupo.setGrupoNomes(new Pessoa(Validacao.validaNome()));
				Visao.limpaTela(2);
			}while (Validacao.validaCadastroNome());
			
			if(grupo.getNomes().size() > 0) 
				Visao.mostraRelatorio(grupo);
			
			Visao.limpaTela(50);
		} 
	}
}