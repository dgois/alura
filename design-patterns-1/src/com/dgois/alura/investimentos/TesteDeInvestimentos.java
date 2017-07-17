package com.dgois.alura.investimentos;

import java.time.LocalDate;

public class TesteDeInvestimentos {
	
	public static void main(String[] args) {
		
		Conta minhaConta = new Conta("John", "1234", "44567-8", 100.0, LocalDate.of(2017, 1, 3));
		
		RealizadorDeInvestimentos realizadorDeInvestimentos = new RealizadorDeInvestimentos(new EstrategiaModerada());
		
		minhaConta = realizadorDeInvestimentos.realizarInvestimento(minhaConta);
		
		System.out.println("Saldo atual: " + minhaConta.getSaldo());
	}

}
