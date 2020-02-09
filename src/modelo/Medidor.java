package modelo;

public class Medidor {
	
	//atributos
	private Cliente cliente;
	private int nroSerie;
	private String domicilioMedidor;
	private boolean esBaja;
	private Tarifa tarifa;
	private Zona zona;
	
	//constructor
	public Medidor(Cliente cliente, int nroSerie, String domicilioMedidor, boolean esBaja, Tarifa tarifa, Zona zona) {
		super();
		this.cliente = cliente;
		this.nroSerie = nroSerie;
		this.domicilioMedidor = domicilioMedidor;
		this.esBaja = esBaja;
		this.tarifa = tarifa;
		this.zona = zona;
	}

	//getters and setters
	
	public Cliente getCliente() {
		return cliente;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}

	public String getDomicilioMedidor() {
		return domicilioMedidor;
	}

	public void setDomicilioMedidor(String domicilioMedidor) {
		this.domicilioMedidor = domicilioMedidor;
	}

	public boolean isEsBaja() {
		return esBaja;
	}

	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	//to string
	@Override
	public String toString() {
		return "\tCliente " + cliente + "\t Nro. de Serie: " + nroSerie + ",\n\t Domicilio: " + 
				domicilioMedidor + /*",\n\t Es tarifa baja? " + esBaja +*/ ",\n\t Tarifa: " + tarifa
				+ "\n\t Zona: " + zona.getCodZona() + ", " + zona.getNombre() + ".\n";
	}
	
}
