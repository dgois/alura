package com.dgois.alura.investimentos;

public class RespostaCSV implements Resposta {

	private Resposta proxima;
	
	public RespostaCSV(Resposta proxima) {
		this.proxima = proxima;
	}

	@Override
	public void responde(Requisicao req, Conta conta) {
		if(req.getFormato().equals(Formato.CSV)) {
			System.out.println("nome:" + conta.getTitular() + ";" + "saldo:" + conta.getSaldo());  
		} else {
			proxima.responde(req, conta);
		}
	}
}
