package com.dgois.alura.investimentos;

public class RealizadorDeInvestimentos {
	
	private EstrategiaDeInvestimento estrategiaDeInvestimento;

	public RealizadorDeInvestimentos(EstrategiaDeInvestimento estrategiaDeInvestimento) {
		this.estrategiaDeInvestimento = estrategiaDeInvestimento;
	}
	
	public Conta realizarInvestimento(Conta conta) {
		double lucroBruto = estrategiaDeInvestimento.investir(conta.getSaldo());
		double lucroLiquido = lucroBruto * 0.75;
		return conta.deposita(lucroLiquido);
	}

}
