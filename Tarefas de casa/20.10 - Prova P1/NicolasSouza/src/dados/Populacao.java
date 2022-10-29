package dados;

import java.util.ArrayList;

public class Populacao {

	private ArrayList<Pessoa> populacao;

	public Populacao() {
		populacao = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPopulacao() {
		return this.populacao;
	}

	public void addPessoa(Pessoa pessoa) {
		this.populacao.add(pessoa);
	}

	public int getQuantidadePessoasSituacao(Character situacao, Character sexo) {
		int contador = 0;
		switch (sexo) {
		case 'F':
			for (Pessoa pessoa : this.getMulheres())
				if (pessoa.getSituacaoDeSaude() == situacao)
					contador += 1;
			break;
		case 'M':
			for (Pessoa pessoa : this.getHomens())
				if (pessoa.getSituacaoDeSaude() == situacao)
					contador += 1;
			break;
		default:
			for (Pessoa pessoa : this.getPopulacao())
				if (pessoa.getSituacaoDeSaude() == situacao)
					contador += 1;
		}

		return contador;
	}

	public ArrayList<Pessoa> getHomens() {
		ArrayList<Pessoa> homens = new ArrayList<Pessoa>();
		for (Pessoa pessoa : this.getPopulacao())
			if (pessoa instanceof Homem)
				homens.add(pessoa);
		return homens;
	}

	public ArrayList<Pessoa> getMulheres() {
		ArrayList<Pessoa> mulheres = new ArrayList<Pessoa>();
		for (Pessoa pessoa : this.getPopulacao())
			if (pessoa instanceof Mulher)
				mulheres.add(pessoa);
		return mulheres;
	}

	public ArrayList<Integer> getCodigos() {
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		for (Pessoa pessoa : this.getPopulacao())
			codigos.add(pessoa.getCodigo());
		return codigos;

	}

}
