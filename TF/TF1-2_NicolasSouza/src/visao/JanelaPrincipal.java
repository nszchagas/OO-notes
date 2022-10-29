package visao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dados.Populacao;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame implements ActionListener {

	Container contem = getContentPane();
	JPanel painelPrincipal;
	JPanel painelBotoes;
	JPanel painelOpcaoEscolhida;
	JButton btnNovo, btnLista, btnMostra, btnPesquisa, btnSair;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image icon = kit.getImage("imagens/corona.png");
	Populacao populacao;

	public JanelaPrincipal(Populacao populacao) {
		this.populacao = populacao;

		// configura frame
		setResizable(false);
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Controle de contaminados - Corona vírus");
		setIconImage(icon);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent ev) {
				fechaJanela();

			}
		});

		painelPrincipal = new JPanel(new GridLayout(2, 1, 10, 10));
		configuraBotoes();
		contem.add(painelPrincipal);

		painelPrincipal.add(painelBotoes);

	}

	private void configuraBotoes() {
		btnNovo = new JButton("Novo");
		btnNovo.setToolTipText("Efetua novo cadastro.");
		btnNovo.addActionListener(this);
		btnNovo.setPreferredSize(new Dimension(30, 30));

		btnLista = new JButton("Lista");
		btnLista.addActionListener(this);
		btnLista.setToolTipText("Lista todas as pessoas cadastradas.");

		btnMostra = new JButton("Mostra");
		btnMostra.addActionListener(this);
		btnMostra.setToolTipText("Busca pessoa cadastrada por identificador.");
		btnMostra.setEnabled(false); // desabilitado até programá-lo

		btnSair = new JButton("Sair");
		btnSair.setToolTipText("Encerra a aplicação.");
		btnSair.addActionListener(this);

		btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setToolTipText("Pesquisa pessoa no banco de dados pelo nome.");
		btnPesquisa.addActionListener(this);
		btnPesquisa.setEnabled(false); // desabilitado até programá-lo

		painelBotoes = new JPanel(new GridLayout(1, 3, 10, 30));
		painelBotoes.add(btnNovo);
		painelBotoes.add(btnLista);
		painelBotoes.add(btnMostra);
		painelBotoes.add(btnPesquisa);
		painelBotoes.add(btnSair);

	}

	private void fechaJanela() {
		if (JOptionPane.showConfirmDialog(this, "Deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null) == 0) {
			Visao.mostraDados(populacao);
			System.exit(0);
		}
		// TODO
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btnNovo) {
			painelOpcaoEscolhida = new PainelCadastro(populacao);
			painelOpcaoEscolhida.setVisible(true);
			painelPrincipal.add(painelOpcaoEscolhida);
			pack();

			// TODO faz aba receber cadastro nova pessoa
		} else if (ev.getSource() == btnLista) {
			Visao.mostraTabela(populacao.getPopulacao());

		} else if (ev.getSource() == btnMostra) {

			// TODO faz aba receber busca por pessoa
		}

		else if (ev.getSource() == btnPesquisa) {
			// TODO faz aba de pesquisa
		} else if (ev.getSource() == btnSair) {
			fechaJanela();
		}

		// TODO Auto-generated method stub

	}
}
