package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de Check-Out não pode ser inferior a data de Ckeck-in");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}
 
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		
		//Diferença das duas datas em milessegundos 
		long difDate = checkOut.getTime() - checkIn.getTime();
		
		//Convertendo milessengundos para dias
		//TimeUnit é um tipo enumerado que possui algumas operações
		return TimeUnit.DAYS.convert(difDate, TimeUnit.MILLISECONDS);
	}
	
	//Usando o "throws" para propagar a excessão na ass. do método - Ou seja, PODE LANÇAR UMA EXCESSÃO
	public void updateDates (Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			
			//Lançando uma exceção - Os argumentos do método são inválidos
			// Data de check-in e check-out ---- não pode ser antes da data atual
			throw new DomainException("A datas de reserva devem ser datas futuras!");
		}
		
		//---- ATENÇÃO AO "!" = NÃO ----- 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de Check-Out não pode ser inferior a data de Ckeck-in");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Quarto: " + roomNumber + ", Data de Check-in: " + sdf.format(checkIn) + 
				", Data de Check-Out: " + sdf.format(checkOut) + ", " + duration() + " Noites";
		
	}

}
