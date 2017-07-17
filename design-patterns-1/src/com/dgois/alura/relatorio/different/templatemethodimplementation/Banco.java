package com.dgois.alura.relatorio.different.templatemethodimplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
	
	private final String nome;
	private final String telefone;
	private final String endereco;
	private final String email;
	private final List<Conta> contas;

	public Banco(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}
	
	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}

	public List<Conta> getContas() {
		return Collections.unmodifiableList(contas);
	}
}
