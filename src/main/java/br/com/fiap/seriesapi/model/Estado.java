package br.com.fiap.seriesapi.model;

public record Estado(
		Long id,
		String estado,
		String sigla,
		String regiao,
		String capital,
		Integer territorio) {}

