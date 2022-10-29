package principal;

import javax.swing.JOptionPane;

import dados.Cidade;
import dados.ColecaoCidades;
import interfaces.Pesquisas;
import validacao.Validacao;
import visao.Visao;

public class Principal {

	public static void main(String[] args) {

		int opcao;
		boolean sair = false;
		ColecaoCidades cidades = new ColecaoCidades();

		while (!sair) {
			opcao = Visao.mostraMenu("Escolha uma opcao:", "Menu principal",
					new String[] { "Nova Cidade", "Pesquisa Cidade Contaminada" });

			switch (opcao) {
			case 0:
				String nome = Visao.registraNomeCidade();
				String estado = null;
				if (nome != null)
					estado = Visao.registraEstado();
				if (estado != null) {
					try {
						if (Validacao.isCidadeNova(new Cidade(nome, estado), cidades.getColecao())) {
							int[] contaminacoes = Visao.registraContaminacoes();
							cidades.add(new Cidade(nome, estado, contaminacoes[0], contaminacoes[1]));
						}
					} catch (NullPointerException e) {
					}
				}
				break;
			case 1:
				if (cidades.getColecao().size() > 0) {
					Pesquisas<Cidade> pesquisa = new ColecaoCidades();
					int parametro = Visao.registraParametro();
					if (parametro != -1) {
						Visao.mostraMensagem("Confira valores encontrados na console", JOptionPane.INFORMATION_MESSAGE);
						Visao.mostraTabela(pesquisa.mostraContaminadas(cidades.getColecao(), parametro));
					}
				} else
					Visao.mostraMensagem("Primeiro faca um cadastro para poder pesquisar os dados;",
							JOptionPane.WARNING_MESSAGE);
				break;

			case -1:
				if (Visao.janelaConfirmacao("Deseja mesmo sair do programa?", "Sair"))
					sair = true;
				break;

			}

		}

	}

}
