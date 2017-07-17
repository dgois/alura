package com.dgois.alura.investimentos.relatorio;

import java.time.LocalDateTime;

import com.dgois.alura.investimentos.Conta;
import com.dgois.alura.relatorio.Banco;

public class RelatorioComplexo extends TemplateRelatorio {
	
	private Banco banco;

	public RelatorioComplexo(Banco banco, Relatorio proximoTipo) {
		this.banco = banco;
		this.proximoTipoDeRelatorio = proximoTipo;
	}

	@Override
	void printCabecalho() {
		System.out.println("Banco: " + banco.getNome());
		System.out.println("Enderço: " + banco.getEndereco());
		System.out.println("Telefone: " + banco.getTelefone());
	}

	@Override
	void printCorpo() {
		System.out.println("Titular     Agência     Numero da Conta     Salto");
		for(Conta conta : banco.getContas()) {
			System.out.println(conta.getTitular() + "     " + conta.getAgencia() + "     " + conta.getNumeroDaConta() + "     " + conta.getSaldo());
		}
		
	}

	@Override
	void printRodape() {
		System.out.println("E-mail: " + banco.getEmail() + " Data: " + LocalDateTime.now());
		
	}

	@Override
	boolean deveGerarRelatorioDoTipo(ModoDoRelatorio modo) {
		return ModoDoRelatorio.COMPLEXO.equals(modo);
	}

}
