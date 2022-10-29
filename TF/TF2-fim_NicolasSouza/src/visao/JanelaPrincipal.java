package visao;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	public JanelaPrincipal() {

		// CONFIGURAÇÕES DA JANELA

		setResizable(false);
		setBounds(100, 100, 667, 453);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Controle de contaminados - Corona vírus");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagens/corona.png"));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent ev) {
				fechaJanela();
			}
		});

		// CCONFIGURAÇÃO DO PAINEL
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(null);

		// CONFIGURAÇÃO DO PAINEL DE ABAS
		JTabbedPane painelAbas = new JTabbedPane(JTabbedPane.TOP);
		painelAbas.setBounds(10, 11, 625, 354);

		painelAbas.add(new PainelNovo(), "Novo");
		painelAbas.add(new PainelLista(), "Lista");
		painelAbas.add(new PainelMostra(), "Mostra");
		painelAbas.add(new PainelPesquisa(), "Pesquisa");
		
		painelAbas.setToolTipTextAt(0, "Cadastro de pacientes.");
		painelAbas.setToolTipTextAt(1, "Relação de pacientes cadastrados.");
		painelAbas.setToolTipTextAt(2, "Pesquisa de paciente por ID.");
		painelAbas.setToolTipTextAt(3, "Pesquisa de paciente por nome.");



		

		// CONFIGURAÇÃO DO BOTÃO SAIR

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(534, 376, 101, 23);
		btnSair.setIcon(new ImageIcon("imagens/sair.png"));
		painelPrincipal.add(btnSair);
		btnSair.setToolTipText("Encerra a aplicação.");
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fechaJanela();
			}
		});

		// ADICIONA OS COMPONENTES

		painelPrincipal.add(painelAbas);
		getContentPane().add(painelPrincipal);

	}

	private void fechaJanela() {
		if (JOptionPane.showConfirmDialog(this, "Deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null) == 0) {
			Visao.mostraDados();
			System.exit(0);
		}

	}

}
