package dados;

public class Vendas {
	// DECLARACOES
	private int vendaTotais[][];
	
	// INSTRUCOES
	public Vendas(int vendedores, short semanas) {
		this.vendaTotais = new int[vendedores][semanas];
	}
	
	// Metodos Acessores
	 public int [][] getVendas() {
		return vendaTotais;
	 }
	
	 public int getVendas(int vendedor, int semanas) {
		return vendaTotais[vendedor][semanas];
	 }
	
	public void setVendas(int vendedores, int semanas, int total) {
		this.vendaTotais[vendedores][semanas] = total;
	}
	
}
