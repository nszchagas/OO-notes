package dados;


public class Cidade implements Comparable<Integer> {
	private String nome;
	private int DDD;

	public Cidade(String nome, int DDD) {
		setDDD(DDD);
		setNome(nome);
	}
	
	public String getNome() {
		return nome; 
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDDD() {
		return DDD;
	}

	public void setDDD(int DDD) {
		this.DDD = DDD;
	}

	public String toString() {
		return ("" + this.getDDD() + "\t" + this.getNome());
	}
	
	public boolean equals(Object obj) {
		Cidade cidadeComparada = (Cidade) obj;
		
		if(cidadeComparada.getDDD() == this.getDDD() && cidadeComparada.getNome().equalsIgnoreCase(this.getNome()))
			return true;
		
		return false;
	}

	public int compareTo(Object objeto) {
		Cidade cidadeParametro = (Cidade) objeto;
		
		if(cidadeParametro.getDDD() < this.getDDD())
			return 1;
		else if(cidadeParametro.getDDD() == this.getDDD())
			return 0;
		else
			return -1;
	}

}
