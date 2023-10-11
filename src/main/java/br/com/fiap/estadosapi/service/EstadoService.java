package br.com.fiap.estadosapi.service;

import java.util.List;

import br.com.fiap.estadosapi.data.EstadoDao;
import br.com.fiap.estadosapi.model.Estado;

public class EstadoService {
	
	EstadoDao dao = new EstadoDao();
	
	public List<Estado> findAll(){
		return dao.findAll();
	}
}
