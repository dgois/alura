package com.dgois.alura.relatorio;

public class Conta {

	private final String titular;
	private final String agencia;
	private final String numeroDaConta;
	private final double saldo;

	public Conta(String titular, String agencia, String numeroDaConta, double saldo) {
		this.titular = titular;
		this.agencia = agencia;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
}
