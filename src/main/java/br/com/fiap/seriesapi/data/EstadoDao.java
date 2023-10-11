package br.com.fiap.seriesapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.seriesapi.model.Estado;

public class EstadoDao {

	List<Estado> estados = new ArrayList<>();
	
	public EstadoDao() {
		var acre = new Estado(
				1L,
				"Acre", 
				"AC", 
				"Região Norte",
				"Rio Branco",
				164123738
			);

		var alagoas = new Estado(
				2L,
				"Alagoas",
				"AL",
				"Nordeste",
				"Maceió",
				27848
			);

		var amapa = new Estado(
				3L,
				"amapa", 
				"ap", 
				"Região Norte",
				"Macapa",
				142828
			);
		
		var amazonas = new Estado(
				4L,
				"amazonas", 
				"AM", 
				"Região Norte",
				"Manaus",
				1559146
			);

		

		
		estados.add(acre);
		estados.add(alagoas);
		estados.add(amapa);
		estados.add(amazonas);
	}

	public List<Estado> findAll() {
		return estados;
	}

}
