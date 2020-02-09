package test;


import java.util.ArrayList;
import java.util.List;
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.DatosPersonales;
import modelo.DetalleAlta;
import modelo.DetalleBaja;
import modelo.Factura;
import modelo.Inspector;
import modelo.Lectura;
import modelo.Medidor;
import modelo.Sistema;
import modelo.Tarifa;
import modelo.TarifaBaja;
import modelo.Zona;

public class TestMedidor {

	public static void main(String[] args) throws Exception {

		//Datos Personales
		DatosPersonales datos1 = new DatosPersonales("Juancruz","Trinidad",40811021);
		DatosPersonales datos2 = new DatosPersonales("Kevin","Nakandakare",41986557);

		//Lista Cliente Fisico
		ClienteFisico cf1 = new ClienteFisico(1,"juancruz@gmail.com",datos1,"20-40811021-7");
		ClienteFisico cf2 = new ClienteFisico(2,"kevin.nakandakare@gmail.com",datos2,"20-41986557-6");
		List<ClienteFisico> listaCf = new ArrayList<ClienteFisico>();

		//Lista Cliente Juridico
		List<ClienteJuridico> listaCj = new ArrayList<ClienteJuridico>();

		//Lista Inspector
		List<Inspector> listaInspector1 = new ArrayList<Inspector>();

		//Lista Zona
		Zona zona1 = new Zona(1,"Lomas de Zamora",listaInspector1);
		Zona zona2 = new Zona(2,"Banfield",listaInspector1);
		Zona zona3 = new Zona(3,"Monte Grande",listaInspector1);
		List<Zona> listaZona = new ArrayList<Zona>();
		listaZona.add(zona1);
		listaZona.add(zona2);
		listaZona.add(zona3);

		//Lista Tarifa
		DetalleBaja r1v = new DetalleBaja ("Cargo Variable", "$/kWh", 0, 150, 2.653);
		List<DetalleBaja> listaR = new ArrayList<DetalleBaja>();
		listaR.add(r1v);

		TarifaBaja tarifaBaja = new TarifaBaja("Baja demanda",1,listaR);
		List<Tarifa> listaTarifa = new ArrayList<Tarifa>();

		DetalleAlta btFijoFalse = new DetalleAlta ("Cargo Fijo", "$/Mes", false, 3226.41);
		DetalleAlta btFijoTrue = new DetalleAlta ("Cargo Fijo", "$/Mes", true, 3226.41);
		DetalleAlta btPicoFalse = new DetalleAlta ("Cargo Variable Pico", "$/KWh", false, 2.260);
		DetalleAlta btPicoTrue = new DetalleAlta ("Cargo Variable Pico", "$/KWh", true, 3.286);
		DetalleAlta btRestoFalse = new DetalleAlta ("Cargo Variable Resto", "$/KWh", false, 2.160);
		DetalleAlta btRestoTrue = new DetalleAlta ("Cargo Variable Resto", "$/KWh", true, 3.138);
		DetalleAlta btValleFalse = new DetalleAlta ("Cargo Variable Valle", "$/KWh", false, 2.061);
		DetalleAlta btValleTrue = new DetalleAlta ("Cargo Variable Valle", "$/KWh", true, 2.990);

		List<DetalleAlta> listaBt = new ArrayList<DetalleAlta>();
		listaBt.add(btFijoFalse);
		listaBt.add(btFijoTrue);
		listaBt.add(btPicoFalse);
		listaBt.add(btPicoTrue);
		listaBt.add(btRestoFalse);
		listaBt.add(btRestoTrue);
		listaBt.add(btValleFalse);
		listaBt.add(btValleTrue);

		//Lista Medidor
		List<Medidor> listaMedidor = new ArrayList<Medidor>();

		//Lista Lectura
		List<Lectura> listaLectura = new ArrayList<Lectura>();


		//Creamos un sistema
		List<Factura> listafactura = new ArrayList<Factura>();
		Sistema sistema1 = new Sistema(listaCf,listaCj,listaZona,listaMedidor,listaLectura,listaTarifa, listafactura);


		try {
			System.out.println("\nAlta: ");
			sistema1.agregarMedidor(cf1, 290, "Laprida 1465", false, tarifaBaja, zona1);
			sistema1.agregarMedidor(cf2, 301, "Uruguay 241", true, tarifaBaja, zona2);
			System.out.println(sistema1.getListaMedidor());

			System.out.println("\nModificacion: ");
			sistema1.modificarMedidor(cf2, 301, "Tucuman 76", true, tarifaBaja, zona3); //Cambio la direccion y zona
			System.out.println(sistema1.getListaMedidor());

			System.out.println("\n Eliminar: ");  //Elimino el medidor con nroSerie 301.
			sistema1.eliminarMedidor(301);
			System.out.println(sistema1.getListaMedidor()); 
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
