package modelo;


public class ItemFactura {

	//atributos
	private String detalleFactura;
	private String unidad;
	private double cantidad;
	private double precio;

	//constructor
	public ItemFactura(String detalleFactura, String unidad, double cantidad) {
		super();
		this.detalleFactura = detalleFactura;
		this.unidad = unidad;
		this.cantidad = cantidad;
	}

	//getters and setters
	public String getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(String detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	//to string
	@Override
	public String toString() {
		return "\n\t" + detalleFactura + ", Unidad: " + unidad + ", Cantidad: " + cantidad + " kWh"
				+ ", Subtotal: $" + precio + " " ;
	}

}
