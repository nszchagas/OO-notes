package principal;

import dados.Empresa;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();

		Visao.menuPrincipal(empresa);

	}
}
