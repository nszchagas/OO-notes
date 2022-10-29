package dados;

public class Data {

	public Integer mes;
	public Integer dia;
	public Integer ano;

	Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String toString() {

		return String.format("%02d/%02d/%4d", dia, mes, ano);
	}

	public static Data getDataDeString(String data) {
		return new Data(Integer.valueOf(data.split("/")[0]), Integer.valueOf(data.split("/")[1]),
				Integer.valueOf(data.split("/")[2]));
	}

}
