package br.com.fiap.seriesapi.service;

import java.util.List;

import br.com.fiap.seriesapi.data.EstadoDao;
import br.com.fiap.seriesapi.model.Estado;

public class EstadoService {
	
	EstadoDao dao = new EstadoDao();
	
	public List<Estado> findAll(){
		return dao.findAll();
	}
}
