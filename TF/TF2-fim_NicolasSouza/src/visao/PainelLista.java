package visao;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dados.Pessoa;
import dao.PessoaDAO;

@SuppressWarnings("serial")
class PainelLista extends JPanel implements ActionListener {
	private JButton btnAtualizar;
	private JTable tabela;
	private JScrollPane painelRolagem;

	public PainelLista() {
		setSize(660, 337);
		setVisible(true);
		setLayout(null);

		btnAtualizar = new JButton("Mostrar lista");
		btnAtualizar.setIcon(new ImageIcon("imagens/lista.png"));
		btnAtualizar.setToolTipText("Mostra todos as pessoas cadastradas.");
		btnAtualizar.setBounds(457, 11, 154, 23);
		btnAtualizar.addActionListener(this);

		add(btnAtualizar);

		painelRolagem = new JScrollPane();
		painelRolagem.setBounds(0, 42, 633, 284);
		add(painelRolagem);

		JLabel lblReordenacao = new JLabel("Clique na coluna desejada para alterar a ordena\u00E7\u00E3o dos dados.");
		lblReordenacao.setBounds(10, 15, 437, 14);
		add(lblReordenacao);
	}

	private void configuraTabela() {
		// DADOS

		Vector<Vector<String>> lista = new Vector<Vector<String>>();
		Vector<Pessoa> pessoasOrdenadasPorID = new Vector<Pessoa>(new PessoaDAO().getPessoas());
		if (pessoasOrdenadasPorID.size() > 0) {
			Collections.sort(pessoasOrdenadasPorID, new Comparator<Pessoa>() {

				@Override
				public int compare(Pessoa pes1, Pessoa pes2) {
					return pes1.getID().compareTo(pes2.getID());

				}
			});

			for (Pessoa pes : pessoasOrdenadasPorID) {
				lista.add(pes.toVectorString());
			}

			tabela = new ModeloTabela(lista);
			painelRolagem.setViewportView(tabela);

			JOptionPane.showMessageDialog(this, "Lista atualizada com sucesso", "Atualização concluída",
					JOptionPane.INFORMATION_MESSAGE, null);
		} else
			JOptionPane.showMessageDialog(this, "Não há ninguém cadastrado!", "Erro", JOptionPane.WARNING_MESSAGE,
					null);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btnAtualizar) {
			btnAtualizar.setText("Atualizar Lista");
			btnAtualizar.setIcon(new ImageIcon("imagens/atualizar.png"));
			btnAtualizar.setToolTipText("Atualiza a tabela em exibição.");

			configuraTabela();
		}

	}
}
