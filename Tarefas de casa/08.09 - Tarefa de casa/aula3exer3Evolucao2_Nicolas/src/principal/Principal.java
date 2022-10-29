package principal;

public class Principal {
	public static void main(String[] args) {

		final int LIMITE = 50;
		Grupo grupo = new Grupo(LIMITE);
		

		for (int aux = 0; aux < LIMITE; aux++) {

			Pessoa pessoa = new Pessoa(Validacao.validaNome(), Validacao.validaIdade(), Validacao.validaAltura());
			grupo.setPosicaoPessoa(aux, pessoa);

			if (aux == LIMITE - 1) {
				System.out.println("Voce atingiu o limite de pessoas que podem se cadastradas.");
				break;
			}
			
			if (!Saida.mostraMensagemContinuar())
				break;
			
			
			Servicos.limpaTela(30);

		}
		Servicos.limpaTela(50);
		Saida.mostraDadosGrupo(grupo);
	}

}
