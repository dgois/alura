package com.dgois.alura.investimentos;

import java.time.LocalDate;
import java.util.Random;

public class TesteRequisicaoDeFormato {

	public static void main(String[] args) {

		Requisicao req = new Requisicao(Formato.values()[new Random().nextInt(4)]);

		Conta conta = new Conta("Orisvaldo", "1234", "44567-8", 700.0, LocalDate.of(2017, 1, 3));
		
		new ProcessarRequisicao().processar(req, conta);
	}
}
