package com.dgois.alura.investimentos;

import java.util.Random;

public class EstrategiaModerada implements EstrategiaDeInvestimento {

	@Override
	public double investir(double saldo) {
		double chances = new Random().nextDouble();
		System.out.println("Chances: " + chances * 100.0);
		if (chances > 0.5) {
			return saldo * 0.025;
		} else {
			return saldo * 0.007;
		}
	}

}
