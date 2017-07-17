package com.dgois.alura.notafiscal.builder;

public class EnviadorDeSMS implements AcaoAposGerarNotaFiscal {
	
	public boolean executa(NotaFiscal nf) {
		System.out.println("Enviar por SMS nota fiscal " + nf.getNumero());
		return true;
	}

}
