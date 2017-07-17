package com.dgois.alura.imposto.tipos;

import java.util.HashSet;
import java.util.Set;

import com.dgois.alura.imposto.Item;
import com.dgois.alura.imposto.Orcamento;

public class IHIT extends TemplateDeImpostoCondicional {
	
	public IHIT() {
	}

	public IHIT(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * (0.01 * orcamento.getItens().size());
	}

	@Override
	double maximaTaxacao(Orcamento orcamento) {
		return (orcamento.getValor() * 0.13) + 100;
	}

	@Override
	boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
		return temItensRepetidosNo(orcamento);
	}

	private boolean temItensRepetidosNo(Orcamento orcamento) {
		Set<String> verificarRepetidos = new HashSet<>();
		for (Item item : orcamento.getItens()) {
			if (!verificarRepetidos.add(item.getNome().toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
