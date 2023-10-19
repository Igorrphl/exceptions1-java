package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		
		try {		
			System.out.print("Número do quarto: ");
			int number = sc.nextInt();
			System.out.print("Selecione a Data de Check-In (dd/MM/aaaa): ");
			//Colocando a data em formato de texto e o SDF converte em Date
			Date CkeckIn = sdf.parse(sc.next());
			System.out.print("Selecione a data de Check-Out (dd/MM/aaaa)");
			Date CkeckOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, CkeckIn, CkeckOut);
			System.out.println("Reserva: " + reservation);
			
			
			//ATUALIZANDO AS DATAS DE RESERVA
			System.out.println();
			System.out.println("Entre com as novas datas de reserva: ");
			System.out.print("Selecione a Data de Check-In (dd/MM/aaaa): ");
			CkeckIn = sdf.parse(sc.next());
			System.out.print("Selecione a data de Check-Out (dd/MM/aaaa)");
			CkeckOut = sdf.parse(sc.next());
			
			reservation.updateDates(CkeckIn, CkeckOut);
			System.out.println("Reserva atualizada: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("O formato da datas é inválido");
		}
		catch (DomainException e) {
			//getMessage é a mensagem que eu passei na hora de estanciar a excessão 
			System.out.println("Erro na sua reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado, contate o administrador");
		}
		
		sc.close();
	}

}
