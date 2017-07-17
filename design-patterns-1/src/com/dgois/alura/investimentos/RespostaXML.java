package com.dgois.alura.investimentos;

public class RespostaXML implements Resposta {

	private Resposta proxima;
	
	public RespostaXML(Resposta proxima) {
		this.proxima = proxima;
	}

	@Override
	public void responde(Requisicao req, Conta conta) {
		if(req.getFormato().equals(Formato.XML)) {
			System.out.println("<nome>" + conta.getTitular() + "</nome><saldo>" + conta.getSaldo() + "</saldo>");  
		} else {
			proxima.responde(req, conta);
		}
	}

}
