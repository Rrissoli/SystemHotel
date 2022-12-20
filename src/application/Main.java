package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {
	public static void main(String[]args) throws Exception{
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	System.out.println("Room Number");
	int number = sc.nextInt();
	System.out.println("Check-in Date:");
	Date checkin = sdf.parse(sc.next());
	System.out.println("Check-out Date:");
	Date checkout = sdf.parse(sc.next());	
	
	if(!checkout.after(checkin)){
		System.out.println("Error in your reservation");
	}else{
		Reservation reservation = new Reservation(number, checkin, checkout);
		System.out.println("Rservation"+reservation);
		System.out.println("Enter to update date reservation");
		System.out.println("Check-in date");
		checkin = sdf.parse(sc.next());
		System.out.println("Check-out date");
		checkout = sdf.parse(sc.next());

		
	
		String error = reservation.updateDate(checkin, checkout);
		if(error != null){
			System.out.println("Error in reservation: " + error);
		}
		else{
			System.out.println("Rservation" + reservation);	
		}
		
	


	}


	}
}
