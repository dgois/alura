package com.dgois.alura.investimentos;

public class EstrategiaConservadora implements EstrategiaDeInvestimento {

	@Override
	public double investir(double saldo) {
		return saldo * 0.008;
	}

}
