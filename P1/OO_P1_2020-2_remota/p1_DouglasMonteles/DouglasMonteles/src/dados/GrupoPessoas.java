package dados;

import java.util.ArrayList;

public class GrupoPessoas {

	private ArrayList<PessoaContaminada> pessoasContaminadas;
	private ArrayList<PessoaNaoContaminada> pessoasNaoContaminadas;
	
	public GrupoPessoas() {
		this.pessoasContaminadas = new ArrayList<PessoaContaminada>();
		this.pessoasNaoContaminadas = new ArrayList<PessoaNaoContaminada>();
	}

	public ArrayList<PessoaContaminada> getPessoasContaminadas() {
		return pessoasContaminadas;
	}

	public void setPessoasContaminadas(PessoaContaminada pessoaContaminada) {
		this.pessoasContaminadas.add(pessoaContaminada);
	}

	public ArrayList<PessoaNaoContaminada> getPessoasNaoContaminadas() {
		return pessoasNaoContaminadas;
	}

	public void setPessoasNaoContaminadas(PessoaNaoContaminada pessoaNaoContaminada) {
		this.pessoasNaoContaminadas.add(pessoaNaoContaminada);
	}
	
}
