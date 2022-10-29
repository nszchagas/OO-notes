package dados;


public class Contaminada extends Pessoa{
	private Character situacao;
	
	
	// Metodo construtor
	public Contaminada(StringBuilder nome, char genero, int identiticacao, char situacao) {
		super(nome, genero, identiticacao);
		this.setSituacao(situacao);
	}
	
	
	// Metodos assessores
	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}
	
	public Character getSituacao() {
		return this.situacao;
	}
	
	public String toString() {
		String formato = "%-15s%-25s%-18s%-10s%-15s\n";
		return String.format(formato, this.getIdentificacao(), this.getNome(),  generoPorExtenso(this.getGenero()),
				"---", this.situacaoPorExtenso(this.getSituacao()));
	}
	
	
	public String situacaoPorExtenso(char situacao) {
		if (situacao == 'F')
			return "Falecido";
		else if (situacao == 'E')
			return "Em tratamento.";
		else 
			return "Curado.";
	}
	
	
	
}
