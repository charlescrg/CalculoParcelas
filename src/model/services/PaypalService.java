package model.services;


public class PaypalService implements ServicoPagamentoOnline {
	
	private static final double TAXA_PAGAMENTO = 0.02;
	private static final double TAXA_JUROS = 0.01;
	
	
	@Override
	public Double taxaPagamento(Double montante) {
		return montante * TAXA_PAGAMENTO;
}
	
	@Override
		public Double taxaJuros(Double montante, Integer meses) {
			return montante * meses * TAXA_JUROS;
	}	
	
	
}