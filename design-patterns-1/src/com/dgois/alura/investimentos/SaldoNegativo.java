package com.dgois.alura.investimentos;

public class SaldoNegativo implements EstadoConta {

	@Override
	public Conta deposita(Conta conta, double valor) {
		double novoSaldo = conta.getSaldo() + valor * .95;
		if (novoSaldo > 0) {
			return new Conta(conta, new SaldoPositivo(), novoSaldo);
		} else {
			return new Conta(conta, new SaldoNegativo(), novoSaldo);
		}
	}

	@Override
	public Conta saca(Conta conta, double valor) {
		throw new RuntimeException("Conta com saldo negativo não é permitido realizar saques");
	}

}
