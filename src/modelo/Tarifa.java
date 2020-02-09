package modelo;

public class Tarifa {
	
	//atributo
    private String servicio;
    private int id;

    //constructor
    public Tarifa(String servicio, int id) {
		super();
		this.servicio = servicio;
		this.id = id;
	}

    //getters and setters
    
    public String getServicio() {
        return servicio;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    //to string
    @Override
	public String toString() {
		return "   Servicio: " + servicio;
	}

}
