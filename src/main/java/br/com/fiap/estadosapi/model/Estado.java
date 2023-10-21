package br.com.fiap.estadosapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public record Estado(
		Long id,
		String nome,
		String sigla,
		String regiao,
		String capital,
		Integer territorio) {

}

