package com.dgois.alura.imposto.tipos;

import com.dgois.alura.imposto.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional {
	
	public ICPP() {
	}

	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}
}
