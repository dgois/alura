package com.dgois.alura.investimentos;

public interface EstadoConta {

	Conta deposita(Conta conta, double valor);

	Conta saca(Conta conta, double valor);

}
