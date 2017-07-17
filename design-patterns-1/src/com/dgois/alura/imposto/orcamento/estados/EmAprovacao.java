package com.dgois.alura.imposto.orcamento.estados;

import com.dgois.alura.imposto.Orcamento;

public class EmAprovacao implements EstadoDeUmOrcamento {
	
	private static boolean DESCONTO_APLICADO = false;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (!DESCONTO_APLICADO) {
			orcamento.realizaDescontoNoValor(orcamento.getValor() * 0.05);
			DESCONTO_APLICADO = true;
		} else {
			System.out.println("Desconto já foi aplicado");
		}
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.configuraEstadoAtual(new Aprovado());
	}

	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.configuraEstadoAtual(new Reprovado());
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orçamento em aprovação não pode ser finalizado");
		
	}
}
