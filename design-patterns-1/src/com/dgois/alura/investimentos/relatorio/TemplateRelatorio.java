package com.dgois.alura.investimentos.relatorio;

public abstract class TemplateRelatorio implements Relatorio {

	Relatorio proximoTipoDeRelatorio;

	@Override
	public void print(ModoDoRelatorio modo) {
		if (deveGerarRelatorioDoTipo(modo)) {
			printCabecalho();
			System.out.println("----------------------------------------");
			printCorpo();
			System.out.println("----------------------------------------");
			printRodape();
		} else {
			chamaOProximo(modo);
		}
	}

	public void chamaOProximo(ModoDoRelatorio modo) {
		if (proximoTipoDeRelatorio != null) {
			proximoTipoDeRelatorio.print(modo);
		} else {
			System.out.println("Tipo do relatório inválido!");
		}
	}

	abstract void printCabecalho();

	abstract void printCorpo();

	abstract void printRodape();

	abstract boolean deveGerarRelatorioDoTipo(ModoDoRelatorio modo);

}
