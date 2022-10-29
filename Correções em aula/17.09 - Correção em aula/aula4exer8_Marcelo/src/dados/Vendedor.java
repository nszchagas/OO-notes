package dados;

public class Vendedor {
	private int totalVendasMes[] = new int[4];

	public Vendedor(int[] totalVendasMes) {
		this.totalVendasMes = totalVendasMes;
	}

	public int[] getTotalVendasMes() {
		return totalVendasMes;
	}

	public void setTotalVendasMes(int[] totalVendasMes) {
		this.totalVendasMes = totalVendasMes;
	}
	
}
