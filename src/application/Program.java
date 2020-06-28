package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto?: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/aaaa)?: ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Data de saida (dd/MM/aaaa)?: ");
		Date saida = sdf.parse(sc.next());
		
		if (!saida.after(entrada)) {
			System.out.println("Erro na reserva, saida posterior a data de entrada");
			
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite a nova data para a reserva: ");
			System.out.print("Data de entrada (dd/MM/aaaa)?: ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saida (dd/MM/aaaa)?: ");
			saida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (entrada.before(agora) || saida.before(agora)) {
				System.out.println("ERRO!!!  A reserva só pode ser atualizada para datas futuras.");
				
			}
			
			else if (!saida.after(entrada)) {
				System.out.println("Erro na reserva, saida posterior a data de entrada");
				
			}
			else {
			reserva.atualizarDatas(entrada, saida);
			System.out.println("Reserva: " + reserva);
			}
		}
		
		
		
		
		
		
		sc.close();
	}

}
