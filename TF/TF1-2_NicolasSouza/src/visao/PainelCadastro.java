package visao;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dados.Homem;
import dados.Mulher;
import dados.Populacao;
import validacao.Validacao;

@SuppressWarnings("serial")
public class PainelCadastro extends JPanel implements ActionListener, ItemListener {

	JButton btnSalvar, btnLimpar, btnCancelar;
	JTextField nome, idade;
	ButtonGroup bgSexo;
	JRadioButton masculino, feminino;
	JPanel painelBotoes, painelNome, painelSexo, painelSituacaoSaude, painelIdade, painelGravidez;
	JPanel painelEspecificacao;
	JPanel especificacao = new JPanel();
	JComboBox<String> gravidez;
	JComboBox<String> situacaoDeSaude;
	JLabel lblEspecificacao = new JLabel("");
	private Populacao populacao;

	public PainelCadastro(Populacao populacao) {
		configuraCamposTexto();
		configuraBotoes();
		configuraCampoSexo();
		configuraSituacaoSaude();
		configuraIdade();
		configuraGravidez();
		this.populacao = populacao;

		setLayout(new GridLayout(6, 1, 5, 5));
		add(painelNome);
		add(painelSituacaoSaude);
		add(painelSexo);
		add(painelIdade);
		add(painelGravidez);
		add(painelBotoes);

	}

	private void configuraSituacaoSaude() {
		painelSituacaoSaude = new JPanel(new GridLayout(1, 2));
		painelSituacaoSaude.add(new JLabel("Situacao de saude:"));
		situacaoDeSaude = new JComboBox<String>(new String[] { "Contaminado em tratamento", "Contaminado falecido",
				"Contaminado curado", "Sem contaminação" });
		situacaoDeSaude.setSelectedItem(null);
		painelSituacaoSaude.add(situacaoDeSaude);

	}

	private void configuraCamposTexto() {
		nome = new JTextField();
		nome.setSize(new Dimension(400, 30));
		painelNome = new JPanel(new GridLayout(1, 2));
		painelNome.add(new JLabel("Nome"));
		painelNome.add(nome);

	}

	private void configuraCampoSexo() {
		masculino = new JRadioButton("Masculino");
		masculino.setSelected(false);
		masculino.addItemListener(this);

		feminino = new JRadioButton("Feminino");
		feminino.setSelected(false);
		feminino.addItemListener(this);

		bgSexo = new ButtonGroup();

		painelSexo = new JPanel(new GridLayout(1, 2));
		JPanel painelBotoes = new JPanel(new GridLayout(1, 2));

		bgSexo.add(masculino);
		bgSexo.add(feminino);

		painelBotoes.add(masculino);
		painelBotoes.add(feminino);

		painelSexo.add(new JLabel("Sexo"));
		painelSexo.add(painelBotoes);

	}

	private void configuraBotoes() {

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setToolTipText("Salva o cadastro");

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		btnLimpar.setToolTipText("Limpa todos os campos sem salvar o cadastro");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setToolTipText("Fecha a aba sem salvar o cadastro");

		painelBotoes = new JPanel(new GridLayout(1, 3, 10, 10));
		painelBotoes.add(btnSalvar);
		painelBotoes.add(btnLimpar);
		painelBotoes.add(btnCancelar);

	}

	private void configuraIdade() {
		painelIdade = new JPanel(new GridLayout(1, 2));
		painelIdade.add(new JLabel("Digite a idade:"));

		idade = new JTextField();
		idade.setPreferredSize(new Dimension(40, 30));
		idade.setEnabled(false);
		painelIdade.add(idade);
	}

	private boolean isPreenchido() {

		if (nome.getText() == null || nome.getText().length() == 0 || !(masculino.isSelected() || feminino.isSelected())
				|| situacaoDeSaude.getSelectedItem() == null) {
			return false;

		} else if (masculino.isSelected()) {
			if (idade.getText() == null || idade.getText().length() == 0)
				return false;

		} else if (feminino.isSelected()) {
			if (gravidez.getSelectedItem() == null)
				return false;

		}
		return true;

	}

	private void cadastraPessoa() {
		char gravidezPessoa = 'k', situacaoDeSaudePessoa = 'k';

		switch (situacaoDeSaude.getSelectedIndex()) {
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
			switch (gravidez.getSelectedIndex()) {
			case 0:
				gravidezPessoa = 'S';
				break;
			case 1:
				gravidezPessoa = 'N';
				break;
			case 2:
				gravidezPessoa = 'T';

			}
			populacao.addPessoa(new Mulher(nome.getText(), situacaoDeSaudePessoa, gravidezPessoa));
			JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!", "Cadastro",
					JOptionPane.INFORMATION_MESSAGE);
			limpaCampos();

		} else {
			populacao.addPessoa(new Homem(nome.getText(), situacaoDeSaudePessoa, Integer.parseInt(idade.getText())));
			JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!", "Cadastro",
					JOptionPane.INFORMATION_MESSAGE);
			limpaCampos();

		}

	}

	private void configuraGravidez() {

		painelGravidez = new JPanel(new GridLayout(1, 2));
		gravidez = new JComboBox<String>(new String[] { "Sim", "Não", "Não tem certeza" });
		gravidez.setEnabled(false);

		gravidez.setSelectedItem(null);
		painelGravidez.add(new JLabel("Já esteve grávida?"));
		painelGravidez.add(gravidez);

	}

	private void limpaCampos() {
		nome.setText("");
		idade.setText("");
		bgSexo.clearSelection();
		situacaoDeSaude.setSelectedItem(null);
		gravidez.setSelectedItem(null);
		gravidez.setEnabled(false);
		idade.setEnabled(false);
	}

	@Override
	public void itemStateChanged(ItemEvent item) {

		if (item.getSource() == masculino) {
			gravidez.setEnabled(false);
			idade.setEnabled(true);

		} else if (item.getSource() == feminino) {
			gravidez.setEnabled(true);
			idade.setEnabled(false);
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
			if (isPreenchido()) {
				try {
					if (Validacao.isNome(nome.getText())) {
						if (masculino.isSelected()) {
							if (Validacao.isIdade(Integer.parseInt(idade.getText())))
								cadastraPessoa();
						} else
							cadastraPessoa();
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Digite apenas números na idade.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

			} else
				JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro",
						JOptionPane.WARNING_MESSAGE);

		} else if (ev.getSource() == btnLimpar) {
			limpaCampos();

		} else if (ev.getSource() == btnCancelar) {
			if (JOptionPane.showConfirmDialog(this, "Deseja mesmo cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null) == 0)
				setVisible(false);
		}

	}
}
