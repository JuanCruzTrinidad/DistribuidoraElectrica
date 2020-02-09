package modelo;

public class ClienteJuridico extends Cliente {

	//atributos
    private String nombreEmpresa;
    private String numeroCuit;
    
    //constructor
	public ClienteJuridico(int nroCliente, String email, String nombreEmpresa, String numeroCuit) throws Exception{
		super(nroCliente, email);
		this.setNombreEmpresa(nombreEmpresa);
		this.numeroCuit = numeroCuit;
	}

	//getters and setters
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) throws Exception {
		if (nombreEmpresa == "") throw new Exception ("Error: la empresa debe tener nombre.");
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNumeroCuit() {
		return numeroCuit;
	}

	public void setNumeroCuit(String numeroCuit) {
		this.numeroCuit = numeroCuit;
	}

	//to string
	@Override
	public String toString() {
		return "Juridico: " + this.getNroCliente() + ", " + nombreEmpresa + ", CUIT: " + numeroCuit + ", Email: " + this.getEmail() + "\n";
	}
    
}