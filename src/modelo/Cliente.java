package modelo;

public class Cliente {
	
	//atributos
    private int nroCliente;
    private String email;
    
    //constructor
	public Cliente(int nroCliente, String email) throws Exception {
		super();
		this.setNroCliente(nroCliente);
		this.email = email;
	}
	
	//getters and setters
	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) throws Exception{
		if (nroCliente < 0) throw new Exception ("Error: el numero de cliente no puede ser menor que 0.");
			this.nroCliente = nroCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//to string
	@Override
	public String toString() {
		return "Cliente nroCliente= " + nroCliente + ", email= " + email + "";
	}
}