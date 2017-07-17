package com.dgois.alura.imposto.orcamento.estados;

import com.dgois.alura.imposto.Orcamento;

public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orçamento reprovados não recebem desconto extra!");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Um orçamento reprovado não pode ser aprovado");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Um orçamento reprovado não pode ser reprovado novamente");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.configuraEstadoAtual(new Finalizado());
	}

}
