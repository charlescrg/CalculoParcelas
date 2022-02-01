package aplication;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.PaypalService;
import model.services.ServicoContrato;

public class Programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados do contrato:");
		System.out.println("Numero:");
		Integer numero = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy)");
		Date data = sdf.parse(sc.next());
		System.out.println("Valor do contrato:");
		Double valorTotal = sc.nextDouble();
		System.out.println("Informe a quantidade de parcelas:");
		int meses = sc.nextInt();
		
		
		Contrato contrato = new Contrato(numero,data,valorTotal);
		
		ServicoContrato cs = new ServicoContrato(new PaypalService());
		
		cs.processo(contrato, meses);
		
		System.out.println("Parcelas:");
		for (Parcela parc : contrato.getParcelas()) {
			System.out.println(parc);
		}
		
		sc.close();		
		
	}

}
