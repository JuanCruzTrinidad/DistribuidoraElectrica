package modelo;

import java.time.LocalDate;

public class Baja extends Lectura{

	//atributo
	private double kwh;
	
	//constructor
	public Baja(int codLectura, Medidor medidor, LocalDate fecha, Inspector inspector, double kwh) {
		super(codLectura, medidor, fecha, inspector);
		this.kwh = kwh;
	}
	
	//getter and setter
	public double getKwh() {
		return kwh;
	}

	public void setKwh(double kwh) {
		this.kwh = kwh;
	}

	@Override
	public String toString() {
		return "\tCod. de Lectura: "+ codLectura +".\n\t kWh: " + kwh + ".\n\t Medidor:" + medidor + "\t Inspector: " + inspector +"\t Fecha: " + fecha + "\n";
	}
	
}
