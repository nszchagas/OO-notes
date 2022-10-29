package dados;

public class Saudaveis extends Pacientes{
	private Integer idade;

	public Saudaveis(StringBuilder nomeCompleto, Character genero, Integer indentificador, Integer idade) {
		super(nomeCompleto, genero, indentificador);
		setIdade(idade);
	}
	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String toString() {
		String formato = "%-5s%-25s%-20s%-5s%-30s";
		return String.format(formato , this.getIndentificador(), this.getNomeCompleto(), (this.getGenero() == 'M' ? "Masculino" : "Feminino"), this.getIdade(), "------");
	}
	
	

}
