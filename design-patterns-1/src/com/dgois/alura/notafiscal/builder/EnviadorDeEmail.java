package com.dgois.alura.notafiscal.builder;

public class EnviadorDeEmail implements AcaoAposGerarNotaFiscal {
	
	public boolean executa(NotaFiscal nf) {
		System.out.println("Enviar por email nota fiscal " + nf.getNumero());
		return true;
	}

}
