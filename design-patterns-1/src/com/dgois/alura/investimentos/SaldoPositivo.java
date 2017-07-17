package com.dgois.alura.investimentos;

public class SaldoPositivo implements EstadoConta {

	@Override
	public Conta deposita(Conta conta, double valor) {
		return new Conta(conta, new SaldoPositivo(), conta.getSaldo() + valor * .98);
	}

	@Override
	public Conta saca(Conta conta, double valor) {
		double novoSaldo = conta.getSaldo() - valor;
		if (novoSaldo < 0) {
			return new Conta(conta, new SaldoNegativo(), novoSaldo);
		} else {
			return new Conta(conta, new SaldoPositivo(), novoSaldo);
		}
	}

}
