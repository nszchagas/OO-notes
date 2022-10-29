package dados;

import java.util.ArrayList;

public class Populacao {

	private ArrayList<Pessoa> populacao;

	public Populacao() {
		populacao = new ArrayList<Pessoa>();
	}

	private int geraCodigo() {
		final int MAIOR = 100;
		return (this.getPopulacao().size() + 1 + MAIOR);
	}

	public ArrayList<Pessoa> getPopulacao() {
		return this.populacao;
	}

	public void addPessoa(Pessoa pessoa) {
		pessoa.setCodigo(geraCodigo());
		this.populacao.add(pessoa);
	}

	public int getQuantidadePessoasSituacao(Character situacao, Character sexo) {
		int contador = 0;
		switch (sexo) {
		case 'F':
			for (Pessoa pessoa : this.getSexo('F'))
				if (pessoa.getSituacaoDeSaude() == situacao)
					contador += 1;
			break;
		case 'M':
			for (Pessoa pessoa : this.getSexo('M'))
				if (pessoa.getSituacaoDeSaude() == situacao)
					contador += 1;

		}

		return contador;
	}

	public int getQuantidadePessoasSituacao(Character situacao) {
		int contador = 0;

		for (Pessoa pessoa : this.getPopulacao())
			if (pessoa.getSituacaoDeSaude() == situacao)
				contador += 1;

		return contador;
	}

	private ArrayList<Pessoa> getSexo(char sexo) {

		ArrayList<Pessoa> homens = new ArrayList<Pessoa>();
		ArrayList<Pessoa> mulheres = new ArrayList<Pessoa>();

		for (Pessoa pessoa : this.getPopulacao()) {
			try {
				homens.add((Homem) pessoa);
			} catch (ClassCastException e) {
				mulheres.add((Mulher) pessoa);
			}
		}

		return (sexo == 'M') ? homens : mulheres;
	}

	

}
