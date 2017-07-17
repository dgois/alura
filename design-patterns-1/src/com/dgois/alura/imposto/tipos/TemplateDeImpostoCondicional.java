package com.dgois.alura.imposto.tipos;

import com.dgois.alura.imposto.Orcamento;

public abstract class TemplateDeImpostoCondicional extends Imposto {
	
	public TemplateDeImpostoCondicional() {
	}

	public TemplateDeImpostoCondicional(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public final double calcula(Orcamento orcamento) {
		if (deveUsarTaxacaoMaxima(orcamento)) {
			return maximaTaxacao(orcamento);
		} else {
			return minimaTaxacao(orcamento);
		}
	}

	abstract double minimaTaxacao(Orcamento orcamento);

	abstract double maximaTaxacao(Orcamento orcamento);

	abstract boolean deveUsarTaxacaoMaxima(Orcamento orcamento);

}
