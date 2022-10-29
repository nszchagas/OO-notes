package dados;

public class Pessoa {
	private StringBuffer nome;
	private Integer identificador;
	private StringBuffer sexo;
	private StringBuffer saude;
	private Integer idade;
	private StringBuffer gestacao;

	public Pessoa(Integer identificador, StringBuffer nome, StringBuffer saude, StringBuffer sexo) {
		this.setIdentificador(identificador);
		this.setNome(nome);
		this.setSaude(saude);
		this.setSexo(sexo);
	}

	public StringBuffer getNome() {
		return nome;
	}

	public void setNome(StringBuffer nome) {
		this.nome = nome;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public StringBuffer getSexo() {
		return sexo;
	}

	public void setSexo(StringBuffer sexo) {
		this.sexo = sexo;
	}

	public StringBuffer getSaude() {
		return saude;
	}

	public void setSaude(StringBuffer saude) {
		this.saude = saude;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public StringBuffer getGestacao() {
		return gestacao;
	}

	public void setGestacao(StringBuffer gestacao) {
		this.gestacao = gestacao;
	}

	public static Integer pegaIdade(Integer idade, Pessoa pessoa) {
		pessoa.setIdade(idade);
		return idade;
	}

	public static StringBuffer pegaGestacao(StringBuffer gestacao, Pessoa pessoa) {
		pessoa.setGestacao(gestacao);
		return gestacao;
	}

	public static String toString(StringBuffer sexo, Pessoa pessoa) {
		if (pessoa.getSexo().equals("MASCULINO")) 
			return String.format("%-30s%-30s%-35s%-30s%-20s%-20s\n", pessoa.getIdentificador(), pessoa.getNome(),
					pessoa.getSaude(), pessoa.getSexo(), pessoa.getIdade(), " ");
		
		if (pessoa.getSexo().equals("FEMININO")) 
			return String.format("%-30s%-30s%-35s%-30s%-20s%-20s\n", pessoa.getIdentificador(), pessoa.getNome(),
					pessoa.getSaude(), pessoa.getSexo(), " ", pessoa.getGestacao());
		else
		return null;
		
	}

}
