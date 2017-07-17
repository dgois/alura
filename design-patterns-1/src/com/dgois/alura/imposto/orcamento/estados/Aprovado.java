package com.dgois.alura.imposto.orcamento.estados;

import com.dgois.alura.imposto.Orcamento;

public class Aprovado implements EstadoDeUmOrcamento {
	
	private static boolean DESCONTO_APLICADO = false;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (!DESCONTO_APLICADO) {
			orcamento.realizaDescontoNoValor(orcamento.getValor() * 0.02);
			DESCONTO_APLICADO = true;
		} else {
			System.out.println("Desconto já foi aplicado");
		}
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Um orçamento aprovado não pode ser aprovado novamente");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Um orçamento aprovado não pode ser reprovado");
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.configuraEstadoAtual(new Finalizado());
		
	}
}
