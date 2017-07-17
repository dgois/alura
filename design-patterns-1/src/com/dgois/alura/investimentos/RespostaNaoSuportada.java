package com.dgois.alura.investimentos;

public class RespostaNaoSuportada implements Resposta {

	@Override
	public void responde(Requisicao req, Conta conta) {
		System.out.println("Formato não suportado");
	}

}
