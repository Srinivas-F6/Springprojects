package aiml.restapi.Ticket_Booking.model;



public class Booking {
   
	private String name;
	private String number;
	private String email;
	private String source;
	private String destination;
	private int count;
	
	
	public Booking() {}


	public Booking(String name, String number, String email, String source, String destination, int count) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.source = source;
		this.destination = destination;
		this.count = count;
	}


	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Booking [name=" + name + ", number=" + number + ", email=" + email + ", source=" + source
				+ ", destination=" + destination + ", count=" + count +"]";
	}


	
	
}
