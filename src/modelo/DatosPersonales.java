package modelo;

public class DatosPersonales {

	//atributos
    private String nombre;
    private String apellido;
    private int dni;
    
    //constructor
	public DatosPersonales(String nombre, String apellido, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	//to string
	@Override
	public String toString() {
		return nombre + " " + apellido + ", DNI: " + dni;
	}
	
}