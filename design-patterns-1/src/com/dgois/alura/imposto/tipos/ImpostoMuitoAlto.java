package com.dgois.alura.imposto.tipos;

import com.dgois.alura.imposto.Orcamento;

public class ImpostoMuitoAlto extends Imposto {
	
	public ImpostoMuitoAlto() {
	}
	
	public ImpostoMuitoAlto(Imposto outroImposto) {
		super(outroImposto);
	}
	
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.20 + calculoDoOutroImposto(orcamento);
	}

}
