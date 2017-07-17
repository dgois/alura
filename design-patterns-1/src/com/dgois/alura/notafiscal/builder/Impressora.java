package com.dgois.alura.notafiscal.builder;

public class Impressora implements AcaoAposGerarNotaFiscal {
	
	public boolean executa(NotaFiscal nf) {
		System.out.println("Imprimir nota fiscal " + nf.getNumero());
		return true;
	}

}
