package com.dgois.alura.investimentos;

import java.time.LocalDate;

public class Conta {

	private final String titular;
	private final String agencia;
	private final String numeroDaConta;
	private final double saldo;
	private final LocalDate dataAbertura;
	private final EstadoConta estado;

	public Conta(String titular, String agencia, String numeroDaConta, double saldo, LocalDate dataAbertura) {
		this.titular = titular;
		this.agencia = agencia;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
		this.estado = saldo > 0 ? new SaldoPositivo() : new SaldoNegativo();
	}
	
	public Conta(Conta copy, EstadoConta estado, double valor) {
		this.titular = copy.getTitular();
		this.agencia = copy.getAgencia();
		this.numeroDaConta = copy.getNumeroDaConta();
		this.saldo = valor;
		this.dataAbertura = copy.getDataAbertura();
		this.estado = estado;
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
	
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public Conta deposita(double valor) {
		return estado.deposita(this, valor);
	}
	
	public Conta saca(double valor) {
		return estado.saca(this, valor);
	}
	
	public EstadoConta getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Conta [titular=" + titular + ", agencia=" + agencia + ", numeroDaConta=" + numeroDaConta + ", saldo="
				+ saldo + ", dataAbertura=" + dataAbertura + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((numeroDaConta == null) ? 0 : numeroDaConta.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (numeroDaConta == null) {
			if (other.numeroDaConta != null)
				return false;
		} else if (!numeroDaConta.equals(other.numeroDaConta))
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}
}
