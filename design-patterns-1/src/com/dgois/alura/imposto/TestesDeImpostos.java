package com.dgois.alura.imposto;

import com.dgois.alura.imposto.tipos.ICCC;
import com.dgois.alura.imposto.tipos.ICMS;
import com.dgois.alura.imposto.tipos.ICPP;
import com.dgois.alura.imposto.tipos.IHIT;
import com.dgois.alura.imposto.tipos.IKCV;
import com.dgois.alura.imposto.tipos.ISS;
import com.dgois.alura.imposto.tipos.Imposto;

public class TestesDeImpostos {
	public static void main(String[] args) {
		Imposto icms = new ICMS();
		Imposto iss = new ISS();
		Imposto iccc = new ICCC();
		Imposto ikcv = new IKCV();
		Imposto icpp = new ICPP();
		Imposto ihit = new IHIT();
		
		
		Orcamento orcamento = new Orcamento();
		Item caneta = new Item("caneta", 10);
		Item caneta2 = new Item("caneta", 15);
		orcamento.addItem(caneta);
		orcamento.addItem(caneta2);
		
		CalculadorDeImpostos calculador = new CalculadorDeImpostos();
		
		calculador.realizaCalculo(orcamento, iss);
		calculador.realizaCalculo(orcamento, icms);
		calculador.realizaCalculo(orcamento, iccc);
		calculador.realizaCalculo(orcamento, ikcv);
		calculador.realizaCalculo(orcamento, icpp);
		calculador.realizaCalculo(orcamento, ihit);
	}
}
