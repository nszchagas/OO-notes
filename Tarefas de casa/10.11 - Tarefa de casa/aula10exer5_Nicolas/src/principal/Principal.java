package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dados.Cidade;
import dados.ListaCidades;
import validacao.Validacao;
import visao.Visao;

public class Principal {
	public static void main(String[] args) {

		ListaCidades lista = new ListaCidades();
		boolean sair = false;
		while (!sair) {
			switch (Visao.mostraMenu("Escolha uma opcao",
					new String[] { "Cadastrar uma cidade", "Consultar cidades" })) {
			case -1:
				if (Visao.perguntaSimOuNao("Encerrar o programa?", "Sair"))
					sair = true;
				break;
			case 0:
				try {
					String nome;
					int DDD;
					Cidade cidade;
					do {
						nome = Visao.registraNome();
						if (nome == null)
							throw new NullPointerException();
						DDD = Visao.registraDDD();
						if (DDD == -1)
							throw new NullPointerException();
						cidade = new Cidade(nome, DDD);

					} while (!Validacao.isCidadeNova(cidade, lista.getLista()));
					lista.addCidade(cidade);
				} catch (NullPointerException e) {
					break;
				}
				break;
			case 1:
				List<Cidade> listaOrganizada = new ArrayList<Cidade>(lista.getLista()); // para não alterar a inserção
																						// original de dados
				Collections.sort(listaOrganizada);
				Visao.mostraTabela(listaOrganizada);
			}
		}

	}
}
