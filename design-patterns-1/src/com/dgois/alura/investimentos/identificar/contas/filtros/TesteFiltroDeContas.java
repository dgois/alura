package com.dgois.alura.investimentos.identificar.contas.filtros;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.dgois.alura.investimentos.Conta;

public class TesteFiltroDeContas {
	
	public static void main(String[] args) {
		Conta contas[] = {
				new Conta("João", "0333", "11145-9", 350.00, LocalDate.of(2017, 1, 3)),
				new Conta("Maria", "0653", "65145-4", 2050.00, LocalDate.of(2017, 1, 3)),
				new Conta("Pedro", "0668", "22256-2", 9850.00, LocalDate.of(2017, 2, 3)),
				new Conta("Marcos", "0333", "25478-6", 50.00, LocalDate.of(2017, 4, 3)),
				new Conta("Marcos Terceiro", "0333", "25478-6", 50.00, LocalDate.of(2011, 4, 3)),
				new Conta("Ana Paula", "1343", "78145-9", 60.00, LocalDate.of(2017, 1, 3)),
				new Conta("Mr. Burns", "1343", "78145-9", 600000.00, LocalDate.of(2017, 3, 3)),
				new Conta("Tio Patinhas", "1343", "78145-9", 1000000.00, LocalDate.of(2017, 1, 3))
				};
		
		Filtro filtro = new FiltraComSaldoMaiorQue500Mil(new FiltraComSaldoMenorQue100(new FiltraComDataDeAberturaDoMesCorrente()));
		List<Conta> filtradas = filtro.filtra(Arrays.asList(contas));

		filtradas.forEach(System.out::println);
		
	}

}
