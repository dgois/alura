package com.dgois.alura.investimentos;

import java.util.Random;

public class EstrategiaArrojada implements EstrategiaDeInvestimento {

	@Override
	public double investir(double saldo) {
		double chances = new Random().nextDouble();
		if (chances <= 0.2) {
			return saldo * 0.05;
		} else if (chances <= 0.3) {
			return saldo * 0.03;
		} else {
			return saldo * 0.006;
		}
	}

}
