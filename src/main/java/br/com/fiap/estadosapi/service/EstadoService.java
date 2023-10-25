package br.com.fiap.estadosapi.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.estadosapi.data.EstadoDao;
import br.com.fiap.estadosapi.model.Estado;

public class EstadoService {
	
	EstadoDao dao = new EstadoDao();
	
	public List<Estado> findAll(){
		try {
			List<Estado> lista = dao.findAll();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Estado findById(Long id) {
		try {
			return dao.findById(id);
		} catch (SQLException e) {}
		return null;
	}

	public void delete(Estado estado) {
		try {
			dao.delete(estado);
		} catch (SQLException e) {}
	}
}
