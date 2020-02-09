package modelo;

public class DetalleBaja {

	//atributos
    private String detalleConcepto;
    private String unidad;
    private int desde;
    private int hasta;
    private double valor;

    //constructor
    public DetalleBaja(String detalleConcepto, String unidad, int desde, int hasta, double valor) {
        super();
        this.detalleConcepto = detalleConcepto;
        this.unidad = unidad;
        this.desde = desde;
        this.hasta = hasta;
        this.valor = valor;
    }

    //getters and setters
    public String getDetalleConcepto() {
        return detalleConcepto;
    }

    public void setDetalleConcepto(String detalleConcepto) {
        this.detalleConcepto = detalleConcepto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    //to string
	@Override
	public String toString() {
		return "Detalle: " + detalleConcepto + ", unidad: " + unidad + ", desde " + desde
				+ " hasta " + hasta + ", valor: $" + valor;
	}

}