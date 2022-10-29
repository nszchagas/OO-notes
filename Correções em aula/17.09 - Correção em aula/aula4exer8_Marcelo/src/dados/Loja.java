package dados;

public class Loja {
	private Vendedor totalVendasVendedores[] = new Vendedor[4];

	public Loja(Vendedor[] totalVendasVendedores) {
		this.totalVendasVendedores = totalVendasVendedores;
	}

	public Vendedor[] getTotalVendasVendedores() {
		return totalVendasVendedores;
	}

	public void setTotalVendasVendedores(Vendedor[] totalVendasVendedores) {
		this.totalVendasVendedores = totalVendasVendedores;
	}
	
}
