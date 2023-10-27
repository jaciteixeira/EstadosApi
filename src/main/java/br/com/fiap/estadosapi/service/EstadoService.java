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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Estado findById(Long id) {
		try {
			return dao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(Estado estado) {
		try {
			dao.delete(estado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(Estado estado) {
		if (!validar(estado)) return false;
		try {
			dao.create(estado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private boolean validar(Estado estado) {
		if (estado.nome().isEmpty()) return false;
		if (estado.sigla().isEmpty()||estado.sigla().length() != 2) return false;
		if (estado.regiao().isEmpty()) return false;
		if (estado.capital().isEmpty()) return false;
		if (estado.territorio() < 0) return false;
		
		return true;
	}

	public boolean update(Estado estado) {
		if (!validar(estado)) return false;
		try {
			dao.update(estado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
