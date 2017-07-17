package com.dgois.alura.investimentos;

public class RespostaPorcentagem implements Resposta {

	private Resposta proxima;
	
	public RespostaPorcentagem(Resposta proxima) {
		this.proxima = proxima;
	}

	@Override
	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato().equals(Formato.PORCENTO)) {
			System.out.println("nome:" + conta.getTitular() + "%saldo:" + conta.getSaldo());
		} else {
			proxima.responde(req, conta);
		}
	}
}
