package modelo;

import java.util.List;

public class Zona {

	//atributos
    private int codZona;
    private String nombre;
    private List<Inspector> listInspectores;
    
    //constructor
	public Zona(int codZona, String nombre, List<Inspector> listInspectores) {
		super();
		this.codZona = codZona;
		this.nombre = nombre;
		this.listInspectores = listInspectores;
	}

	//getters and setters
	public int getCodZona() {
		return codZona;
	}

	public void setCodZona(int codZona) {
		this.codZona = codZona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Inspector> getListInspectores() {
		return listInspectores;
	}

	public void setListInspectores(List<Inspector> listInspectores) {
		this.listInspectores = listInspectores;
	}

	//to string
	@Override
	public String toString() {
		return codZona + ", " + nombre + ", \n Inspectores: " + listInspectores + "\n";
	}
    
}