package dados;

import java.util.ArrayList;
import java.util.List;

public class ListaCidades {

	private List<Cidade> listaCidades;

	public ListaCidades() {
		listaCidades = new ArrayList<Cidade>();
	}

	public List<Cidade> getLista() {
		return this.listaCidades;
	}

	public void addCidade(Cidade cidade) {
		this.listaCidades.add(cidade);
	}
	
	
}
