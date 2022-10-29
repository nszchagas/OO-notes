package visao;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dados.Pessoa;
import dao.PessoaDAO;
import validacao.Validacao;

@SuppressWarnings("serial")
class PainelMostra extends JPanel implements ActionListener {
	private JTextField txtFieldID;
	private JButton btnBusca;

	PainelMostra() {
		setLayout(null);

		txtFieldID = new JTextField();
		txtFieldID.setBounds(116, 46, 86, 20);
		add(txtFieldID);
		txtFieldID.addActionListener(this);
		txtFieldID.setColumns(10);

		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.TRAILING);
		lblID.setBounds(60, 49, 46, 14);
		add(lblID);

		btnBusca = new JButton("Buscar");
		btnBusca.setBounds(233, 45, 100, 23);
		btnBusca.setIcon(new ImageIcon("imagens/procurar.png"));
		btnBusca.setToolTipText("Efetua a busca no banco de dados");
		add(btnBusca);
		btnBusca.addActionListener(this);

		JLabel lblInstrucoes = new JLabel("Pesquisa por identificador. Insira o ID a ser procurado no banco de dados.");
		lblInstrucoes.setBounds(10, 19, 430, 14);
		add(lblInstrucoes);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtFieldID || e.getSource() == btnBusca) {
			efetuaBusca();
		}

	}

	private void efetuaBusca() {

		int id;

		try {
			id = Integer.parseInt(txtFieldID.getText());
			if (Validacao.isCodigo(id)) {
				Pessoa pes = new PessoaDAO().getPessoa(id);
				if (pes == null)

				{
					JOptionPane.showMessageDialog(this, "Não há registros para o código " + id, "Erro",
							JOptionPane.INFORMATION_MESSAGE, null);

				} else
					JOptionPane.showMessageDialog(this, "Pessoa encontrada: \n" + pes.toString(), "Resultado",
							JOptionPane.PLAIN_MESSAGE, null);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE, null);
		}

	}
}
