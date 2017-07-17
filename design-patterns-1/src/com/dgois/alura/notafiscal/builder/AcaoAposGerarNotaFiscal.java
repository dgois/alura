package com.dgois.alura.notafiscal.builder;

@FunctionalInterface
public interface AcaoAposGerarNotaFiscal {
	boolean executa(NotaFiscal nf);
}
