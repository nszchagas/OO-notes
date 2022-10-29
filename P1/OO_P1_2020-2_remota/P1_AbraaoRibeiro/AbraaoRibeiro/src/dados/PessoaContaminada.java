package dados;

public class PessoaContaminada extends Pessoa{
	private String situacao;
		public PessoaContaminada(StringBuilder nome, Character genero, Integer identificador,String situacao) {
			super(nome, genero, identificador);
			setSituacao(situacao);
		}
		public void setSituacao(String situracao) {
			this.situacao = situracao;
		}
		public String toString() {
			return String.format("%-18s%-18s%-30s%-24s%-24s\n",getIdentificador(),getNome(),getGenero(),getIdentificador(),this.situacao);
			
		}
}
