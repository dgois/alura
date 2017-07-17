package com.dgois.alura.imposto.tipos;

import com.dgois.alura.imposto.Orcamento;

public class ICMS extends Imposto {
	
	public ICMS() {
	}

	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}
}
