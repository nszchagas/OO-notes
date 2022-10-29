package visao;

import javax.swing.JOptionPane;

import dados.Cidade;
import dados.ColecaoCidades;

public class Visao {

	public static void cadastraCidade(ColecaoCidades colecao) {
		int ddd;
		String nome;
		
		nome = JOptionPane.showInputDialog(null, "Digite o nome da cidade.", "Registro", JOptionPane.PLAIN_MESSAGE);
		
		do {
			try {
				ddd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o DDD desta cidade.", "Registro", JOptionPane.PLAIN_MESSAGE));
								
				if (ddd <= 10)
					throw new Exception("DDD inválido.");
				
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(null, "DDD Inválido. Digite DDD maior que 10.", "Erro", JOptionPane.ERROR_MESSAGE);
				ddd = 0;
			}
		} while (ddd < 10);
		
		if(colecao.getCidades().isEmpty()) {
			colecao.getCidades().add(new Cidade(nome, ddd));
		} else {
			Cidade cidadeNova = new Cidade(nome, ddd);
			
			for(Cidade cidade : colecao.getCidades()) {
				if(cidade.equals(cidadeNova)) {
					JOptionPane.showMessageDialog(null, "Cidade ja existe! Tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			colecao.getCidades().add(cidadeNova);
		}
		
	}
	
	public static void mostraCidadesCadastradas(ColecaoCidades colecao) {
		if(!colecao.getCidades().isEmpty()) {
			System.out.println("DDD\tCidade\n===    ========");
			
			for(Cidade cidade : colecao.getCidades())
				System.out.println(cidade);			
		}
	}
	
}
