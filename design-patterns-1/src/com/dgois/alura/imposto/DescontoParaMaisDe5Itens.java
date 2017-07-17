package com.dgois.alura.imposto;

public class DescontoParaMaisDe5Itens implements Desconto {
	
	private Desconto proximo;

	@Override
	public double calcula(Orcamento orcamento) {
		if(orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		} 
		
		return proximo.calcula(orcamento);
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;
	}
}
