package employe;

public class Employe {
	private String name;
	private int id;
	
    public Employe() {}
    
    public Employe(String name, int id) {
    	this.name = name;
    	this.id = id;
    }
    
    public void display() {
    	System.out.println(name);
    	System.out.println(id);
    }
}
