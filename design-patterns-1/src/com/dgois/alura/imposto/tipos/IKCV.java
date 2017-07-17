package com.dgois.alura.imposto.tipos;

import com.dgois.alura.imposto.Item;
import com.dgois.alura.imposto.Orcamento;

public class IKCV extends TemplateDeImpostoCondicional {

	public IKCV() {
	}
	
	public IKCV(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

	@Override
	protected boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento);
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		return orcamento.getItens().stream().map(Item::getValor).anyMatch(valor -> valor > 100);
	}
}
