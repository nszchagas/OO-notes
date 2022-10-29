package dados;

import java.util.Vector;

public class PresidentesBrasileiros {

	static private Vector<Presidente> presidentesBrasileiros = new Vector<Presidente>();

	public PresidentesBrasileiros() {
		presidentesBrasileiros = new Vector<Presidente>();
		setPresidentes();

	}

	private static Presidente getPresidenteAno(int ano) {

		int contador = 0;
		Presidente presidenteProcurado = null;

		while (contador < 37 && presidenteProcurado == null) {
			if (ano <= presidentesBrasileiros.get(contador).getFinalMandato())
				presidenteProcurado = presidentesBrasileiros.get(contador);
			contador++;
		}
		return presidenteProcurado;
	}

	static private void setPresidentes() {

		presidentesBrasileiros.add(new Presidente("Campos Sales", 1898, 1902));
		presidentesBrasileiros.add(new Presidente("Rodrigues Alves", 1902, 1906));
		presidentesBrasileiros.add(new Presidente("Afonso Pena", 1906, 1909));
		presidentesBrasileiros.add(new Presidente("Nilo Pecanha", 1909, 1910));
		presidentesBrasileiros.add(new Presidente("Hermes da Fonseca", 1910, 1914));
		presidentesBrasileiros.add(new Presidente("Venceslau Bras", 1914, 1918));
		presidentesBrasileiros.add(new Presidente("Delfim Moreira", 1918, 1919));
		presidentesBrasileiros.add(new Presidente("Epitacio Pessoa", 1919, 1922));
		presidentesBrasileiros.add(new Presidente("Artur Bernardes", 1922, 1926));
		presidentesBrasileiros.add(new Presidente("Washington Luis", 1926, 1930));
		presidentesBrasileiros.add(new Presidente("Getulio Vargas", 1930, 1937));
		presidentesBrasileiros.add(new Presidente("Getulio Vargas", 1937, 1945));
		presidentesBrasileiros.add(new Presidente("Jose Linhares", 1945, 1946));
		presidentesBrasileiros.add(new Presidente("Eurico Gaspar Dutra", 1946, 1951));
		presidentesBrasileiros.add(new Presidente("Getulio Vargas", 1951, 1954));
		presidentesBrasileiros.add(new Presidente("Cafe Filho", 1954, 1955));
		presidentesBrasileiros.add(new Presidente("Carlos Luz", 1955, 1955));
		presidentesBrasileiros.add(new Presidente("Nereu Ramos", 1955, 1956));
		presidentesBrasileiros.add(new Presidente("Juscelino Kubitschek", 1956, 1961));
		presidentesBrasileiros.add(new Presidente("Janio Quadros", 1961, 1961));
		presidentesBrasileiros.add(new Presidente("Joao Goulart", 1961, 1964));
		presidentesBrasileiros.add(new Presidente("Ranieri Mazzilli", 1961, 1961));
		presidentesBrasileiros.add(new Presidente("Humberto Castelo Branco", 1964, 1967));
		presidentesBrasileiros.add(new Presidente("Ranieri Mazzilli", 1964, 1964));
		presidentesBrasileiros.add(new Presidente("Artur da Costa e Silva", 1967, 1969));
		presidentesBrasileiros.add(new Presidente("Emilio Garrastazu Medici", 1969, 1974));
		presidentesBrasileiros.add(new Presidente("Junta Governativa Provisoria de 1969", 1969, 1969));
		presidentesBrasileiros.add(new Presidente("Ernesto Geisel", 1974, 1979));
		presidentesBrasileiros.add(new Presidente("Joao Figueiredo", 1979, 1985));
		presidentesBrasileiros.add(new Presidente("Jose Sarney", 1985, 1990));
		presidentesBrasileiros.add(new Presidente("Fernando Collor", 1990, 1992));
		presidentesBrasileiros.add(new Presidente("Itamar Franco", 1992, 1995));
		presidentesBrasileiros.add(new Presidente("Fernando Henrique Cardoso - FHC", 1995, 2003));
		presidentesBrasileiros.add(new Presidente("Luiz Inacio Lula da Silva", 2003, 2011));
		presidentesBrasileiros.add(new Presidente("Dilma Rousseff", 2011, 2016));
		presidentesBrasileiros.add(new Presidente("Michel Temer", 2016, 2019));
		presidentesBrasileiros.add(new Presidente("Jair Bolsonaro", 2019, 2020));

	}

	public static String getNomePresidenteAno(int ano) {

		setPresidentes();
		switch (ano) {
		case 1955:
			return "Carlos Luz ; Nereu Ramos";
		case 1961:
			return "Juscelino Kubitschek ; Janio Quadros ; Ranieri Mazzilli";
		case 1964:
			return "Humberto Castelo Branco ; Ranieri Mazzilli";
		case 1969:
			return "Junta Governativa Provisoria de 1969 ; Emilio Garrastazu Medici";
		default:
			return getPresidenteAno(ano).getNome();

		}
	}

}
