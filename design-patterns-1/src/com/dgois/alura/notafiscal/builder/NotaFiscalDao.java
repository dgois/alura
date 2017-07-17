package com.dgois.alura.notafiscal.builder;

public class NotaFiscalDao implements AcaoAposGerarNotaFiscal {
	public boolean executa(NotaFiscal nf) {
		System.out.println("Salvar no banco de dados nota fiscal " + nf.getNumero());
		return true;
	}
}
