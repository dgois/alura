package com.dgois.alura.imposto.tipos;

import com.dgois.alura.imposto.Orcamento;

public abstract class Imposto {
	
	private final Imposto outroImposto;
	
	public Imposto() {
		this.outroImposto = null;
	}
	
	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}
	
	public abstract double calcula(Orcamento orcamento);
	
	protected double calculoDoOutroImposto(Orcamento orcamento) {
		return outroImposto != null ? outroImposto.calcula(orcamento) : 0;
	}

}
