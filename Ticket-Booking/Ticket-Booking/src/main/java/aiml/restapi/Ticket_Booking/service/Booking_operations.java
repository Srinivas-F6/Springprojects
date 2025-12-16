package aiml.restapi.Ticket_Booking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import aiml.restapi.Ticket_Booking.model.Booking;


@Service
public class Booking_operations {
  
	Map<String, Integer> villages = new HashMap<>();

	public Booking_operations() {
        villages.put("Velangi", 1);
        villages.put("Rameswaram", 2);
        villages.put("Pedapudi", 3);
        villages.put("Balabhadrapuram", 4);
        villages.put("Morampudi", 5);
        villages.put("Kolamuru", 6);
        villages.put("Rajavolu", 7);
        villages.put("Torredu", 8);
        villages.put("Hukumpeta", 9);
        villages.put("Katheru", 10);
    }
	
	Map<String, Booking> booking = new HashMap<>();
	
	 public void multipleBookings(List<Booking> b) {
		 for(Booking value: b) {
			 ticketBooking(value);
		 }
	 }
	 
	 public boolean  ticketBooking(Booking b) {
		  if( !booking.containsKey(b.getNumber()) && villages.containsKey(b.getSource()) && villages.containsKey(b.getDestination())) {
			   booking.put(b.getNumber(), b);
			   return true;
		  }
		  return false;
	 }
	 
	 
	 public Booking cancelBooking(String number,String source, String destination) {
		 if(booking.containsKey(number) && booking.get(number).getSource().equals(source) && 
				 booking.get(number).getDestination().equals(destination)) {
			 Booking b = booking.get(number);
			 booking.remove(number);
			 return b;
		 }
		 return null;
	 }
	 
	 
	 public List<Booking> display(){
		 return new ArrayList<>(booking.values());
	 }
	
	 public int ticketsCount() {
		 return booking.size();
	 }
	 
	 public Booking getDetailsByNumber(String number) {
		  if(booking.containsKey(number)) {
			  return booking.get(number);
		  }
		  return null;
	 }
}
