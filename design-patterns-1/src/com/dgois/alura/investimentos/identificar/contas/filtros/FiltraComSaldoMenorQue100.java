package com.dgois.alura.investimentos.identificar.contas.filtros;

import java.util.List;
import java.util.stream.Collectors;

import com.dgois.alura.investimentos.Conta;

public class FiltraComSaldoMenorQue100 extends Filtro {
	
	public FiltraComSaldoMenorQue100() {
	}

	public FiltraComSaldoMenorQue100(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtradas = contas.stream()
		.filter(c -> c.getSaldo() < 100)
		.collect(Collectors.toList());
		
		filtradas.addAll(chamarOutroFiltroSeExistir(contas));

		return filtradas;
	}

}
