package com.dgois.alura.relatorio.different.templatemethodimplementation;

public class RelatorioSimples implements Relatorio {
	
	private Banco banco;
	
	public RelatorioSimples(Banco banco) {
		this.banco = banco;
	}

	@Override
	public void printCabecalho() {
		System.out.println(getConteudoCabecalhoERodape());
		
	}

	private String getConteudoCabecalhoERodape() {
		return "Banco: " + banco.getNome() + ". Telefone: " + banco.getTelefone();
	}

	@Override
	public void printCorpo() {
		System.out.println("Titular     Saldo");
		for (Conta conta : banco.getContas()) {
			System.out.println(conta.getTitular() + "     " + conta.getSaldo());
		}
	}

	@Override
	public void printRodape() {
		System.out.println(getConteudoCabecalhoERodape());
	}
}
