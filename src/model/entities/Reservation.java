package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    protected Integer roomNumbe;
    protected Date checkin;
    protected Date checkout;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation() {
    }
    public Reservation(Integer roomNumbe, Date checkin, Date checkout) {
        this.roomNumbe = roomNumbe;
        this.checkin = checkin;
        this.checkout = checkout;
    }
    public Integer getRoomNumbe() {
        return roomNumbe;
    }
    public void setRoomNumbe(Integer roomNumbe) {
        this.roomNumbe = roomNumbe;
    }
    public Date getCheckin() {
        return checkin;
    }
 
    public Date getCheckout() {
        return checkout;
    }
    public long duration ( ){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public String updateDate(Date checkin ,Date checkout){
        Date now = new Date();
		if ( checkin.before(now) || checkout.before(now)){
			return "Reservation dates for update must be future dates";
		}
        if(!checkout.after(checkin)){
		    return "Check-out date must be future check-in date";
		}
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }
    @Override
    public String toString(){
        return "Room " + roomNumbe + ", checkin" + sdf.format(checkin) + ", checkout" + sdf.format(checkout) + ", " + duration() + "nigths";

    }
}
