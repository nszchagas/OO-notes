package visao;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import dados.Homem;
import dados.Mulher;
import dao.PessoaDAO;
import validacao.Validacao;

@SuppressWarnings("serial")
class PainelNovo extends JPanel implements ActionListener, ItemListener {

	private JButton btnSalvar, btnLimpar;
	private JTextField txtFieldNome, txtFieldIdade;
	private JRadioButton masculino, feminino;
	private JComboBox<String> comboBoxGravidez;
	private JComboBox<String> comboBoxSituacaoDeSaude;
	private ButtonGroup bgSexo;

	PainelNovo() {

		setSize(625, 354);
		setLayout(null);
		configuraDadosPessoais();
		configuraBotoes();
		configuraSituacaoDeSaude();

	}

	private void configuraDadosPessoais() {

		// CONFIGURA OS PAINEIS //

		JPanel painelDadosPessoais = new JPanel(null);
		painelDadosPessoais.setBorder(
				new TitledBorder(null, "Dados pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelDadosPessoais.setBounds(10, 11, 605, 163);

		JPanel painelSexo = new JPanel(null);
		painelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelSexo.setBounds(10, 71, 273, 68);

		// CONFIGURA OS LABELS //

		JLabel lblNome = new JLabel("Nome", SwingConstants.LEFT);
		lblNome.setBounds(10, 31, 49, 20);

		JLabel lblIdade = new JLabel("Idade", SwingConstants.LEFT);
		lblIdade.setBounds(315, 74, 46, 20);
		lblIdade.setVerticalAlignment(SwingConstants.BOTTOM);

		JLabel lblGravidez = new JLabel("Já esteve grávida?", SwingConstants.LEFT);
		lblGravidez.setBounds(405, 60, 122, 34);
		lblGravidez.setVerticalAlignment(SwingConstants.BOTTOM);

		// CAMPOS DE TEXTO //

		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(48, 31, 529, 20);

		txtFieldIdade = new JTextField();
		txtFieldIdade.setBounds(315, 94, 54, 20);
		txtFieldIdade.setPreferredSize(new Dimension(40, 30));
		txtFieldIdade.setEnabled(false);

		// RADIO BUTTONS //

		masculino = new JRadioButton("Masculino");
		masculino.setBounds(6, 16, 117, 45);
		masculino.setSelected(false);
		masculino.addItemListener(this);

		feminino = new JRadioButton("Feminino");
		feminino.setBounds(143, 16, 124, 45);
		feminino.setSelected(false);
		feminino.addItemListener(this);

		bgSexo = new ButtonGroup();
		bgSexo.add(feminino);
		bgSexo.add(masculino);

		// PAINEL SEXO //

		painelSexo.add(feminino);
		painelSexo.add(masculino);

		// COMBO BOX GRAVIDEZ //

		comboBoxGravidez = new JComboBox<String>(new String[] { "Sim", "Não", "Não tem certeza" });
		comboBoxGravidez.setBounds(405, 94, 172, 20);
		comboBoxGravidez.setEnabled(false);
		comboBoxGravidez.setSelectedItem(null);

		// ADICIONA OS COMPONENTES AO PAINEL DE DADOS PESSOAIS //

		add(painelDadosPessoais);
		painelDadosPessoais.add(lblNome);
		painelDadosPessoais.add(txtFieldNome);
		painelDadosPessoais.add(painelSexo);
		painelDadosPessoais.add(lblIdade);
		painelDadosPessoais.add(txtFieldIdade);
		painelDadosPessoais.add(comboBoxGravidez);
		painelDadosPessoais.add(lblGravidez);

	}

	private void configuraBotoes() {

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(356, 282, 122, 23);
		btnSalvar.addActionListener(this);
		btnSalvar.setToolTipText("Salva o cadastro");
		btnSalvar.setIcon(new ImageIcon("imagens/salvar.png"));

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(493, 282, 122, 23);
		btnLimpar.addActionListener(this);
		btnLimpar.setToolTipText("Limpa todos os campos sem salvar o cadastro");
		btnLimpar.setIcon(new ImageIcon("imagens/limpar.png"));

		// ADICIONA OS BOTOES
		add(btnSalvar);
		add(btnLimpar);

	}

	private void configuraSituacaoDeSaude() {

		// CONFIGURA O PAINEL //

		JPanel painelSaude = new JPanel(null);
		painelSaude.setBorder(
				new TitledBorder(null, "Situação de saúde", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelSaude.setBounds(10, 177, 605, 94);

		// LABEL //

		JLabel lblSituacaoDeSaude = new JLabel("Contaminado por covid-19?", SwingConstants.LEFT);
		lblSituacaoDeSaude.setBounds(10, 29, 194, 34);
		lblSituacaoDeSaude.setVerticalAlignment(SwingConstants.BOTTOM);

		// COMBOBOX SITUACAO DE SAUDE //

		comboBoxSituacaoDeSaude = new JComboBox<String>(new String[] { "Contaminado em tratamento",
				"Contaminado falecido", "Contaminado curado", "Sem contaminação" });
		comboBoxSituacaoDeSaude.setSelectedItem(null);
		comboBoxSituacaoDeSaude.setBounds(170, 46, 200, 20);

		// ADICIONA OS COMPONENTES AO PAINEL //

		add(painelSaude);
		painelSaude.add(lblSituacaoDeSaude);
		painelSaude.add(comboBoxSituacaoDeSaude);

	}

	private StringBuilder camposVazios() {

		StringBuilder camposVazios = new StringBuilder("");

		if (txtFieldNome.getText() == null || txtFieldNome.getText().trim().length() == 0)
			camposVazios.append("Nome\n");

		if (!masculino.isSelected() & !feminino.isSelected())
			camposVazios.append("Sexo\n");

		else {
			if (masculino.isSelected()) {
				if (txtFieldIdade.getText() == null || txtFieldIdade.getText().trim().length() == 0)
					camposVazios.append("Idade\n");
			}
			if (feminino.isSelected()) {
				if (comboBoxGravidez.getSelectedItem() == null) {
					camposVazios.append("Já esteve grávida?");
				}
			}

		}

		return camposVazios;

	}

	private void cadastraPessoa() {
		char gravidezPessoa = 'k', situacaoDeSaudePessoa = 'k';

		switch (comboBoxSituacaoDeSaude.getSelectedIndex()) {
		case 0:
			situacaoDeSaudePessoa = 'T';
			break;

		case 1:
			situacaoDeSaudePessoa = 'F';
			break;
		case 2:
			situacaoDeSaudePessoa = 'C';
			break;
		case 3:
			situacaoDeSaudePessoa = 'S';

		}

		if (feminino.isSelected()) {
			switch (comboBoxGravidez.getSelectedIndex()) {
			case 0:
				gravidezPessoa = 'S';
				break;
			case 1:
				gravidezPessoa = 'N';
				break;
			case 2:
				gravidezPessoa = 'T';

			}
			if (!Validacao
					.isRepetida(new Mulher(txtFieldNome.getText().trim(), situacaoDeSaudePessoa, gravidezPessoa))) {
				new PessoaDAO().cadastraPessoa(
						new Mulher(txtFieldNome.getText().trim(), situacaoDeSaudePessoa, gravidezPessoa));
				JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!", "Cadastro",
						JOptionPane.INFORMATION_MESSAGE);
				limpaCampos();
			} else
				JOptionPane.showMessageDialog(this, "Pessoa já cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);

		} else {
			if (!Validacao.isRepetida(new Homem(txtFieldNome.getText(), situacaoDeSaudePessoa,
					Integer.parseInt(txtFieldIdade.getText())))) {

				new PessoaDAO().cadastraPessoa(new Homem(txtFieldNome.getText(), situacaoDeSaudePessoa,
						Integer.parseInt(txtFieldIdade.getText())));
				JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!", "Cadastro",
						JOptionPane.INFORMATION_MESSAGE);
				limpaCampos();

			} else
				JOptionPane.showMessageDialog(this, "Pessoa já cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);

		}

	}

	private void limpaCampos() {
		txtFieldNome.setText("");
		txtFieldIdade.setText("");
		bgSexo.clearSelection();
		comboBoxSituacaoDeSaude.setSelectedItem(null);
		comboBoxGravidez.setSelectedItem(null);
		comboBoxGravidez.setEnabled(false);
		txtFieldIdade.setEnabled(false);
	}

	@Override
	public void itemStateChanged(ItemEvent item) {

		if (item.getSource() == masculino) {
			comboBoxGravidez.setEnabled(false);
			txtFieldIdade.setEnabled(true);

		} else if (item.getSource() == feminino) {
			comboBoxGravidez.setEnabled(true);
			txtFieldIdade.setEnabled(false);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		if (ev.getSource() == btnSalvar) {
			if (camposVazios().length() == 0) {
				try {
					if (Validacao.isNome(txtFieldNome.getText())) {
						if (masculino.isSelected()) {
							if (Validacao.isIdade(Integer.parseInt(txtFieldIdade.getText())))
								cadastraPessoa();
						} else
							cadastraPessoa();
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Digite apenas números na idade.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

			} else
				JOptionPane.showMessageDialog(this, "Os seguintes campos foram deixados em branco:\n" + camposVazios(),
						"Erro", JOptionPane.WARNING_MESSAGE);

		} else if (ev.getSource() == btnLimpar) {
			limpaCampos();

		}

	}
}
