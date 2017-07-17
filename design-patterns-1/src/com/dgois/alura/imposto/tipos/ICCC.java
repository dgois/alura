package com.dgois.alura.imposto.tipos;

import com.dgois.alura.imposto.Orcamento;

public class ICCC extends Imposto {
	
	public ICCC() {
	}

	public ICCC(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		final double valor = orcamento.getValor();
		if (valor < 1000.0) {
			return valor * 0.05;
		} else if (valor <= 3000.0) {
			return valor * 0.07;
		} else {
			return (valor * 0.08) + 30.0;
		}
	}
}
