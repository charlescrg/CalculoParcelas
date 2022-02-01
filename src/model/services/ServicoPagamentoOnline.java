package model.services;

public interface ServicoPagamentoOnline {
	
	Double taxaPagamento(Double montante);
	Double taxaJuros(Double montante, Integer meses);	

}
