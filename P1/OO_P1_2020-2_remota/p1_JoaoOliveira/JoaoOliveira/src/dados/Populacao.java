package dados;

import java.util.ArrayList;

public class Populacao {
	private ArrayList<Pessoa> populacao;
	
	public Populacao () {
		this.populacao = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPopulacao() {
		return populacao;
	}

	public void setPopulacao (Pessoa pessoa) {
		this.populacao.add(pessoa);
	}
	
	public int qtdNaoContaminados () {
		int qtd = 0;
		for (Pessoa pessoa : populacao) {
			if (pessoa instanceof Saudavel) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public int qtdContaminadosTratamento () {
		int qtd = 0;
		for (Pessoa pessoa : populacao) {
			if (pessoa instanceof Contaminado) {
				if (((Contaminado) pessoa).getEstadoSaude().equals("EM TRATAMENTO")) {
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	public int qtdContaminadosCurados () {
		int qtd = 0;
		for (Pessoa pessoa : populacao) {
			if (pessoa instanceof Contaminado) {
				if (((Contaminado) pessoa).getEstadoSaude().equals("CURADO")) {
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	public int qtdMulheresFalecidas () {
		int qtd = 0;
		for (Pessoa pessoa : populacao) {
			if (pessoa instanceof Contaminado) {
				if (((Contaminado) pessoa).getEstadoSaude().equals("FALECIDO") && pessoa.getGenero().equals("FEMININO")) {
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	public int qtdHomensFalecidos () {
		int qtd = 0;
		for (Pessoa pessoa : populacao) {
			if (pessoa instanceof Contaminado) {
				if (((Contaminado) pessoa).getEstadoSaude().equals("FALECIDO") && pessoa.getGenero().equals("MASCULINO")) {
					qtd++;
				}
			}
		}
		return qtd;
	}
}
