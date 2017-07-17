package com.dgois.alura.investimentos.relatorio;

import com.dgois.alura.investimentos.Conta;
import com.dgois.alura.relatorio.Banco;

public class RelatorioSimples extends TemplateRelatorio {
	
	private Banco banco;
	
	public RelatorioSimples(Banco banco, Relatorio proximoTipo) {
		this.banco = banco;
		this.proximoTipoDeRelatorio = proximoTipo;
	}

	@Override
	void printCabecalho() {
		System.out.println(getConteudoCabecalhoERodape());
		
	}

	private String getConteudoCabecalhoERodape() {
		return "Banco: " + banco.getNome() + ". Telefone: " + banco.getTelefone();
	}

	@Override
	void printCorpo() {
		System.out.println("Titular     Saldo");
		for (Conta conta : banco.getContas()) {
			System.out.println(conta.getTitular() + "     " + conta.getSaldo());
		}
	}

	@Override
	void printRodape() {
		System.out.println(getConteudoCabecalhoERodape());
	}

	@Override
	boolean deveGerarRelatorioDoTipo(ModoDoRelatorio modo) {
		return ModoDoRelatorio.SIMPLES.equals(modo);
	}
}
