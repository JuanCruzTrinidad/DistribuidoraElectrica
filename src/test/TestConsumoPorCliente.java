package test;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import modelo.Alta;
import modelo.Baja;
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
import modelo.TarifaAlta;
import modelo.TarifaBaja;
import modelo.Zona;

public class TestConsumoPorCliente {

	public static void main(String[] args) throws Exception {
		//Datos Personales
		DatosPersonales datos1 = new DatosPersonales("Juancruz","Trinidad",40811021);
		DatosPersonales datos2 = new DatosPersonales("Kevin","Nakandakare",41986557);
		DatosPersonales datos3 = new DatosPersonales("Armando","Paredes",4132332);
		DatosPersonales datos4 = new DatosPersonales("Leo","Messi",42368432);
		DatosPersonales datos5 = new DatosPersonales("Fernando","Zarate",391444223);
		DatosPersonales datos7 = new DatosPersonales("Laura","Medici",42132449);

		//Lista Cliente Fisico
		ClienteFisico cf1 = new ClienteFisico(1,"juancruz@gmail.com",datos1,"20-40811021-7");
		ClienteFisico cf2 = new ClienteFisico(2,"kevin.nakandakare@gmail.com",datos2,"20-41986557-6");

		List<ClienteFisico> listaCf = new ArrayList<ClienteFisico>();
		listaCf.add(cf1);
		listaCf.add(cf2);

		//Lista Cliente Juridico
		ClienteJuridico cj1 = new ClienteJuridico(3,"tomas.silvestre@gmail.com","Silvestre S.A.","20-12491491-6");
		ClienteJuridico cj2 = new ClienteJuridico(4,"luana.selena@gmail.com","Luana S.A.","21-4242932-7");

		List<ClienteJuridico> listaCj = new ArrayList<ClienteJuridico>();
		listaCj.add(cj1);
		listaCj.add(cj2);

		//Lista Inspector
		Inspector inspector1 = new Inspector(datos3,1);
		Inspector inspector2 = new Inspector(datos4,2);
		Inspector inspector3 = new Inspector(datos5,3);
		Inspector inspector4 = new Inspector(datos7,4);

		List<Inspector> listaInspector1 = new ArrayList<Inspector>();
		listaInspector1.add(inspector1);
		listaInspector1.add(inspector2);
		List<Inspector> listaInspector2 = new ArrayList<Inspector>();
		listaInspector2.add(inspector3);
		listaInspector2.add(inspector4);

		//Lista Zona
		Zona zona1 = new Zona(1,"Lomas de Zamora",listaInspector1);
		Zona zona2 = new Zona(2,"Banfield",listaInspector2);

		List<Zona> listaZona = new ArrayList<Zona>();
		listaZona.add(zona1);
		listaZona.add(zona2);

		// ------------------ LISTA TARIFA BAJA DEMANDA ---------------------------//
		// DETALLE BAJA FIJA DESDE R1 A R9
		DetalleBaja r1f = new DetalleBaja ("Cargo Fijo", "$/Mes", 0, 150, 32.82);
		DetalleBaja r2f = new DetalleBaja ("Cargo Fijo", "$/Mes", 151, 325, 56.11);
		DetalleBaja r3f = new DetalleBaja ("Cargo Fijo", "$/Mes", 326, 400, 91.73);
		DetalleBaja r4f = new DetalleBaja ("Cargo Fijo", "$/Mes", 401, 450, 107.34);
		DetalleBaja r5f = new DetalleBaja ("Cargo Fijo", "$/Mes", 451, 500, 161.66);
		DetalleBaja r6f = new DetalleBaja ("Cargo Fijo", "$/Mes", 501, 600, 316);
		DetalleBaja r7f = new DetalleBaja ("Cargo Fijo", "$/Mes", 601, 700, 850.24);
		DetalleBaja r8f = new DetalleBaja ("Cargo Fijo", "$/Mes", 701, 1400, 1203.64);
		DetalleBaja r9f = new DetalleBaja ("Cargo Fijo", "$/Mes", 1401, 100000, 1442.88);
		// DETALLE BAJA VARIABLE DESDE R1 A R9
		DetalleBaja r1v = new DetalleBaja ("Cargo Variable", "$/kWh", 0, 150, 2.653);
		DetalleBaja r2v = new DetalleBaja ("Cargo Variable", "$/kWh", 151, 325, 2.651);
		DetalleBaja r3v = new DetalleBaja ("Cargo Variable", "$/kWh", 326, 400, 2.705);
		DetalleBaja r4v = new DetalleBaja ("Cargo Variable", "$/kWh", 401, 450, 2.785);
		DetalleBaja r5v = new DetalleBaja ("Cargo Variable", "$/kWh", 451, 500, 2.864);
		DetalleBaja r6v = new DetalleBaja ("Cargo Variable", "$/kWh", 501, 600, 2.918);
		DetalleBaja r7v = new DetalleBaja ("Cargo Variable", "$/kWh", 601, 700, 3.309);
		DetalleBaja r8v = new DetalleBaja ("Cargo Variable", "$/kWh", 701, 1400, 3.411);
		DetalleBaja r9v = new DetalleBaja ("Cargo Variable", "$/kWh", 1401, 100000, 3.437);

		// LISTA DE DETALLEBAJA DE R1 A R9
		List<DetalleBaja> listaR = new ArrayList<DetalleBaja>();

		listaR.add(r1v);
		listaR.add(r2v);
		listaR.add(r3v);
		listaR.add(r4v);
		listaR.add(r5v);
		listaR.add(r6v);
		listaR.add(r7v);
		listaR.add(r8v);
		listaR.add(r9v);
		listaR.add(r1f);
		listaR.add(r2f);
		listaR.add(r3f);
		listaR.add(r4f);
		listaR.add(r5f);
		listaR.add(r6f);
		listaR.add(r7f);
		listaR.add(r8f);
		listaR.add(r9f);

		TarifaBaja tarifaBaja = new TarifaBaja("Baja demanda",1,listaR);

		//BT
		DetalleAlta btFijoFalse = new DetalleAlta ("Cargo Fijo", "$/Mes", false, 3226.41);
		DetalleAlta btFijoTrue = new DetalleAlta ("Cargo Fijo", "$/Mes", true, 3226.41);
		DetalleAlta btPicoFalse = new DetalleAlta ("Cargo Variable Pico", "$/KWh", false, 2.260);
		DetalleAlta btPicoTrue = new DetalleAlta ("Cargo Variable Pico", "$/KWh", true, 3.286);
		DetalleAlta btRestoFalse = new DetalleAlta ("Cargo Variable Resto", "$/KWh", false, 2.160);
		DetalleAlta btRestoTrue = new DetalleAlta ("Cargo Variable Resto", "$/KWh", true, 3.138);
		DetalleAlta btValleFalse = new DetalleAlta ("Cargo Variable Valle", "$/KWh", false, 2.061);
		DetalleAlta btValleTrue = new DetalleAlta ("Cargo Variable Valle", "$/KWh", true, 2.990);
		//MT
		DetalleAlta mtFijoFalse = new DetalleAlta ("Cargo Fijo", "$/Mes", false, 3226.09);
		DetalleAlta mtFijoTrue = new DetalleAlta ("Cargo Fijo", "$/Mes", true, 3226.09);
		DetalleAlta mtPicoFalse = new DetalleAlta ("Cargo Variable Pico", "$/KWh", false, 2.148);
		DetalleAlta mtPicoTrue = new DetalleAlta ("Cargo Variable Pico", "$/KWh", true, 3.123);
		DetalleAlta mtRestoFalse = new DetalleAlta ("Cargo Variable Resto", "$/KWh", false, 2.053);
		DetalleAlta mtRestoTrue = new DetalleAlta ("Cargo Variable Resto", "$/KWh", true, 2.983);
		DetalleAlta mtValleFalse = new DetalleAlta ("Cargo Variable Valle", "$/KWh", false, 1.959);
		DetalleAlta mtValleTrue = new DetalleAlta ("Cargo Variable Valle", "$/KWh", true, 2.841);
		//AT
		DetalleAlta atFijoFalse = new DetalleAlta ("Cargo Fijo", "$/Mes", false, 3224.11);
		DetalleAlta atFijoTrue = new DetalleAlta ("Cargo Fijo", "$/Mes", true, 3224.11);
		DetalleAlta atPicoFalse = new DetalleAlta ("Cargo Variable Pico", "$/KWh", false, 2.060);
		DetalleAlta atPicoTrue = new DetalleAlta ("Cargo Variable Pico", "$/KWh", true, 2.995);
		DetalleAlta atRestoFalse = new DetalleAlta ("Cargo Variable Resto", "$/KWh", false, 1.969);
		DetalleAlta atRestoTrue = new DetalleAlta ("Cargo Variable Resto", "$/KWh", true, 2.860);
		DetalleAlta atValleFalse = new DetalleAlta ("Cargo Variable Valle", "$/KWh", false, 1.879);
		DetalleAlta atValleTrue = new DetalleAlta ("Cargo Variable Valle", "$/KWh", true, 2.725);

		List<DetalleAlta> listaBt = new ArrayList<DetalleAlta>();
		listaBt.add(btFijoFalse);
		listaBt.add(btFijoTrue);
		listaBt.add(btPicoFalse);
		listaBt.add(btPicoTrue);
		listaBt.add(btRestoFalse);
		listaBt.add(btRestoTrue);
		listaBt.add(btValleFalse);
		listaBt.add(btValleTrue);

		List<DetalleAlta> listaMt = new ArrayList<DetalleAlta>();
		listaMt.add(mtFijoFalse);
		listaMt.add(mtFijoTrue);
		listaMt.add(mtPicoFalse);
		listaMt.add(mtPicoTrue);
		listaMt.add(mtRestoFalse);
		listaMt.add(mtRestoTrue);
		listaMt.add(mtValleFalse);
		listaMt.add(mtValleTrue);

		List<DetalleAlta> listaAt = new ArrayList<DetalleAlta>();
		listaAt.add(atFijoFalse);
		listaAt.add(atFijoTrue);
		listaAt.add(atPicoFalse);
		listaAt.add(atPicoTrue);
		listaAt.add(atRestoFalse);
		listaAt.add(atRestoTrue);
		listaAt.add(atValleFalse);
		listaAt.add(atValleTrue);

		TarifaAlta altaBt = new TarifaAlta("Tarifa Alta BT",2,"BT",300,listaBt);
		TarifaAlta altaMt = new TarifaAlta("Tarifa Alta MT",3,"MT",300,listaMt);
		TarifaAlta altaAt = new TarifaAlta("Tarifa Alta AT",4,"AT",300,listaAt);

		List<Tarifa> listaTarifa = new ArrayList<Tarifa>();

		listaTarifa.add(tarifaBaja);
		listaTarifa.add(altaBt);
		listaTarifa.add(altaMt);
		listaTarifa.add(altaAt);


		//Lista Medidor
		Medidor medidor1 = new Medidor(cf1,157,"Lomas de Zamora",true,tarifaBaja,zona1);
		Medidor medidor2 = new Medidor(cf1,390,"Lanus",true,tarifaBaja,zona2);
		Medidor medidor3 = new Medidor(cj1,268,"Banfield",false,altaMt,zona1); 
		Medidor medidor4 = new Medidor(cj1,290,"Ezeiza",false,altaMt,zona2);


		List<Medidor> listaMedidor = new ArrayList<Medidor>();
		listaMedidor.add(medidor1);
		listaMedidor.add(medidor2);
		listaMedidor.add(medidor3);
		listaMedidor.add(medidor4);

		//Lista Lectura
		//LocalDate fecha1 = LocalDate.of(2019, 1, 10);
		LocalDate fecha2 = LocalDate.of(2019, 2, 10);
		LocalDate fecha3 = LocalDate.of(2019, 3, 10);
		LocalDate fecha4 = LocalDate.of(2019, 4, 10);
		LocalDate fecha5 = LocalDate.of(2019, 5, 10);
		LocalDate fecha6 = LocalDate.of(2019, 6, 10);
		//LocalDate fecha7 = LocalDate.of(2019, 7, 10);
		LocalDate fecha8 = LocalDate.of(2019, 8, 10);
		LocalDate fecha10 = LocalDate.of(2018, 10, 10);
		//LocalDate fecha11 = LocalDate.of(2018, 11, 10);
		LocalDate fecha12 = LocalDate.of(2018, 12, 10);

		Baja Baja1 = new Baja(1, medidor1, fecha8, inspector1, 300);  //Lecturas de medidor1 (Baja Demanda), Cliente = Juancruz Trinidad
		Baja Baja3 = new Baja(3, medidor1, fecha6, inspector2, 240);
		Baja Baja2 = new Baja(3, medidor1, fecha5, inspector2, 220);
		Baja Baja5 = new Baja(5, medidor1, fecha4, inspector2, 180);
		Baja Baja4 = new Baja(3, medidor1, fecha3, inspector2, 140);
		Baja Baja7 = new Baja(7, medidor1, fecha2, inspector2, 80);
		Baja Baja9 = new Baja(9, medidor1, fecha10, inspector2, 40);
		Baja Baja10 = new Baja(10, medidor1, fecha12, inspector2, 20);

		Baja Baja11 = new Baja(11, medidor2, fecha8, inspector1, 400);  //Lecturas de medidor2 (Baja Demanda), Cliente = Juancruz Trinidad
		Baja Baja13 = new Baja(13, medidor2, fecha6, inspector2, 300);
		Baja Baja15 = new Baja(15, medidor2, fecha4, inspector2, 200);
		Baja Baja17 = new Baja(17, medidor2, fecha2, inspector2, 100);
		Baja Baja19 = new Baja(19, medidor2, fecha10, inspector2, 50);
		Baja Baja21 = new Baja(20, medidor2, fecha12, inspector2, 15);

		Alta alta2 = new Alta(22, medidor3, fecha6, inspector2, 810, 910, 1011); //Lectura de medidor3 (Alta Demanda), Cliente = Silvestre Company
		Alta alta1 = new Alta(21, medidor3, fecha4, inspector2, 500, 600, 701); //Lectura de medidor3 (Alta Demanda), Cliente = Silvestre Company
		Alta alta3 = new Alta(23, medidor3, fecha2, inspector2, 420, 400, 400);

		Alta alta4 = new Alta(24, medidor4 , fecha4, inspector2, 500,600,701);  // Lectura de medidor4 (Alta demanda), Cliente = Silvestre Company
		Alta alta6 = new Alta(26, medidor4 , fecha2, inspector2, 399, 302, 500);

		List<Lectura> listaLectura = new ArrayList<Lectura>();
		listaLectura.add(Baja1);
		listaLectura.add(Baja2);
		listaLectura.add(Baja4);
		listaLectura.add(Baja3);
		listaLectura.add(Baja5);
		listaLectura.add(Baja7);
		listaLectura.add(Baja9);
		listaLectura.add(Baja10);
		listaLectura.add(Baja11);
		listaLectura.add(Baja13);
		listaLectura.add(Baja15);
		listaLectura.add(Baja17);
		listaLectura.add(Baja19);
		listaLectura.add(Baja21);
		listaLectura.add(alta1);
		listaLectura.add(alta2);
		listaLectura.add(alta3);
		listaLectura.add(alta4);
		listaLectura.add(alta6);

		List<Factura> listafactura = new ArrayList<Factura>();


		Sistema sistema1 = new Sistema(listaCf,listaCj,listaZona,listaMedidor,listaLectura,listaTarifa,listafactura);


		Factura factura1;
		factura1 = sistema1.generarFactura(medidor3, 6, 2019);
		System.out.println(factura1);
		//System.out.println("\tTotal a pagar: "+sistema1.calcularTotal(factura1.getListaItemFactura(), medidor3) + "\n\n");


		Factura factura2;
		factura2 = sistema1.generarFactura(medidor1, 4, 2019);
		//System.out.println(factura2);
		//System.out.println("\tTotal a pagar: "+sistema1.calcularTotal(factura2.getListaItemFactura(), medidor1) + "\n\n");

		Factura factura3;
		factura3 = sistema1.generarFactura(medidor2, 6, 2019);
		//System.out.println(factura3);
		//System.out.println("\tTotal a pagar: "+sistema1.calcularTotal(factura3.getListaItemFactura(), medidor2) + "\n\n");


		Factura factura4;
		factura4 = sistema1.generarFactura(medidor4, 4, 2019);
		System.out.println(factura4);
		//System.out.println("\tTotal a pagar: "+sistema1.calcularTotal(factura4.getListaItemFactura(), medidor1) + "\n\n");

		try {
			sistema1.consumoClienteFecha(cj1, fecha4, fecha6); //Emitir reporte de consumos por cliente entre fechas.
			System.out.println("\n");
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}


	}

}
