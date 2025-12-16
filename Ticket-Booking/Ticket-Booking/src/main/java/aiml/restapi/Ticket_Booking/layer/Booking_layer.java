package aiml.restapi.Ticket_Booking.layer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aiml.restapi.Ticket_Booking.model.Booking;
import aiml.restapi.Ticket_Booking.service.Booking_operations;


@CrossOrigin("*")
@RestController
public class Booking_layer {
	
	@Autowired
	Booking_operations booking;
	
	@PostMapping("/add/allTickets")
	public void multipleBookings(@RequestBody List<Booking> b) {
		 booking.multipleBookings(b);
	}
	
	@PostMapping("/post/customerDetails")
	public boolean  ticketBooking(@RequestBody Booking b) {
		return booking.ticketBooking(b);
	}
	
	@GetMapping("get/canceled/details/{number}/{source}/{destination}")
	public Booking cancelBooking(@PathVariable String number, @PathVariable String source, @PathVariable String destination) {
		return booking.cancelBooking(number,source, destination);
	}
	
	
	@GetMapping("/get/allBookings")
	public List<Booking> display(){
		return booking.display();
	}
	
	@GetMapping("get/TicketInfo/{number}")
	public Booking getDetailsByNumber(@PathVariable String number) {
		return booking.getDetailsByNumber(number);
	}
	
	

}
