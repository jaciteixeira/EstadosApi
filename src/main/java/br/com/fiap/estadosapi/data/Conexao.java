package br.com.fiap.estadosapi.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private final static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private final static String USER = "rm99627";
	private final static String PASS = "051298";
	
	public static Connection createConnection() throws SQLException, ClassNotFoundException{
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Fact: " + conexao);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return conexao;
    }
}
