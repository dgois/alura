package com.dgois.alura.investimentos.identificar.contas.filtros;

import java.util.List;
import java.util.stream.Collectors;

import com.dgois.alura.investimentos.Conta;

public class FiltraComSaldoMaiorQue500Mil extends Filtro {
	
	public FiltraComSaldoMaiorQue500Mil() {
	}

	public FiltraComSaldoMaiorQue500Mil(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtradas = contas.stream()
		.filter(c -> c.getSaldo() > 500000.0)
		.collect(Collectors.toList());
		
		filtradas.addAll(chamarOutroFiltroSeExistir(contas));
		
		return filtradas; 
	}

}
