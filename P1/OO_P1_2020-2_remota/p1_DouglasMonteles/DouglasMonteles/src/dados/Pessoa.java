package dados;

public class Pessoa {

	private StringBuilder nome;
	private Character genero;
	private Integer id;
	
	public Pessoa(String nome, Character genero, Integer id) {
		super();
		this.nome.append(nome);
		this.genero = genero;
		this.id = id;
	}

	public StringBuilder getNome() {
		return nome;
	}

	public String getGenero() {
		return (this.genero == 'M') ? "Masculino" : "Feminino";
	}

	public Integer getId() {
		return id;
	}
	
}
