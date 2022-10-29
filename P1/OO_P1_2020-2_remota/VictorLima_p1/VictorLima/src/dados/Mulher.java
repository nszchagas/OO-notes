package dados;

public class Mulher extends Pessoa {
	private String gestante;

	public Mulher(Integer idPessoa, StringBuilder nome, String situacao, String gestante) {
		super(idPessoa, nome, situacao);
		setGestante(gestante);

	}

	public String getGestante() {
		return gestante;
	}

	public void setGestante(String gestante) {
		this.gestante = gestante;
	}

	public String toString() {
		return (this.getIdPessoa() + "\t\t\t" + this.getNome() + "\t\t\t" + this.getSituacao() + "\t\t\t-\t\t\t"+this.getGestante());
	}

}
