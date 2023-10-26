package br.com.fiap.estadosapi.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.estadosapi.model.Estado;

public class EstadoDao {

	private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private final String USER = "rm99627";
	private final String PASS = "051298";
	
	List<Estado> estados = new ArrayList<>();

	public List<Estado> findAll() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		var con = DriverManager.getConnection(URL, USER, PASS);
		var rs = con.createStatement().executeQuery("SELECT * FROM estados");

		while(rs.next()) {
			estados.add(new Estado(
							rs.getLong("id"),
							rs.getString("nome"),
							rs.getString("sigla"),
							rs.getString("regiao"),
							rs.getString("capital"),
							rs.getInt("territorio")
					)
			);
		}
		con.close();
		return estados;
	}
	
	public Estado findById(Long id) throws SQLException{
		Estado estado = null;
		
		var con = DriverManager.getConnection(URL, USER, PASS);
        var sql = "SELECT * FROM estados WHERE id = ?";
        var stmt = con.prepareStatement(sql);
        stmt.setLong(1, id);
        
        var rs = stmt.executeQuery();

        while (rs.next()) {
            estado = new Estado(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("sigla"),
                rs.getString("regiao"),
                rs.getString("capital"),
                rs.getInt("territorio")
            );
        }

		con.close();
		return estado;

	}

	public void delete(Estado estado) throws SQLException {
		var con = DriverManager.getConnection(URL, USER, PASS);
        var ps = con.prepareStatement("DELETE FROM estados WHERE id=?"); 
        ps.setLong(1, estado.id());
        ps.executeUpdate();
        con.close();
	}

	public void create(Estado estado) throws SQLException {
		var con = DriverManager.getConnection(URL, USER, PASS);
        var ps = con.prepareStatement("INSERT INTO estados ( nome, sigla, regiao, capital, territorio)"
        		+ "VALUES ( ?, ?, ?, ?, ?)"); 
        ps.setString(1, estado.nome());
        ps.setString(2, estado.sigla());
        ps.setString(3, estado.regiao());
        ps.setString(4, estado.capital());
        ps.setInt(5, estado.territorio());
        ps.executeUpdate();
        con.close();
	}

	public void update(Estado estado) throws SQLException {
		var con = DriverManager.getConnection(URL, USER, PASS);
        var ps = con.prepareStatement("UPDATE estados SET nome=?, sigla=?, regiao=?, capital=?, territorio=? WHERE id=?"); 
        ps.setString(1, estado.nome());
        ps.setString(2, estado.sigla());
        ps.setString(3, estado.regiao());
        ps.setString(4, estado.capital());
        ps.setInt(5, estado.territorio());
        ps.setLong(6, estado.id());
        ps.executeUpdate();
        con.close();
	}

}
