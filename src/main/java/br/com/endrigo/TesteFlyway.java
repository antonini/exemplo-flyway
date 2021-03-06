package br.com.endrigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.googlecode.flyway.core.Flyway;

/**
 * Aplicacao criada para efetuar teste com a ferramenta FlyWay.<br/>
 * Seu objetivo e de atuar como ferramenta complementar ao artigo cujo titulo e
 * "Utilizacao da ferramenta FlyWay para gerir e aplicar atualizacoes de banco de dados"
 * <br/>
 * <br/>
 * <b>Importante:</b> Os comentarios estao sem acentuacao para evitar problemas
 * com plataformas de encoding entre plataformas (OSX, Linux e Windows).
 * 
 * @author eantonini
 */
public class TesteFlyway {

	// private static final String DB_DRIVER = "org.postgresql.Driver";
	// private static final String DB_URL_CONNECTION =
	// "jdbc:postgresql://localhost/flyway";
	// private static final String DB_USER = "flyway";
	// private static final String DB_PASSWORD = "flyway";

	/**
	 * Driver de conexao ao banco de dados.
	 */
	private static final String DB_DRIVER = "org.h2.Driver";
	/**
	 * URL de acesso ao banco de dados.
	 */
	private static final String DB_URL_CONNECTION = "jdbc:h2:file:target/exemplo-flyway";
	/**
	 * Usuario de acesso ao banco de dados.
	 */
	private static final String DB_USER = "sa";
	/**
	 * Senha de acesso ao banco de dados.
	 */
	private static final String DB_PASSWORD = null;

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		// Instancia o Flyway.
		Flyway flyway = new Flyway();

		// Atribui as informacoes de conectividade a ferramenta.
		flyway.setDataSource(DB_URL_CONNECTION, DB_USER, DB_PASSWORD);

		// Executa processo de validacao.
		flyway.migrate();

		// Executa o metodo que ira exibir as pessoas encontradas no banco de
		// dados.
		exibePessoas();
	}

	/**
	 * Busca as pessoas na base de dados e exibe as mesmas atraves do console de
	 * saida padrao.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void exibePessoas() throws ClassNotFoundException,
			SQLException {
		Class.forName(DB_DRIVER);
		Connection connection = null;
		connection = DriverManager.getConnection(DB_URL_CONNECTION, DB_USER,
				DB_PASSWORD);

		PreparedStatement ps = connection
				.prepareStatement("SELECT CHAVE, NOME, SOBRENOME FROM PESSOA ORDER BY CHAVE ASC");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print("Chave: ");
			System.out.print(rs.getInt("CHAVE"));
			System.out.print(", Nome: ");
			System.out.print(rs.getString("NOME"));
			System.out.print(", Sobrenome: ");
			System.out.println(rs.getString("SOBRENOME"));
		}

		connection.close();

	}
}
