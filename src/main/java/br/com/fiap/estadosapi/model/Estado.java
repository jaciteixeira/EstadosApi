package br.com.fiap.estadosapi.model;

public record Estado(
		Long id,
		String estado,
		String sigla,
		String regiao,
		String capital,
		Integer territorio) {}

