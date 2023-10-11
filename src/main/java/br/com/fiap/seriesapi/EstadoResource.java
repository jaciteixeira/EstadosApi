package br.com.fiap.seriesapi;

import java.util.List;

import br.com.fiap.seriesapi.model.Estado;
import br.com.fiap.seriesapi.service.EstadoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("estados")
public class EstadoResource {
	
	EstadoService service = new EstadoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> index() {
		return service.findAll();
	}
}
