package com.dgois.alura.investimentos;

public class ProcessarRequisicao {
	
	private Resposta respCsv;
	
	public ProcessarRequisicao() {
		respCsv = new RespostaCSV(new RespostaXML(new RespostaPorcentagem(new RespostaNaoSuportada())));
	}
	
	public void processar(Requisicao req, Conta conta) {
		System.out.println("Log: " + req.getFormato());
		respCsv.responde(req, conta);
	}
}
