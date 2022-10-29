package dados;

public class Nome {
	
	private String nomes [];
	
	public Nome(String nomeCompleto) {
		this.nomes = nomeCompleto.split(" ");
	}
	
	public String[] getNomes() {
		return this.nomes;
	}

}
