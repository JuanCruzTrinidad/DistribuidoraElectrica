package modelo;

import java.util.List;

import modelo.DetalleBaja;

public class TarifaBaja extends Tarifa {

	//atributo
    private List<DetalleBaja> listDetalle;

    //constructor
	public TarifaBaja(String servicio, int id, List<DetalleBaja> listDetalle) {
		super(servicio, id);
		this.listDetalle = listDetalle;
	}

	
	//getter and setter
	public List<DetalleBaja> getListDetalle() {
		return listDetalle;
	}

	public void setListDetalle(List<DetalleBaja> listDetalle) {
		this.listDetalle = listDetalle;
	}

	//to string
	@Override
	public String toString() {
		return "Baja.";// + listDetalle;
	}

}
