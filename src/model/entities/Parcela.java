package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date vencimento;
	private Double montante;
	
	public Parcela() {
	}
	
	public Parcela(Date vencimento, Double montante) {
		this.vencimento = vencimento;
		this.montante = montante;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Double getMontante() {
		return montante;
	}

	public void setMontante(Double montante) {
		this.montante = montante;
	}

	@Override
	public String toString() {
		return sdf.format(vencimento) + " - " +  String.format("%.2f", montante);
	}
	
	
	

}
