package com.dgois.alura.notafiscal.builder;

import java.time.LocalDate;

public class TesteCriacaoNotaFiscal {

	public static void main(String[] args) {
		NotaFiscal nf2 = new NotaFiscalBuilder()
				.paraEmpresa("Papelaria Gois")
				.comCnpj("12.345.444/0001-12")
				.naData(LocalDate.of(2000, 12, 1))
				.com(new ItemDaNotaBuilder().comDescricao("Caneta").comValor(100.00).build())
				.com(new ItemDaNotaBuilder().comDescricao("Borracha").comValor(50.00).build())
				.comObservacao("Itens de material escolar")
				.adicionarAcaoAposGerarNf(new EnviadorDeEmail())
				.adicionarAcaoAposGerarNf(new NotaFiscalDao())
				.adicionarAcaoAposGerarNf(new EnviadorDeSMS())
				.adicionarAcaoAposGerarNf(new Impressora())
				.build();
		
		System.out.println("Número da NF: " + nf2.getNumero());
		System.out.println(" Valor da NF: " + nf2.getValorBruto());
		
	}
}
