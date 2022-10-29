package dados;

public class Homem extends Pessoa{
	private Integer idade;

	public Homem(int codigo, StringBuilder nome, char situacao, int idade) {
		super(codigo, nome, situacao);
		setIdade(idade);
	}
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String toString() {
		String formato = "%-20s%-30s%-20s%-13s%-10s\n";
		String situacao = null;
		
		switch (this.getSituacao()) {
		case 'T':{
			situacao = "Contaminado em Tratamento";
			break;
		}
		case 'F':{
			situacao = "Contaminada Falecida";
			break;
		}
		case 'C':{
			situacao = "Contaminada e Curada";
			break;
		}
		case 'S':{
			situacao = "Nao contaminada";
		}
		}
		return String.format(formato, this.getCodigo(),
				this.getNome(),
				situacao,
				this.idade,
				"--");
	}
}
