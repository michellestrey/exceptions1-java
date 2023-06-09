package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
   private Integer roomNumber;
   private Date checkIn;
   private Date checkOut;
   
   private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
	 long diff = checkOut.getTime() - checkIn.getTime();
	 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
 }
 public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error! Must be future date";
		} else if(!checkOut.after(checkIn)) {
			return "Error! Must be after checkin date";}
	 this.checkIn = checkIn;
	 this.checkOut = checkOut;
	return null;
 }
@Override
public String toString() {
	return "//Reservation --- Room Number: " + roomNumber + ", checkIn: " + sdf.format(checkIn) + "---- checkOut: " + sdf.format(checkOut)+ " Duration: "+ duration()+" nights." ;
}
   
   
   
   
}





