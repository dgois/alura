package com.dgois.alura.investimentos.identificar.contas.filtros;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.dgois.alura.investimentos.Conta;

public abstract class Filtro {
	
	private final Filtro outroFiltro;
	
	public Filtro() {
		outroFiltro = null;
	}

	public Filtro(Filtro outroFiltro) {
		this.outroFiltro = outroFiltro;
	}
	
	public abstract List<Conta> filtra(List<Conta> contas);
	
	public List<Conta> chamarOutroFiltroSeExistir(List<Conta> contas) {
		if (outroFiltro != null) {
			return outroFiltro
					.filtra(contas)
					.stream()
					.distinct()
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
