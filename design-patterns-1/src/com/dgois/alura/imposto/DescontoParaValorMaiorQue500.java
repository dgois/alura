package com.dgois.alura.imposto;

public class DescontoParaValorMaiorQue500 implements Desconto {
	
	private Desconto proximo;

	@Override
	public double calcula(Orcamento orcamento) {
		if (orcamento.getValor() > 500.0) {
			return orcamento.getValor() * 0.07;
		}
		
		return proximo.calcula(orcamento);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
