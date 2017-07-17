package com.dgois.alura.imposto;

public class SemDesconto implements Desconto {

	@Override
	public double calcula(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto desconto) {
		// nao tem mais
		
	}
}
