package com.dgois.alura.imposto;

import com.dgois.alura.imposto.tipos.Imposto;

public class CalculadorDeImpostos {
	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valor = imposto.calcula(orcamento);
		System.out.println(valor);
	}
}
