package test;


import java.util.ArrayList;
import java.util.List;
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.DatosPersonales;
import modelo.Factura;
import modelo.Inspector;
import modelo.Lectura;
import modelo.Medidor;
import modelo.Sistema;
import modelo.Tarifa;
import modelo.Zona;

public class TestZona {

	public static void main(String[] args) throws Exception {
		
		//Datos Personales
		DatosPersonales datos1 = new DatosPersonales("Juancruz","Trinidad",40811021);
		DatosPersonales datos3 = new DatosPersonales("Tomas","Silvestre",42232265);
		
		//Lista Cliente Fisico
		List<ClienteFisico> listaCf = new ArrayList<ClienteFisico>();

		//Lista Cliente Juridico
		List<ClienteJuridico> listaCj = new ArrayList<ClienteJuridico>();

		//Hago una lista de inspectores para utilizar en Zona
		Inspector inspector1 = new Inspector(datos1,1);
		Inspector inspector2 = new Inspector(datos3,2);

		List<Inspector> listaInspector1 = new ArrayList<Inspector>();
		listaInspector1.add(inspector1);
		listaInspector1.add(inspector2);

		//Lista Zona
		List<Zona> listaZona = new ArrayList<Zona>();
		
		//Lista Tarifa
		List<Tarifa> listaTarifa = new ArrayList<Tarifa>();

		//Lista Medidor
		List<Medidor> listaMedidor = new ArrayList<Medidor>();

		//Lista Lectura
		List<Lectura> listaLectura = new ArrayList<Lectura>();

		//Creamos un sistema
		List<Factura> listafactura = new ArrayList<Factura>();
		Sistema sistema1 = new Sistema(listaCf,listaCj,listaZona,listaMedidor,listaLectura,listaTarifa, listafactura);
		

		try {
			System.out.println("\nAlta: ");
			sistema1.agregarZona(1, "Ezeiza", listaInspector1);
			sistema1.agregarZona(2, "Lomas de Zamora", listaInspector1);
			System.out.println(sistema1.getListaZona());
			
			System.out.println("\nModificacion: "); //Modifico el nombre de la zona.
			sistema1.modificarZona(1, "Temperley", listaInspector1);
			System.out.println(sistema1.getListaZona());
			
			System.out.println("\nEliminar: ");
			sistema1.eliminarZona(2);
			System.out.println(sistema1.getListaZona());
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}


