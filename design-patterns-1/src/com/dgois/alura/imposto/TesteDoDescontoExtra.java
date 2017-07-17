package com.dgois.alura.imposto;

public class TesteDoDescontoExtra {
	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.addItem(new Item("Reforma", 500));
		
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		
		orcamento.aprova();
		
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		orcamento.aplicaDescontoExtra();
		
		orcamento.finaliza();
		System.out.println(orcamento);
		
		orcamento.reprova();
	}

}
