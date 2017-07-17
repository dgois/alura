package com.dgois.alura.relatorio.different.templatemethodimplementation;

public class TemplateRelatorio {

	public void print(Relatorio relatorio) {
		relatorio.printCabecalho();
		System.out.println("----------------------------------------");
		relatorio.printCorpo();
		System.out.println("----------------------------------------");
		relatorio.printRodape();
	}
}
