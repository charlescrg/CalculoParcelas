package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContrato {
	private ServicoPagamentoOnline servicoPagamentoOnline;

	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}
	
	
	public void processo (Contrato contrato, int meses) {
		
		double cotaBasica = contrato.getValorTotal() / meses;
		for (int i = 1;i <= meses;i++) {
			double cota1 = cotaBasica + servicoPagamentoOnline.taxaJuros(cotaBasica, i);
			double cotaFinal = cota1 + servicoPagamentoOnline.taxaPagamento(cota1);
			
			Date dataPagamento = addMonths(contrato.getData(),i);
			contrato.getParcelas().add(new Parcela(dataPagamento,cotaFinal));
			
		}
		
	}
	
	private Date addMonths(Date data, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();	}
	

}
