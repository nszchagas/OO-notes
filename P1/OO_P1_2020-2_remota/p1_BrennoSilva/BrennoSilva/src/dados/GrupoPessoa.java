package dados;

import java.util.Vector;

public class GrupoPessoa {
	private Vector<Pessoa> grupoCovid;
	
	public GrupoPessoa() {
		this.grupoCovid = new Vector<Pessoa>();
	}

	public Vector<Pessoa> getGrupoCovid() {
		return grupoCovid;
	}

	public void setGrupoCovid(Pessoa pessoa) {
		this.grupoCovid.add(pessoa);
	}

	public int getQtdNaoContaminados() {
		int qtd = 0;
		for (Pessoa pessoa : grupoCovid) {
			if(pessoa instanceof PessoaNaoContaminada)
				qtd++;
		}
		return qtd;
	}
	
	public int getQtdContaminadosEmTratamento() {
		int qtd = 0;
		for (Pessoa pessoa : grupoCovid) {
			if(pessoa instanceof PessoaContaminada) {
				if(((PessoaContaminada) pessoa).getSituacao() == 'E')
					qtd++;
			}				
		}
		return qtd;
	}
	
	public int getQtdContaminadosCurados() {
		int qtd = 0;
		for (Pessoa pessoa : grupoCovid) {
			if(pessoa instanceof PessoaContaminada) {
				if(((PessoaContaminada) pessoa).getSituacao() == 'C')
					qtd++;
			}				
		}
		return qtd;
	}
	
	public int getQtdMulheresFalecidas() {
		int qtd = 0;
		for (Pessoa pessoa : grupoCovid) {
			if(pessoa instanceof PessoaContaminada) {
				if(((PessoaContaminada) pessoa).getSituacao() == 'F') {
					if(pessoa.getGenero() == 'F') {
						qtd++;
					}
				}
			}				
		}
		return qtd;
	}
}
