//Nome: Murilo da Silva Pereira          Data: 20/10/2020
package principal;

public class Principal {

	public static void main(String[] args) {
		char tipoPessoa;
		GrupoTodasPessoas grupoTodasPessoas = new GrupoTodasPessoas();
		
		do {
			System.out.println("Se deja cadastrar uma pessoa contaminada insira 'C' ou se for uma pessoa nao contaminada insira 'N'");
			tipoPessoa = Leitura.lerChar();
			switch (tipoPessoa) {
			case 'C':
					registraPessoaInfectada(grupoTodasPessoas);
				break;
			case 'N':
					registraPessoaNormal(grupoTodasPessoas);
				break;
			}
		} while (Validacao.validaMenu() == 1);
		if (Validacao.validaMenu() == 2) {
			Visao.mostraTabela(grupoTodasPessoas);
		}
	}
	
	public static void registraPessoaNormal(GrupoTodasPessoas grupoTodasPessoas) {
		PessoaNaoInfectada pessoaNaoInfectada = new PessoaNaoInfectada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validadIdentificador(), Validacao.validaIdade());
		grupoTodasPessoas.setGrupoTodasPessoas(pessoaNaoInfectada);
	}
	
	public static void registraPessoaInfectada(GrupoTodasPessoas grupoTodasPessoas) {
		PessoaInfectada pessoaInfectada = new PessoaInfectada(Validacao.validaNome(), Validacao.validaGenero(), Validacao.validadIdentificador(), Validacao.validaSituacaoSaude());
	}

}
