package servicos;

import java.util.Vector;

public class Servicos {

	public static Vector<StringBuilder> separaNomes(StringBuilder nome) {

		Vector<StringBuilder> nomesSeparados = new Vector<StringBuilder>();

		for (int i = 0; i < nome.toString().split(" ").length; i++)
			nomesSeparados.add(new StringBuilder(nome.toString().toUpperCase().split(" ")[i]));

		return nomesSeparados;
	}

	public static StringBuilder concatenaNomes(Vector<StringBuilder> nome) {
		return nome.elementAt(nome.size() - 1).append("/").append(nome.elementAt(0));
	}
	
	

}
