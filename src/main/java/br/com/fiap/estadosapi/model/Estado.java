package br.com.fiap.estadosapi.model;

public record Estado(
		Long id,
		String nome,
		String sigla,
		String regiao,
		String capital,
		Integer territorio) {

}

