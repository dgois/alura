package com.dgois.alura.imposto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.dgois.alura.imposto.orcamento.estados.EmAprovacao;
import com.dgois.alura.imposto.orcamento.estados.EstadoDeUmOrcamento;

public class Orcamento {
	
	private double valor;
	private final List<Item> itens;
	private EstadoDeUmOrcamento estadoAtual;

	public Orcamento() {
		this.valor = 0.0;
		this.itens = new ArrayList<Item>();
		estadoAtual = new EmAprovacao();
	}
	
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	public void addItem(Item novo) {
		this.itens.add(novo);
		this.valor += novo.getValor();
	}

	public double getValor() {
		return this.valor; 
	}
	
	public boolean existeItem(String nomeDoItem) {
		return getItens().stream()
				.map(Item::getNome)
				.anyMatch(nomeDoItem::equalsIgnoreCase);
	}

	public void aplicaDescontoExtra() {
		estadoAtual.aplicaDescontoExtra(this);
	}

	public void realizaDescontoNoValor(double desconto) {
		this.valor -= desconto;
	}
	
	public void configuraEstadoAtual(EstadoDeUmOrcamento estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	
	public void aprova() {
		estadoAtual.aprova(this);
	}
	
	public void reprova() {
		estadoAtual.reprova(this);
	}
	
	public void finaliza() {
		estadoAtual.finaliza(this);
	}

	@Override
	public String toString() {
		return "Orcamento [valor=" + valor + ", itens=" + Arrays.toString(itens.toArray()) + ", estadoAtual=" + estadoAtual.getClass().getSimpleName() + "]";
	}
}
