package br.com.fiap.estadosapi;

import java.util.List;

import br.com.fiap.estadosapi.model.Estado;
import br.com.fiap.estadosapi.service.EstadoService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("estados")
public class EstadoResource {
	
	EstadoService service = new EstadoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> index() {
		return service.findAll();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") Long id){
		var estado = service.findById(id);
		if(estado == null) return Response.status(Response.Status.NOT_FOUND).build();
		
		return Response.ok(estado).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		var estado = service.findById(id);
		if(estado == null) return Response.status(Response.Status.NOT_FOUND).build();
		service.delete(estado);
		return Response.noContent().build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Estado estado) {
		if (!service.create(estado)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(estado).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") Long id, Estado estado) {
		var estadoEncontrado = service.findById(id);
		if (estadoEncontrado == null) return Response.status(Response.Status.NOT_FOUND).build();
		if(!service.update(estado)) return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.ok(estado).build();
	}

}
