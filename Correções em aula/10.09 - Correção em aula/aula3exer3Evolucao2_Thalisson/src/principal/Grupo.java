package principal;

import sun.security.util.Length;

public class Grupo {
	private Pessoa[] pessoas;
	
	public Grupo(int length) {
		pessoas = new Pessoa[length];
		for (int i = 0; i < length; i++)
			pessoas[i] = null;
	}
	
	public void push(Pessoa pessoa) {
		for (int i = 0; i < pessoas.length; i++)
			if (pessoas[i] == null) {
				pessoas[i] = pessoa;
				break;
			}
	}
	
	public Pessoa at(int index) throws ArrayIndexOutOfBoundsException {
		return pessoas[index];
	}
	
	public int length() {
		int length;
		for (length = 0; length < pessoas.length; length++)
			if (pessoas[length] == null)
				return length;

		return length;
	}
}
