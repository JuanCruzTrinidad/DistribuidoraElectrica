package modelo;

import java.time.LocalDate;
import java.util.List;

public class Factura {

	//atributos
	private int nroFactura;
	private int nroCliente;
	private String datosClientes;
	private Zona zona;
	private int nroMedidor;
	private LocalDate fechaFactura;
	private LocalDate fechaDeVencimiento;
	private List<ItemFactura> listaItemFactura;
	private double total;
	
	//constructor
	public Factura(int nroFactura, int nroCliente, String datosClientes, Zona zona, int nroMedidor,
			LocalDate fechaFactura, LocalDate fechaDeVencimiento, List<ItemFactura> listaItemFactura, double total) {
		super();
		this.nroFactura = nroFactura;
		this.nroCliente = nroCliente;
		this.datosClientes = datosClientes;
		this.zona = zona;
		this.nroMedidor = nroMedidor;
		this.fechaFactura = fechaFactura;
		this.fechaDeVencimiento = fechaDeVencimiento;
		this.listaItemFactura = listaItemFactura;
		this.total= total;
	}

	//getters and setters

	public int getNroFactura() {
		return nroFactura;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getDatosClientes() {
		return datosClientes;
	}

	public void setDatosClientes(String datosClientes) {
		this.datosClientes = datosClientes;
	}

	public int getNroMedidor() {
		return nroMedidor;
	}

	public void setNroMedidor(int nroMedidor) {
		this.nroMedidor = nroMedidor;
	}

	public LocalDate getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public LocalDate getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public List<ItemFactura> getListaItemFactura() {
		return listaItemFactura;
	}

	public void setListaItemFactura(List<ItemFactura> listaItemFactura) {
		this.listaItemFactura = listaItemFactura;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	//to string
	@Override
	public String toString() {
		return "Factura:" +  "\n\tNro. de factura: " + nroFactura + 
				".\n\tCliente: " + nroCliente + ", " + datosClientes
				+ ".\n\tZona: " + zona.getCodZona() +", "+ zona.getNombre() + ".\n\tNro. de medidor: " + nroMedidor + ".\n\tEmision: " + 
				fechaFactura
				+ "\n\tVencimiento: " + fechaDeVencimiento + "\n\tDetalle:" + listaItemFactura + "\n\tTotal a pagar: $" + total + "\n"; //total
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (datosClientes == null) {
			if (other.datosClientes != null)
				return false;
		} else if (!datosClientes.equals(other.datosClientes))
			return false;
		if (fechaDeVencimiento == null) {
			if (other.fechaDeVencimiento != null)
				return false;
		} else if (!fechaDeVencimiento.equals(other.fechaDeVencimiento))
			return false;
		if (fechaFactura == null) {
			if (other.fechaFactura != null)
				return false;
		} else if (!fechaFactura.equals(other.fechaFactura))
			return false;
		if (listaItemFactura == null) {
			if (other.listaItemFactura != null)
				return false;
		} else if (!listaItemFactura.equals(other.listaItemFactura))
			return false;
		if (nroCliente != other.nroCliente)
			return false;
		if (nroFactura != other.nroFactura)
			return false;
		if (nroMedidor != other.nroMedidor)
			return false;
		if (zona == null) {
			if (other.zona != null)
				return false;
		} else if (!zona.equals(other.zona))
			return false;
		return true;
	}
	
	
	
	
}
