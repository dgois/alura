package com.dgois.alura.investimentos;

import java.time.LocalDate;

public class TesteEstadoContaBancaria {
	
	public static void main(String[] args) {
		Conta joao = new Conta("João", "2233", "144567", 10, LocalDate.now().minusDays(1));
		
		joao = joao.deposita(100);
		
		System.out.println(joao.getSaldo());
		
		joao = joao.saca(200);
		
		System.out.println(joao.getSaldo());
		
		joao = joao.deposita(100);
		
		System.out.println(joao.getSaldo());
		System.out.println(joao.getEstado().getClass().getSimpleName()); //must be 85
	}

}
