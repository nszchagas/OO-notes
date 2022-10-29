package dados;

import java.util.Vector;

public abstract class Pessoa {
	private StringBuilder nome;
	private Integer idPessoa;
	private Character situacaoDeSaude;

	Pessoa(String nome, char situacaoDeSaude) {
		setNome(nome);
		setSituacaoDeSaude(situacaoDeSaude);
	}

	public String getNome() {
		return nome.toString();
	}

	public void setNome(String nome) {
		this.nome = new StringBuilder(nome);
	}

	public Integer getID() {
		return idPessoa;
	}

	public void setID(int codigo) {
		this.idPessoa = codigo;
	}

	public Character getSituacaoDeSaude() {
		return situacaoDeSaude;
	}

	public void setSituacaoDeSaude(char situacaoDeSaude) {
		this.situacaoDeSaude = situacaoDeSaude;
	}

	private String getSituacaoDeSaudeExtenso() {
		switch (this.getSituacaoDeSaude()) {
		case 'T':
			return "Contaminado em tratamento";
		case 'F':
			return "Contaminado falecido";
		case 'C':
			return "Contaminado curado";
		case 'S':
			return "Sem contaminacao";
		}
		return "";
	}

	public Vector<String> toVectorString() {
		Vector<String> dados = new Vector<String>();
		dados.add(this.getID().toString());
		dados.add(this.getNome().toLowerCase()); // não altera o cadastro original
		dados.add(this.getSituacaoDeSaudeExtenso());
		return dados;
	}

	public String toString() {
		return String.format("ID: %s \nNome: %s \nSituação de saúde: %s \n", this.getID(), this.getNome(),
				this.getSituacaoDeSaudeExtenso());
	}

}
