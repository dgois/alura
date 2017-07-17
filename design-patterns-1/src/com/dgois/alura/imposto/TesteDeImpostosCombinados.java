package com.dgois.alura.imposto;

import com.dgois.alura.imposto.tipos.ISS;
import com.dgois.alura.imposto.tipos.Imposto;
import com.dgois.alura.imposto.tipos.ImpostoMuitoAlto;

public class TesteDeImpostosCombinados {
	
	public static void main(String[] args) {
		
		//Imposto impostoComplexo = new ISS(new ICMS());
		Imposto impostoComplexo = new ImpostoMuitoAlto(new ISS());
		
		Orcamento orcamento = new Orcamento();
		Item caneta = new Item("caneta", 250);
		Item borracha = new Item("borracha", 250);
		orcamento.addItem(caneta);
		orcamento.addItem(borracha);
		
		double valor = impostoComplexo.calcula(orcamento);
		
		System.out.println(valor);
		
	}
}
