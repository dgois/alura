package com.dgois.alura.relatorio.different.templatemethodimplementation;

import java.time.LocalDateTime;

public class RelatorioComplexo implements Relatorio {
	
	private Banco banco;

	public RelatorioComplexo(Banco banco) {
		this.banco = banco;
	}

	@Override
	public void printCabecalho() {
		System.out.println("Banco: " + banco.getNome());
		System.out.println("Enderço: " + banco.getEndereco());
		System.out.println("Telefone: " + banco.getTelefone());
	}

	@Override
	public void printCorpo() {
		System.out.println("Titular     Agência     Numero da Conta     Salto");
		for(Conta conta : banco.getContas()) {
			System.out.println(conta.getTitular() + "     " + conta.getAgencia() + "     " + conta.getNumeroDaConta() + "     " + conta.getSaldo());
		}
		
	}

	@Override
	public void printRodape() {
		System.out.println("E-mail: " + banco.getEmail() + " Data: " + LocalDateTime.now());
		
	}

}
