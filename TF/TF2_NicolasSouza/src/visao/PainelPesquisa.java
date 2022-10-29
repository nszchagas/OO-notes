package visao;

import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dados.Pessoa;
import dao.PessoaDAO;

@SuppressWarnings("serial")
class PainelPesquisa extends JPanel implements ActionListener {
	private JTextField nomeBusca;
	private JButton btnBusca;
	private JTable tabela;
	private JScrollPane painelRolagem = new JScrollPane();

	PainelPesquisa() {
		setSize(620, 337);
		setVisible(true);
		configuraCampoBusca();
		configuraTabela();
		setLayout(null);

		nomeBusca.addActionListener(this);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setBounds(10, 14, 46, 14);
		add(lblNome);

		painelRolagem.setBounds(0, 42, 633, 284);
		add(painelRolagem);

		configuraTabela();

	}

	private void configuraCampoBusca() {

		nomeBusca = new JTextField();
		nomeBusca.setBounds(66, 11, 417, 20);
		add(nomeBusca);
		nomeBusca.setPreferredSize(new Dimension(400, 30));

		btnBusca = new JButton("Buscar");
		btnBusca.setBounds(493, 10, 100, 23);
		btnBusca.setIcon(new ImageIcon("imagens/procurar.png"));
		add(btnBusca);
		btnBusca.addActionListener(this);
	}

	private void configuraTabela() {
		// DADOS

		Vector<Vector<String>> lista = new Vector<Vector<String>>();
		Vector<Pessoa> pessoasOrdenadasNome = new Vector<Pessoa>(new PessoaDAO().pesquisaPorNome(nomeBusca.getText()));
		Collections.sort(pessoasOrdenadasNome, new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa pes1, Pessoa pes2) {
				return pes1.getNome().compareTo(pes2.getNome());

			}
		});

		for (Pessoa pes : pessoasOrdenadasNome) {
			lista.add(pes.toVectorString());
		}
		tabela = new ModeloTabela(lista);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btnBusca || ev.getSource() == nomeBusca) {
			if (nomeBusca.getText() == null || nomeBusca.getText().length() == 0)
				JOptionPane.showMessageDialog(this, "Digite um nome ou parte dele.", "Erro", JOptionPane.ERROR_MESSAGE);
			else {

				configuraTabela();
				painelRolagem.setViewportView(tabela);
			}

		}

	}
}
