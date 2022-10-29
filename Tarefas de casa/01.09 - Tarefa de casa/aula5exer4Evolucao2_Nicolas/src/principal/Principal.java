package principal;

import dados.GrupoDePessoas;
import dados.Pessoa;
import saida.Visao;
import validacao.Validacao;

public class Principal {
	public static void main(String[] args) {

		GrupoDePessoas grupo = new GrupoDePessoas();

		while (Validacao.validaNovoGrupo()) {
			do
				grupo.setPessoa(new Pessoa(Validacao.validaNome()));
			while (Validacao.validaCadastroNome());

			Visao.mostraRelatorio(grupo);
		}
		Visao.mensagemProgramaEncerrado(grupo.getPessoas().size());
	}
}
