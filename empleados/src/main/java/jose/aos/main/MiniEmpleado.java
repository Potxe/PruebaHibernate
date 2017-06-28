package jose.aos.main;

public class MiniEmpleado {
	
	private int employedId;
	private String firstName;
	
		
	public MiniEmpleado(int employedId, String firstName) {
		super();
		this.employedId = employedId;
		this.firstName = firstName;
	}
	public int getEmployedId() {
		return employedId;
	}
	public void setEmployedId(int employedId) {
		this.employedId = employedId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	

}
