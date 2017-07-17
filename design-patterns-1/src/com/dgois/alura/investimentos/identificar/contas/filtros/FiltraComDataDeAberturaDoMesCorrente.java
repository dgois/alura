package com.dgois.alura.investimentos.identificar.contas.filtros;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.dgois.alura.investimentos.Conta;

public class FiltraComDataDeAberturaDoMesCorrente extends Filtro {
	
	public FiltraComDataDeAberturaDoMesCorrente() {
	}
	
	public FiltraComDataDeAberturaDoMesCorrente(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtradas = contas.stream().filter(aberturaNoMesmoMes()).collect(Collectors.toList());
		
		filtradas.addAll(chamarOutroFiltroSeExistir(contas));
		
		return filtradas;
	}

	private Predicate<? super Conta> aberturaNoMesmoMes() {
		return c -> YearMonth.from(c.getDataAbertura()).equals(YearMonth.now());
	}

}
