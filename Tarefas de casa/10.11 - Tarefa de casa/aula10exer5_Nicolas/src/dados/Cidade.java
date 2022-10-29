package dados;

public class Cidade implements Comparable<Object> {
	private String nome;
	private Integer DDD;

	public Cidade(String nome, int DDD) {
		setNome(nome);
		setDDD(DDD);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDDD() {
		return DDD;
	}

	public void setDDD(int DDD) {
		this.DDD = DDD;
	}

	public String toString() {
		String formato = "| %-3s | %-60s |";
		return String.format(formato, this.getDDD(), this.getNome());
	}

	@Override
	public int compareTo(Object objeto) {
		Cidade cidadeParametro = (Cidade) objeto;
		if (this.getDDD() > cidadeParametro.getDDD())
			return 1;
		else if (this.getDDD() < cidadeParametro.getDDD())
			return -1;
		else
			return 0;
	}

	@Override
	public boolean equals(Object objeto) {
		try {
			return ((Cidade) objeto).getDDD().equals(this.getDDD())
					&& ((Cidade) objeto).getNome().equals(this.getNome());
		} catch (ClassCastException e) {
			return false;
		}

	}
}