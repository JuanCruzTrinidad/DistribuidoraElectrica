package modelo;

public class ClienteFisico extends Cliente{

	//atributos
    private DatosPersonales datosPersonales;
    private String nroCuil;
    
    //constructor
	public ClienteFisico(int nroCliente, String email, DatosPersonales datosPersonales, String nroCuil) throws Exception{
		super(nroCliente, email);
		this.datosPersonales = datosPersonales;
		this.setNroCuil(nroCuil);
	}

	//getters and setters
	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public String getNroCuil() {
		return nroCuil;
	}

	public void setNroCuil(String nroCuil) throws Exception{
		if (nroCuil == "0") throw new Exception ("Error: el CUIL no puede ser 0.");
		this.nroCuil = nroCuil;
	}

	//to string
	@Override
	public String toString() {
		return "Fisico: "+ this.getNroCliente() + ", " + datosPersonales + ", CUIL: " + nroCuil +  ", Email: " + this.getEmail() + "\n";
	}
	
	
}