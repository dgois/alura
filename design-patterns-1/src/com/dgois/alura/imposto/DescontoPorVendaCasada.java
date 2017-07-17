package com.dgois.alura.imposto;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double calcula(Orcamento orcamento) {
		if (aconteceuVendaCasada(orcamento)) {
			return orcamento.getValor() * 0.05;
		}
		return proximo.calcula(orcamento);
	}

	private boolean aconteceuVendaCasada(Orcamento orcamento) {
		return orcamento.existeItem("LAPIS") && orcamento.existeItem("CANETA");
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;
	}

}
