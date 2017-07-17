package com.dgois.alura.relatorio.different.templatemethodimplementation;

public class TesteRelatorios {
	
	public static void main(String[] args) {
		
		Conta contas[] = {
				new Conta("João", "0333", "11145-9", 350.00),
				new Conta("Maria", "0653", "65145-4", 2050.00),
				new Conta("Pedro", "0668", "22256-2", 9850.00),
				new Conta("Marcos", "0333", "25478-6", 50.00),
				new Conta("Ana Paula", "1343", "78145-9", 60.00),
				};
		
		Banco banco = new Banco("Bamerindos", "(11) 2356-8769", "Avenida Presidente Dutra, 453, SP, São Paulo", "gerente-michael@bamerindos.com");
		for (Conta conta : contas) {
			banco.adicionarConta(conta);
		}
		
		//Relatorio r = new RelatorioSimples(banco);
		Relatorio r = new RelatorioComplexo(banco);
		
		new TemplateRelatorio().print(r);
	}
}
