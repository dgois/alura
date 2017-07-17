package com.dgois.alura.notafiscal.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalBuilder {

	private String empresa;
	private String cnpj;
	private LocalDate data;
	private List<ItemDaNota> itens;
	private double valorTotal;
	private double imposto;
	private String observacao;
	private List<AcaoAposGerarNotaFiscal> acoesAposGerarNF;
	
	public NotaFiscalBuilder() {
		this.data = LocalDate.now();
		this.itens = new ArrayList<>();
		this.acoesAposGerarNF = new ArrayList<>();
	}
	
	public NotaFiscalBuilder adicionarAcaoAposGerarNf(AcaoAposGerarNotaFiscal acao) {
		this.acoesAposGerarNF.add(acao);
		return this;
	}

	public NotaFiscalBuilder paraEmpresa(String empresa) {
		this.empresa = empresa;
		return this;
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder naData(LocalDate data) {
		this.data = data;
		return this;
	}

	public NotaFiscalBuilder com(ItemDaNota itemNovo) {
		itens.add(itemNovo);
		valorTotal += itemNovo.getValor();
		imposto += itemNovo.getValor() * 0.05;
		return this;
	}

	public NotaFiscalBuilder comObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public NotaFiscal build() {
		NotaFiscal nf = new NotaFiscal(empresa, cnpj, data, valorTotal, imposto, itens, observacao);

		acoesAposGerarNF.stream().forEach(acao -> acao.executa(nf));
		
		return nf;
	}
}
