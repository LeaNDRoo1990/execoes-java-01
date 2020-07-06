package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Número do quarto?: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/aaaa)?: ");
			Date entrada = sdf.parse(sc.next());
			System.out.print("Data de saida (dd/MM/aaaa)?: ");
			Date saida = sdf.parse(sc.next());
			
			
			
			Reserva reserva = new Reserva(numeroQuarto, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite a nova data para a reserva: ");
			System.out.print("Data de entrada (dd/MM/aaaa)?: ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saida (dd/MM/aaaa)?: ");
			saida = sdf.parse(sc.next());
			
		
			 reserva.atualizarDatas(entrada, saida);
			
			 System.out.println("Reserva: " + reserva);
		}
		
		catch(ParseException e) {
			System.out.println("Data Invalida");
		}
		
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
	
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		
		
		
		
		
		sc.close();
	}

}
