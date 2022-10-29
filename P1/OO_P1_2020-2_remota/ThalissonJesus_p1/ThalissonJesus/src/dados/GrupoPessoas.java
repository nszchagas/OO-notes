package dados;

import java.util.Vector;

public class GrupoPessoas {
	private Vector<Pessoa> pessoas;

	public GrupoPessoas() {
		pessoas = new Vector<Pessoa>();
	}

	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	public Vector<Pessoa> getPessoas() {
		return pessoas;
	}

	public int somaSituacaoSaude(char situacao) {
		int soma = 0;
		for (Pessoa pessoa : getPessoas()) {
			if (pessoa.getSituacaoSaude() == situacao)
				soma++;
		}
		return soma;
	}

	public int somaSituacaoSaude(char situacao, char genero) {
		int somaMasc = 0;
		int somaFem = 0;
		for (Pessoa pessoa : getPessoas()) {
			if (pessoa instanceof Feminino && pessoa.getSituacaoSaude() == situacao)
				somaFem++;
			else
				somaMasc++;
		}
		return (genero == 'F' ? somaFem : somaMasc);
	}
}
