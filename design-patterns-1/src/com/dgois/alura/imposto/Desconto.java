package com.dgois.alura.imposto;

public interface Desconto {
	
	double calcula(Orcamento orcamento);
	void setProximo(Desconto desconto);

}
