package modelo;

import java.time.LocalDate;

public class Alta extends Lectura{

	//atributos
	private double kwhPico;
	private double kwhResto;
	private double kwhValle;

	
	//constructor
	public Alta(int codLectura, Medidor medidor, LocalDate fecha, Inspector inspector, double kwhPico, double kwhResto,
			double kwhValle) {
		super(codLectura, medidor, fecha, inspector);
		this.kwhPico = kwhPico;
		this.kwhResto = kwhResto;
		this.kwhValle = kwhValle;
	}


	
	public double getKwhPico() {
		return kwhPico;
	}



	public void setKwhPico(double kwhPico) {
		this.kwhPico = kwhPico;
	}


	public double getKwhValle() {
		return kwhValle;
	}


	public void setKwhValle(double kwhValle) {
		this.kwhValle = kwhValle;
	}


	public double getKwhResto() {
		return kwhResto;
	}


	public void setKwhResto(double kwhResto) {
		this.kwhResto = kwhResto;
	}


	//to string
	@Override
	public String toString() {
		return "\tCod. de Lectura: " + codLectura + ".\n\t kWh Pico: " + kwhPico +  ", kWh Resto: " + kwhResto + ", kWh Valle: " + kwhValle +
				".\n\t Medidor: "+ medidor + "\t Inspector: " + inspector + "\t Fecha: " + fecha + "\n"; 
	}

}
