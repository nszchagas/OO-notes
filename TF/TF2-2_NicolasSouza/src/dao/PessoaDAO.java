package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dados.Homem;
import dados.Mulher;
import dados.Pessoa;

public class PessoaDAO {
	private Connection con;

	public PessoaDAO() {
		try {
			String usuario = "root";
			String senha = "rootpass";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/?useTimezone=true&serverTimezone=UTC&useSSL=false", usuario, senha);

		} catch (SQLException e) {
			System.out.println("Sem conectar!\n" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Falha na Conexão!\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void criaBD() {
		// CRIA O BANCO DE DADOS E A TABELA
		try {
			con.prepareStatement("CREATE DATABASE IF NOT EXISTS pandemia").execute();
			Statement st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS PANDEMIA.pessoa ("
					+ "  idPessoa INT                   NOT NULL AUTO_INCREMENT,"
					+ "	nome     VARCHAR(90)           NOT NULL," + "  saude    ENUM('T','F','C','S') NOT NULL,"
					+ "	gestante ENUM('S','N','T')     DEFAULT NULL," + "  idade    INT                   DEFAULT NULL,"
					+ " CONSTRAINT PESSOA_PK PRIMARY KEY (idPessoa)" + ")ENGINE InnoDB AUTO_INCREMENT = 101");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cadastraMulher(Mulher usuario) {
		String sql = "INSERT INTO pandemia.pessoa (nome, saude, gestante, idade) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSituacaoDeSaude().toString());
			preparador.setString(3, usuario.getSituacaoGestante().toString());
			preparador.setString(4, null);
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa: " + e.getMessage());
				}
		}
	}

	public void cadastraHomem(Homem usuario) {
		String sql = "INSERT INTO pandemia.pessoa (nome, saude, gestante, idade) VALUES (?, ?, ?, ?)";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSituacaoDeSaude().toString());
			preparador.setString(3, null);
			preparador.setInt(4, usuario.getIdade());
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa: " + e.getMessage());
				}
		}
	}

	public Vector<Pessoa> getPessoas() {
		Vector<Pessoa> pessoas = new Vector<Pessoa>();
		String query = "SELECT * FROM pandemia.pessoa";

		Statement stm;
		ResultSet rs;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(query);

			while (rs.next()) {
				if (rs.getString("gestante") == null) {
					pessoas.add(new Homem(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0),
							rs.getInt("idade")));
				} else {
					pessoas.add(new Mulher(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0),
							rs.getString("gestante").charAt(0)));
				}
			}
		} catch (Exception e) {
			System.out.println("Erro: ");
			e.printStackTrace();

		}
		return pessoas;
	}

	public Pessoa getPessoa(int id) {

		String sql = "SELECT * FROM pandemia.pessoa WHERE idPessoa = " + id;
		Pessoa pes = null;
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);

			if (rs.next()) {

				if (rs.getString("gestante") == null)
					pes = new Homem(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0),
							Integer.valueOf(rs.getString("idade")));
				else
					pes = new Mulher(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0),
							rs.getString("gestante").charAt(0));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				System.out.print("Falha ao fechar a conexão.");
				System.out.println("Causa: " + e.getMessage());
			}
		}
		return pes;
	}

	public Vector<Pessoa> pesquisaPorNome(String nome) {
		Vector<Pessoa> pessoas = new Vector<Pessoa>();
		String sql = "SELECT * FROM pandemia.pessoa WHERE nome LIKE '%" + nome + "%'";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {

				if (rs.getString("gestante") == null)
					pessoas.add(new Homem(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0),
							Integer.valueOf(rs.getString("idade"))));
				else
					pessoas.add(new Mulher(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("saude").charAt(0),
							rs.getString("gestante").charAt(0)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();

				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa: " + e.getMessage());

				}
		}

		return pessoas;
	}

	public int getQtdSituacao(char situacao) {
		int contador = 0;

		String sql = "SELECT * FROM pandemia.pessoa WHERE saude = '" + situacao + "'";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);

			while (rs.next())
				contador++;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.print("Falha ao fechar a conexão.");
				System.out.println("Causa: " + e.getMessage());
			}
		}

		return contador;
	}

	public int getQtdSituacao(char situacao, char sexo) {
		int contador = 0;

		String sql = "SELECT * FROM pandemia.pessoa WHERE saude = '" + situacao + "'";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);

			while (rs.next()) {
				switch (sexo) {
				case 'F':
					if (rs.getString("gestante") != null)
						contador++;
					break;
				case 'M':
					if (rs.getString("gestante") == null)
						contador++;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.print("Falha ao fechar a conexão.");
				System.out.println("Causa: " + e.getMessage());
			}
		}

		return contador;
	}

}
