package dados;

public class Cidade {
	private StringBuilder cidade;
	private StringBuilder estado;
	private Integer contaminados;
	private Integer mortos;

	public Cidade(StringBuilder cidade, StringBuilder estado, Integer contaminados, Integer mortos) {
		setCidade(cidade);
		setEstado(estado);
		setContaminados(contaminados);
		setMortos(mortos);
	}

	public StringBuilder getCidade() {
		return cidade;
	}

	public void setCidade(StringBuilder cidade) {
		this.cidade = cidade;
	}

	public StringBuilder getEstado() {
		return estado;
	}

	public void setEstado(StringBuilder estado) {
		this.estado = estado;
	}

	public Integer getContaminados() {
		return contaminados;
	}

	public void setContaminados(Integer contaminados) {
		this.contaminados = contaminados;
	}

	public Integer getMortos() {
		return mortos;
	}

	public void setMortos(Integer mortos) {
		this.mortos = mortos;
	}

	public boolean equals(StringBuilder cidade, StringBuilder estado) {
		return (cidade.toString().equalsIgnoreCase(this.getCidade().toString())
				&& estado.toString().equalsIgnoreCase(this.getEstado().toString()));
	}

	public String toString() {
		String formato = "%-15s%-10s%-15s%-20s\n";
		return String.format(formato, this.getCidade(), this.getEstado(), this.getContaminados(), this.getMortos());
	}

}