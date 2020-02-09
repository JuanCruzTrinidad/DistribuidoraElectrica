package modelo;
import java.util.List;

import modelo.DetalleAlta;

public class TarifaAlta extends Tarifa {

	//atributos
    private String tensionContratada;
    private int limite;
    private List<DetalleAlta> listDetalle;
    
    //constructor
	public TarifaAlta(String servicio, int id, String tensionContratada, int limite, List<DetalleAlta> listDetalle) {
		super(servicio, id);
		this.tensionContratada = tensionContratada;
		this.limite = limite;
		this.listDetalle = listDetalle;
	}

	//getters and setters
	public String getTensionContratada() {
		return tensionContratada;
	}

	public void setTensionContratada(String tensionContratada) {
		this.tensionContratada = tensionContratada;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public List<DetalleAlta> getListDetalle() {
		return listDetalle;
	}

	public void setListDetalle(List<DetalleAlta> listDetalle) {
		this.listDetalle = listDetalle;
	}

	//to string
	@Override
	public String toString() {
		return "Alta. Tensión contratada: " + tensionContratada + ", limite: " + limite + " kWh,";// + listDetalle;
	}
 
}