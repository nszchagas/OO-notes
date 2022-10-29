package dados;

import java.util.ArrayList;

public class Populacao {
	private ArrayList<Pessoa> populacao;
	
	public Populacao() {
		this.populacao = new ArrayList<Pessoa>();
	}
	
	public void addPessoa(Pessoa pessoa) {
		this.populacao.add(pessoa);
	}
	
	public Pessoa getPessoaAt(int index) {
		return this.populacao.get(index);
	}
	
	public int nPessoas() {
		return this.populacao.size();
	}
	
	public int nSaudaveis() {
		int num = 0;
		for (Pessoa pessoa : this.populacao) {
			if (pessoa instanceof Saudavel) {
				num++;
			}
		}
		return num;
	}
	
	public int nContaminados(char situacao) {
		int num = 0;
		for (Pessoa pessoa : this.populacao) {
			if (pessoa instanceof Contaminado && pessoa.getSituacao() == situacao) {
				num++;
			}
		}
		return num;
	}
	
	public int nFalecidos(char genero) {
		int num = 0;
		for (Pessoa pessoa : this.populacao) {
			if (pessoa.getGenero() == genero && pessoa.getSituacao() == 'F') {
				num++;
			}
		}
		return num;
	}
	
	public String toString() { // Identificador, Nome completo, Gênero por extenso, Idade e Situação
		String formato = "%-3s\t%-20s\t%-9s\t%-6s\t%-15s%n";
		String str = String.format(formato, "ID", "Nome", "Genero", "Idade", "Situacao");
		
		for (Pessoa pessoa : this.populacao) {
			str += pessoa.toString();
		}
		return str;
	}
}
