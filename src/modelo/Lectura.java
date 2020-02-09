package modelo;

import java.time.LocalDate;

public class Lectura {
	
	//atributos
	protected int codLectura;
	protected Medidor medidor;
	protected LocalDate fecha;
	protected Inspector inspector;
	
	//constructor
	public Lectura(int codLectura, Medidor medidor, LocalDate fecha, Inspector inspector) {
		super();
		this.codLectura= codLectura;
		this.medidor = medidor;
		this.fecha = fecha;
		this.inspector = inspector;
	}
	
	//getters and setters
	public Medidor getMedidor() {
		return medidor;
	}

	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}


	public int getCodLectura() {
		return codLectura;
	}


	public void setCodLectura(int codLectura) {
		this.codLectura = codLectura;
	}
	
	
	//to string
	@Override
	public String toString() {
		return "\tCod. de Lectura: " + codLectura  + ".\n\t Medidor:" + medidor + "\t Inspector:" + inspector +"\t Fecha:" + fecha; //Falta kwh
	}

	
	
	
	
	
	
}