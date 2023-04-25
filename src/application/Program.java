package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");	
		
		System.out.println("Room Number:" );
		int roomNumber = sc.nextInt();
		System.out.print("Check in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.print("Error: Check out must be after check in ");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		System.out.println();
		System.out.print(" Enter data to update reservation");
		System.out.print("Check in date (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error! Must be future date");
		} else if(!checkOut.after(checkIn)) {
			System.out.println("Error! Must be after checkin date");
		} else {	
	     reservation.updateDates(checkIn, checkOut);
	     System.out.print("Reservation update: " + reservation);
		}
		
		
		
		
		
		sc.close();

	}
	}
	}
