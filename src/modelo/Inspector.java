package modelo;


public class Inspector {

	//atributos
    private DatosPersonales datosPersonales;
    private int nroEmpleado;
    
    //constructor
	public Inspector(DatosPersonales datosPersonales, int nroEmpleado) {
		super();
		this.datosPersonales = datosPersonales;
		this.nroEmpleado = nroEmpleado;
		//this.zona = zona;
	}
	
	//getters and setters
	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}
	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}
	public int getNroEmpleado() {
		return nroEmpleado;
	}
	public void setNroEmpleado(int nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	//to string
	@Override
	public String toString() {
		return datosPersonales + ", nro. de empleado: " + nroEmpleado + "\n";
	
	}       
}