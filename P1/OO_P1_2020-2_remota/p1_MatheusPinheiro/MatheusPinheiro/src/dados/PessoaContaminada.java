package dados;

public class PessoaContaminada extends Pessoa {
	private String situacao;
	public PessoaContaminada(String nome, String genero, Integer identificador, String situacao) {
		super(nome, genero, identificador);
		setSituacao(situacao);
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String toString() {
		String formato = "%-20s%-20s%-20s%-20s%-20s\n";
		return String.format(formato, getIdentificador(), getNome(), getGenero(),  "-----" , getSituacao());
	}
}
