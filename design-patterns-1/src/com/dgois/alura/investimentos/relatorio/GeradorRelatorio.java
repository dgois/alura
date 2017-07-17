package com.dgois.alura.investimentos.relatorio;

import com.dgois.alura.relatorio.Banco;

public class GeradorRelatorio {
	
	private Relatorio inicio;
	
	public GeradorRelatorio(Banco banco) {
		inicio = new RelatorioSimples(banco, new RelatorioComplexo(banco, null));
	}
	
	public void gerarRelatorio(ModoDoRelatorio modo) {
		inicio.print(modo);
	}

}
