package dados;

public class Cidade {

	private String nome;
	private String estado;
	private Integer qtdContaminados;
	private Integer qtdContaminadosFalecidos;

	public Cidade(String nome, String estado, int contaminados, int contaminadosFalecidos) {
		this.setNome(nome);
		this.setEstado(estado);
		this.setContaminados(contaminados);
		this.setContaminadosFalecidos(contaminadosFalecidos);
	}

	public Cidade(String nome, String estado) { // sobrecarregado para poder usar o equals na validacao
		this.setEstado(estado);
		this.setNome(nome);
	}

	public Integer getContaminados() {
		return qtdContaminados;
	}

	public void setContaminados(Integer contaminados) {
		this.qtdContaminados = contaminados;
	}

	public Integer getContaminadosFalecidos() {
		return qtdContaminadosFalecidos;
	}

	public void setContaminadosFalecidos(Integer contaminadosFalecidos) {
		this.qtdContaminadosFalecidos = contaminadosFalecidos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public boolean equals(Object objeto) {
		try {
			return (this.getNome().equalsIgnoreCase(((Cidade) objeto).getNome())
					&& this.getEstado().equalsIgnoreCase(((Cidade) objeto).getEstado()));
		} catch (ClassCastException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		String formato = "| %-60s | %-6s | %-12s | %-9s | \n";
		return String.format(formato, this.getNome(), this.getEstado(), this.getContaminados(),
				this.getContaminadosFalecidos());
	}

}
