package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Cliente;
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.Factura;
import modelo.Lectura;
import modelo.Medidor;
import modelo.Zona;

public class Sistema {


	//atributos
	private List<Zona> listaZona;
	private List<ClienteFisico> listaClienteFisico;
	private List<ClienteJuridico> listaClienteJuridico;
	private List<Medidor> listaMedidor;
	private List<Lectura> listaLectura;
	private List<Tarifa> listaTarifa;
	private List<Factura> listaFactura;
	private int contador = 1;

	//constructor
	public Sistema(List<ClienteFisico> listaClienteFisico, //inicializo constructor con las diferentes listas del sistema
			List<ClienteJuridico> listaClienteJuridico, List<Zona> listaZona, List<Medidor> listaMedidor, List<Lectura> listaLectura,
			List<Tarifa> listaTarifa, List<Factura> listaFactura) {
		super();
		this.listaZona = listaZona;
		this.listaClienteFisico = listaClienteFisico;
		this.listaClienteJuridico = listaClienteJuridico;
		this.listaMedidor = listaMedidor;
		this.listaLectura = listaLectura;
		this.listaTarifa = listaTarifa;
		this.listaFactura= listaFactura;
	}

	//getters and setters
	public List<Zona> getListaZona() {
		return listaZona;
	}
	public void setListaZona(List<Zona> listaZona) {
		this.listaZona = listaZona;
	}

	public List<ClienteFisico> getListaClienteFisico() {
		return listaClienteFisico;
	}

	public void setListaClienteFisico(List<ClienteFisico> listaClienteFisico) {
		this.listaClienteFisico = listaClienteFisico;
	}

	public List<ClienteJuridico> getListaClienteJuridico() {
		return listaClienteJuridico;
	}

	public void setListaClienteJuridico(List<ClienteJuridico> listaClienteJuridico) {
		this.listaClienteJuridico = listaClienteJuridico;
	}

	public List<Medidor> getListaMedidor() {
		return listaMedidor;
	}

	public void setListaMedidor(List<Medidor> listaMedidor) {
		this.listaMedidor = listaMedidor;
	}

	public List<Lectura> getListaLectura() {
		return listaLectura;
	}

	public void setListaLectura(List<Lectura> listaLectura) {
		this.listaLectura = listaLectura;
	}

	public List<Tarifa> getListaTarifa() {
		return listaTarifa;
	}

	public void setListaTarifa(List<Tarifa> listaTarifa) {
		this.listaTarifa = listaTarifa;
	}

	public List<Factura> getListaFactura() {
		return listaFactura;
	}

	public void setListaFactura(List<Factura> listaFactura) {
		this.listaFactura = listaFactura;
	}

	//to string
	@Override
	public String toString() { //sobreeescribo to string para que me muestre la informacion del sistema organizado
		return "Sistema [listaZona=" + listaZona + ", listaClienteFisico=" + listaClienteFisico
				+ ", listaClienteJuridico=" + listaClienteJuridico + ", listaMedidor=" + listaMedidor
				+ ", listaLectura=" + listaLectura + ", listaTarifa=" + listaTarifa + ", listaFactura=" + listaFactura
				+ "]";
	}

	///////////////////METODOS CLIENTE FISICO////////////////////

	public Cliente traerCliente (int nroCliente)throws Exception //Buscar cliente fisico
	{
		Cliente c=null;
		if (c instanceof ClienteFisico) {
			for(ClienteFisico cf : listaClienteFisico) { //recorro lista clientefisico
				if(cf.getNroCliente() == nroCliente) //comparo numero de cliente, traigo cf
					return c;
			}
		}

		if (c instanceof ClienteJuridico) {
			for(ClienteJuridico cj : listaClienteJuridico) { //recorro lista clientefisico
				if(cj.getNroCliente() == nroCliente) //comparo numero de cliente, traigo cf
					return c;
			}
		}

		throw new Exception ("Error: cliente con el numero "+nroCliente+" no esta registrado"); //declaro excepcion, por si no existe el cliente
	}

	public ClienteFisico traerClienteFisico(int nroCliente) throws Exception //Buscar cliente fisico
	{
		for(ClienteFisico cf : listaClienteFisico) { //recorro lista clientefisico
			if(cf.getNroCliente() == nroCliente) //comparo numero de cliente, traigo cf
				return cf;
		}

		throw new Exception ("Error: cliente con el numero "+nroCliente+" no esta registrado"); //declaro excepcion, por si no existe el cliente
	}

	public void agregarClienteFisico(String email,DatosPersonales datos,String nroCuil ) throws Exception  //agrego cliente fisico
	{

		for(ClienteFisico cf : this.listaClienteFisico) { //recorro la lista de cliente fisico
			if(nroCuil.equals(cf.getNroCuil())) {throw new Exception("Error: El cliente con el cuil " + nroCuil + " ya esta registrado" );} //declaro excepcion, no hay dos clientes con el mismo cuil
		}

		if(listaClienteFisico.isEmpty() == true) {
			ClienteFisico a = new ClienteFisico(1,email,datos,nroCuil);
			this.listaClienteFisico.add(a);  //añado el cliente a la lista
		} else {
			ClienteFisico a = new ClienteFisico ((this.listaClienteFisico.get(listaClienteFisico.size()-1).getNroCliente()+1),email,datos,nroCuil);
			this.listaClienteFisico.add(a);  //añado el cliente a la lista
		}
		//avanza una posicion cada vez que se agrega un cliente
	}

	public void modificarClienteFisico(int nroCliente, String email, DatosPersonales datosnuevos, String nroCuil) throws Exception
	{	//solicito el nro del cliente del cual quiero modificar y sobreescribo los datos
		ClienteFisico cf;
		cf = traerClienteFisico(nroCliente);//traigo al clientefisico a modificar
		if(cf==null) {throw new Exception("Error: El cliente con el numero de cliente " + nroCliente + " no esta registrado" );}

		cf.setDatosPersonales(datosnuevos);
		cf.setNroCuil(nroCuil);
		cf.setEmail (email);
		//sobreescribo los datos del cliente
	}

	public void eliminarClienteFisico(int nroCliente) throws Exception //elimino cliente de la lista
	{
		ClienteFisico cf;
		cf = traerClienteFisico (nroCliente); //traigo cliente
		if(cf==null) {throw new Exception ("Error: El cliente con el numero de cliente " + nroCliente + " no esta registrado");}
		//excepcion si el cliente a eliminar no existe
		listaClienteFisico.remove(cf); //remuevo el cliente de la lista
	}

	////////////METODOS CLIENTE JURIDICO//////////////

	public ClienteJuridico traerClienteJuridico(int nroCliente) throws Exception //Buscar cliente Jurudico
	{
		for(ClienteJuridico cj : listaClienteJuridico) {
			if(cj.getNroCliente()==nroCliente)
				return cj;
		}

		throw new Exception ("Error: El cliente con el numero de cliente " + nroCliente + " no esta registrado");
	}

	public void agregarClienteJuridico (String email, String nombreEmpresa, String numeroCUIT) throws Exception
	{

		for(ClienteJuridico cj : this.listaClienteJuridico) {
			if(numeroCUIT==cj.getNumeroCuit()) {throw new Exception("Error: El cliente con el cuit " + numeroCUIT + " ya esta registrado");}
		}

		if(listaClienteJuridico.isEmpty() == true) {
			ClienteJuridico a = new ClienteJuridico (1,email,nombreEmpresa,numeroCUIT);
			this.listaClienteJuridico.add(a);
		} else {
			ClienteJuridico a = new ClienteJuridico ((this.listaClienteJuridico.get(listaClienteJuridico.size()-1).getNroCliente()+1), email, nombreEmpresa, numeroCUIT);
			this.listaClienteJuridico.add(a);
		}
	}

	public void modificarClienteJuridico(int nroCliente, String email, String nombreempresa, String numeroCUIT) throws Exception
	{
		ClienteJuridico cj;
		cj = traerClienteJuridico(nroCliente);
		if(cj==null) {throw new Exception("Error: El cliente con el numero de cliente " + nroCliente + " no esta registrado");}

		cj.setNombreEmpresa(nombreempresa);
		cj.setNumeroCuit (numeroCUIT);
		cj.setEmail (email);
	}

	public void eliminarClienteJuridico(int nroCliente) throws Exception
	{
		ClienteJuridico cj;
		cj = traerClienteJuridico (nroCliente);
		if(cj==null) {throw new Exception ("Error: El cliente con el numero de cliente " + nroCliente + " no esta registrado");}

		listaClienteJuridico.remove(cj);
	}

	///////////////////// METODOS ZONA ////////////////////
	public Zona traerZona (int codZona) throws Exception {

		for(Zona zn : listaZona) {
			if(zn.getCodZona()==codZona)
				return zn;
		}

		throw new Exception ("Error: Zona con el codigo " + codZona + " no esta registrado");
	}

	public void agregarZona (int codZona, String nombre, List<Inspector> inspectores) throws Exception
	{

		for(Zona zn : this.listaZona) {
			if(codZona==zn.getCodZona()) {throw new Exception ("Error: Zona con el codigo " + codZona + " ya esta registrado");}
		}

		if(listaZona.isEmpty() == true) {
			Zona a = new Zona (1, nombre, inspectores);
			this.listaZona.add(a);
		} else {
			Zona a = new Zona ((this.listaZona.get(listaZona.size()-1).getCodZona()+1), nombre, inspectores);
			this.listaZona.add(a);
		}

	}

	public void modificarZona(int codZona, String nombre, List <Inspector> inspectores) throws Exception
	{
		Zona zn;
		zn = traerZona (codZona);
		if(zn==null) {throw new Exception ("Error: Zona con el codigo " + codZona + " no esta registrado");}

		zn.setCodZona(codZona);
		zn.setNombre(nombre);
		zn.setListInspectores(inspectores);
	}

	public void eliminarZona(int codZona) throws Exception
	{
		Zona zn;
		zn = traerZona (codZona);
		if(zn==null) {throw new Exception ("Error: Zona con el codigo " + codZona + " no esta registrado");}

		listaZona.remove(zn);
	}

	////////////METODOS MEDIDOR///////////////////

	public Medidor traerMedidor (int nroSerie) throws Exception {

		for(Medidor md : listaMedidor) {
			if(md.getNroSerie()==nroSerie)
				return md;
		}

		throw new Exception("Error: El medidor con el numero de serie " + nroSerie + " no esta registrado");
	}

	public void agregarMedidor (Cliente cliente, int nroSerie, String domicilioMedidor, boolean esBaja, Tarifa tarifa,Zona zona) throws Exception
	{

		for(Medidor md : this.listaMedidor) {
			if(nroSerie==md.getNroSerie()) {throw new Exception ("Error: El medidor con con el numero de serie " + nroSerie + " ya esta registrado");}
		}

		Medidor m = new Medidor (cliente, nroSerie, domicilioMedidor, esBaja, tarifa,zona);
		this.listaMedidor.add(m);

	}

	public void modificarMedidor(Cliente cliente, int nroSerie, String domicilioMedidor, boolean esBaja, Tarifa tarifa,Zona zona) throws Exception
	{
		Medidor md;
		md = traerMedidor (nroSerie);
		if(md==null) {throw new Exception("Error: El medidor con con el numero de serie " + nroSerie + " no esta registrado");}

		md.setCliente(cliente);
		md.setDomicilioMedidor(domicilioMedidor);
		md.setEsBaja(esBaja);
		md.setTarifa(tarifa);
		md.setZona(zona);
	}

	public void eliminarMedidor(int nroSerie) throws Exception
	{
		Medidor md;
		md = traerMedidor (nroSerie);
		if(md==null) {throw new Exception("Error: El medidor con con el numero de serie " + nroSerie + " no esta registrado");}

		listaMedidor.remove(md);
	}

	/////////////METODOS LECTURA//////////////

	public Lectura traerLectura(int codLectura) throws Exception {
		Lectura l;
		for(Lectura lec : listaLectura)
			if(lec.getCodLectura() == codLectura)
			{
				l = lec;
				return l;
			}

		throw new Exception ("Error: Lectura con el codigo " + codLectura + " no esta registrado");
	}

	public Lectura traerLectura(Medidor medidor, int mes, int anio) throws Exception
	{
		if (medidor.isEsBaja()==true) {
			for(Lectura  b : listaLectura)
			{
				if(b.getMedidor()==medidor && b.getFecha().getMonthValue() == mes && b.getFecha().getYear() == anio)
				{
					return b;
				}
			}

			throw new Exception ("No existe la lectura con el medidor y la fecha ingresada");
		}
		if (medidor.isEsBaja()==false) {
			for(Lectura  a : listaLectura)
			{
				if(a.getMedidor()==medidor && a.getFecha().getMonthValue() == mes && a.getFecha().getYear() == anio)
				{
					return a;
				}
			}
		}
		throw new Exception ("No existe la lectura con el medidor y la fecha ingresada");
	}

	public void agregarLectura (Medidor medidor,LocalDate fecha, Inspector inspector, double kwh) throws Exception {

		for (Lectura l: listaLectura) {
			if(l.getMedidor() == medidor && l.getFecha() == fecha) throw new Exception ("La lectura del medidor con el numero de serie: "+medidor.getNroSerie()+" en la fecha: "+fecha+" ya esta registrada");

		}
		if(listaLectura.isEmpty() == true) {
			Baja b = new Baja(1,medidor,fecha,inspector,kwh);
			listaLectura.add(b);
		} else {
			Baja b = new Baja((listaLectura.get(listaLectura.size()-1).codLectura+1),medidor,fecha,inspector,kwh);
			listaLectura.add(b);
		} 
	}

	public void agregarLectura (Medidor medidor,LocalDate fecha, Inspector inspector, double kwhPico, double kwhResto, double kwhValle) throws Exception {

		for (Lectura l: listaLectura) {
			if(l.getMedidor() == medidor && l.getFecha() == fecha) throw new Exception ("La lectura del medidor con el numero de serie: "+medidor.getNroSerie()+" en la fecha: "+fecha+" ya esta registrada");

		}
		if(listaLectura.isEmpty() == true) {
			Alta a = new Alta(1,medidor,fecha,inspector,kwhPico, kwhResto, kwhValle);
			listaLectura.add(a);
		} else {
			Alta a = new Alta((listaLectura.get(listaLectura.size()-1).codLectura+1),medidor,fecha,inspector,kwhPico, kwhResto, kwhValle);
			listaLectura.add(a);
		} 
	}

	public void modificarLectura (int codLectura,Medidor medidor,LocalDate fecha,Inspector inspector, double kwh) throws Exception{
		Lectura l;
		l = traerLectura(codLectura);
		if(l == null) 
		{throw new Exception ("Error: Lectura con el codigo " + codLectura + " no esta registrado");}
		if (l instanceof Baja) {
			l.setMedidor(medidor);
			l.setFecha(fecha);
			l.setInspector(inspector);		
			((Baja) l).setKwh(kwh);
		}
	}

	public void modificarLectura (int codLectura,Medidor medidor,LocalDate fecha,Inspector inspector, double kwhPico, double kwhResto, double kwhValle) throws Exception{
		Lectura l;
		l = traerLectura(codLectura);
		if(l == null) 
		{throw new Exception ("Error: Lectura con el codigo " + codLectura + " no esta registrado");}
		if (l instanceof Alta) {
			l.setMedidor(medidor);
			l.setFecha(fecha);
			l.setInspector(inspector);		
			((Alta) l).setKwhPico(kwhPico);
			((Alta) l).setKwhResto(kwhResto);
			((Alta) l).setKwhValle(kwhValle);}
	}

	public void eliminarLectura(int codLectura)throws Exception
	{
		Lectura l;
		l = traerLectura(codLectura);
		if(l == null) 
		{throw new Exception ("Error: Lectura con el codigo " + codLectura + " no esta registrado");}

		listaLectura.remove(l);
	}

	//////////////////////METODOS TARIFA////////////////////

	public Tarifa traerTarifa(int id) throws Exception
	{
		for(Tarifa t : listaTarifa)
		{
			if(t.getId() == id)
			{
				return t;
			}
		}

		throw new Exception ("Error: La tarifa con el id " + id + " no esta registrado");
	}

	public void agregarTarifa (int id, String servicio) throws Exception
	{
		for(Tarifa f : listaTarifa)
		{
			if(f.getId()==id)
			{
				throw new Exception ("Error: La tarifa con el id " + id + " ya esta registrado");
			}
		}

		if(listaTarifa.isEmpty() == true) {
			Tarifa tarifa = new Tarifa(servicio,1);
			listaTarifa.add(tarifa);
		}else {
			Tarifa tarifa = new Tarifa(servicio,(listaTarifa.get(listaTarifa.size()-1).getId()+1));
			listaTarifa.add(tarifa);
		}

	}

	public void modificarTarifa (int id, String servicio) throws Exception
	{
		Tarifa f = traerTarifa(id);
		if (f == null) 
		{throw new Exception ("Error: La tarifa con el id " + id + " no esta registrado");}

		f.setServicio(servicio);
	}

	public void eliminarTarifa (int id) throws Exception
	{
		Tarifa tarifa;
		tarifa = traerTarifa(id);

		if(tarifa == null) 
		{throw new Exception ("Error: La tarifa con el id " + id + " no esta registrado");}

		listaTarifa.remove(tarifa);
	}

	////////////////////METODOS FACTURA/////////////////////////

	public void agregarFactura (int nroFactura, int nroCliente, String datosClientes, Zona zona, int nroMedidor, LocalDate fechaFactura, LocalDate fechaDeVencimiento, List<ItemFactura> listaItemFactura, double total) throws Exception {
		for(Factura f : listaFactura) {
			if(f.getNroFactura() == nroFactura) {
				throw new Exception ("Ya existe la factura nro: " + nroFactura);
			}
		}

		if(listaFactura.isEmpty()) {
			Factura factura = new Factura(1,nroCliente,datosClientes,zona,nroMedidor,fechaFactura,fechaDeVencimiento,listaItemFactura,total);
			listaFactura.add(factura);
		} else {
			Factura factura = new Factura(listaFactura.get(listaFactura.size()-1).getNroFactura()+1,nroCliente,datosClientes,zona,nroMedidor,fechaFactura,fechaDeVencimiento,listaItemFactura, total);
			listaFactura.add(factura);
		}
	}

	public Factura traerFactura (int nroFactura) throws Exception {
		for(Factura f : listaFactura)
		{
			if(f.getNroFactura() == nroFactura)
			{
				return f;
			}
		}	throw new Exception ("No existe una factura con el numero de la factura " + nroFactura);
	}

	public void modificarFactura (int nroFactura, int nroCliente, String datosClientes, Zona zona, int nroMedidor, LocalDate fechaFactura, LocalDate fechaDeVencimiento, List<ItemFactura> listaItemFactura) throws Exception {
		Factura f;
		f = traerFactura(nroFactura);
		if(f == null) {
			throw new Exception ("No existe la factura con el numero de factura " + nroFactura);
		}

		f.setNroCliente(nroCliente);
		f.setDatosClientes(datosClientes);
		f.setZona(zona);
		f.setNroMedidor(nroMedidor);
		f.setFechaFactura(fechaFactura);
		f.setFechaDeVencimiento(fechaDeVencimiento);
		f.setListaItemFactura(listaItemFactura);
	}

	public void eliminarFactura(int nroFactura) throws Exception {
		Factura factura;
		factura = traerFactura(nroFactura);
		if(factura.equals(null)) {
			throw new Exception ("No existe la factura con el numero de la factura" + nroFactura);
		}

		listaFactura.remove(factura);
	}

	/////////////////REPORTES/////////////

	public void consumoClienteFecha (Cliente cliente, LocalDate fecha1, LocalDate fecha2) throws Exception {
		//pido cliente y las fechas en las que analizar

		if (cliente instanceof ClienteFisico) { //instancio cliente en cliente fisico

			ClienteFisico cf = traerClienteFisico(cliente.getNroCliente()); //traigo cliente

			double consumo1=0;
			double consumo2=0;
			double aux=0;

			for(Factura f: listaFactura){
				if(f.getNroCliente()==cliente.getNroCliente())
					if(f.getFechaFactura().getMonth()==fecha1.getMonth()) {
						consumo1 = f.getListaItemFactura().get(0).getCantidad();				
					}
				if(f.getNroCliente()==cliente.getNroCliente())
					if(f.getFechaFactura().getMonth()==fecha2.getMonth()) {
						consumo2 = f.getListaItemFactura().get(0).getCantidad();				
					}
			}

			if(fecha1.isAfter(fecha2)) {//SI LA PRIMERA FECHA ES MAYOR (Por ejemplo buscar de Abril 2019 a Enero 2019) CAMBIO EL ORDEN DE LOS DATOS
				aux = consumo1;
				consumo1 = consumo2;
				consumo2 = aux;
			}

			double consumototal;
			consumototal = consumo2-consumo1; //calculo diferencia de consumos
			System.out.println ("El consumo del cliente de nro. " + cf.getNroCliente() +", "+ cf.getDatosPersonales().getApellido() + 
					" " +cf.getDatosPersonales().getNombre() + ", entre las fechas " + fecha1 + " y " + fecha2 + " es de "+ consumototal + " kWh.");
		}

		else if (cliente instanceof ClienteJuridico) { //instancio en cliente juridico

			ClienteJuridico cj = traerClienteJuridico(cliente.getNroCliente()); //traigo clientes, inicializo variables

			double consumoPico1 = 0;
			double consumoResto1 = 0;
			double consumoValle1 = 0;

			double consumoPico2 = 0;
			double consumoResto2 = 0;
			double consumoValle2 = 0;

			double aux1=0,aux2=0,aux3=0;

			for(Factura f: listaFactura){
				if(f.getNroCliente()==cliente.getNroCliente()&&f.getFechaFactura().getMonth()==fecha1.getMonth()) {
					consumoPico1 = f.getListaItemFactura().get(1).getCantidad();
					consumoValle1 = f.getListaItemFactura().get(2).getCantidad();				
					consumoResto1 = f.getListaItemFactura().get(3).getCantidad();				

				}
				if(f.getNroCliente()==cliente.getNroCliente()&&f.getFechaFactura().getMonth()==fecha2.getMonth()) {
					consumoPico2 = f.getListaItemFactura().get(1).getCantidad();
					consumoValle2 = f.getListaItemFactura().get(2).getCantidad();				
					consumoResto2 = f.getListaItemFactura().get(3).getCantidad();			
				}
			}

			if(fecha1.isAfter(fecha2)) { //SI LA PRIMERA FECHA ES MAYOR (Por ejemplo buscar de Abril 2019 a Enero 2019) CAMBIO EL ORDEN DE LOS DATOS

				aux1 = consumoPico1;
				aux2 = consumoResto1;
				aux3 = consumoValle1;

				consumoPico1 = consumoPico2;
				consumoResto1 = consumoResto2;
				consumoValle1 =  consumoValle2;

				consumoPico2 = aux1;
				consumoResto2 = aux2;
				consumoValle2 = aux3;
			}
			//calculo las diferencias e imprimo
			double consumoPicoTotal = consumoPico2 - consumoPico1;
			double consumoRestoTotal = consumoResto2 - consumoResto1;
			double consumoValleTotal = consumoValle2 - consumoValle1;
			System.out.println ("El consumo del cliente de nro. " + cj.getNroCliente() + ", " + cj.getNombreEmpresa()  
			+ ", entre las fechas " + fecha1 + " y " + fecha2 + " es de:" + "\n\tPico: " + consumoPicoTotal +  
			" kWh\n\tResto: " + consumoRestoTotal + " kWh\n\tValle: " + consumoValleTotal + " kWh.");
		}

	}

	public void facturaEntreFechas (LocalDate fecha1, LocalDate fecha2) { //pido fechas en las cuales buscar facturas

		List<Factura> listaFactura2 = new ArrayList<Factura>(); //inicializo nuevo array de facturas

		if(fecha1.isAfter(fecha2)) { //comparo las fechas
			for(Factura f : this.listaFactura) {
				for(int i = fecha1.getMonthValue() ; i<=fecha2.getMonthValue() ; i++) {
					if(f.getFechaFactura().getMonthValue() == i) {
						listaFactura2.add(f); //añado a la lista secundaria las que cumplen las condiciones
					}
				}
			}
			System.out.println(listaFactura2.toString()); //imprimo la segunda lista
		} else System.out.println(("No existe factura con las fechas" + fecha1 + " y " + fecha2));


		for(Factura f : this.listaFactura) {
			for(int i = fecha2.getMonthValue() ; i<=fecha1.getMonthValue() ; i++) {
				if(f.getFechaFactura().getMonthValue() == i) {
					listaFactura2.add(f);
				}
			}
		}

		System.out.println(listaFactura2.toString());
	}

	public void energiaTotalEntreFechas (LocalDate fecha1, LocalDate fecha2) throws Exception {

		double consumo = 0; //pido las fechas en las que buscar, inicializo la variable consumo

		for(Medidor m : listaMedidor) { //busco en la lista de medidores los de baja demanda y calculo consumos
			if(m.isEsBaja()==true) {
				Baja b1,b2;
				b1 = (Baja) traerLectura(m,fecha1.getMonthValue(),fecha1.getYear());
				b2 = (Baja) traerLectura(m,fecha2.getMonthValue(),fecha2.getYear());

				if(fecha1.isAfter(fecha2)) { //SI LA PRIMERA FECHA ES MAYOR (Por ejemplo buscar de Abril 2019 a Enero 2019) 
					consumo = consumo + (b1.getKwh() - b2.getKwh());	
				}
				else { //SI LA PRIMERA FECHA ES MENOR (Por ejemplo buscar de Enero 2019 a Abril 2019) CAMBIO EL ORDEN DE LOS DATOS
					consumo = consumo + (b2.getKwh() - b1.getKwh());
				}
			}
			if(m.isEsBaja()==false) { //busco entre los de alta demanda y calculo consumos
				Alta a1,a2;

				a1 = (Alta) traerLectura(m,fecha1.getMonthValue(),fecha1.getYear());
				a2 = (Alta) traerLectura(m,fecha2.getMonthValue(),fecha2.getYear());

				if(fecha1.isAfter(fecha2)) { //SI LA PRIMERA FECHA ES MAYOR (Por ejemplo buscar de Abril 2019 a Enero 2019) 
					consumo = consumo + (a1.getKwhPico() - a2.getKwhPico());
					consumo = consumo + (a1.getKwhResto() - a2.getKwhResto());
					consumo = consumo + (a1.getKwhValle() - a2.getKwhValle());
				}
				else { //SI LA PRIMERA FECHA ES MENOR (Por ejemplo buscar de Enero 2019 a Abril 2019) CAMBIO EL ORDEN DE LOS DATOS
					consumo = consumo + (a2.getKwhPico() - a1.getKwhPico());
					consumo = consumo + (a2.getKwhResto() - a1.getKwhResto());
					consumo = consumo + (a2.getKwhValle() - a1.getKwhValle());
				}

			} 
		}

		System.out.println("La energia total entregada entre " + fecha1 + " y " + fecha2 + " es de " + consumo + " kWh.");
	}

	public void energiaPorBandaTarifa (LocalDate fecha1, LocalDate fecha2) throws Exception{
		double consumoBaja = 0;
		double consumoPico = 0;
		double consumoResto = 0;
		double consumoValle = 0;

		for(Medidor m : listaMedidor) { //busco en la lista de medidores con tarifa en bajo
			if(m.isEsBaja()==true) {
				Baja b1,b2;
				b1 = (Baja) traerLectura(m,fecha1.getMonthValue(),fecha1.getYear());
				b2 = (Baja) traerLectura(m,fecha2.getMonthValue(),fecha2.getYear());

				if(fecha1.isAfter(fecha2)) { //SI LA PRIMERA FECHA ES MAYOR (Por ejemplo buscar de Abril 2019 a Enero 2019) 
					consumoBaja = consumoBaja + (b1.getKwh() - b2.getKwh());	
				}
				else { //SI LA PRIMERA FECHA ES MENOR (Por ejemplo buscar de Enero 2019 a Abril 2019) CAMBIO EL ORDEN DE LOS DATOS
					consumoBaja = consumoBaja + (b2.getKwh() - b1.getKwh());
				}
			}
			if(m.isEsBaja()==false) { //busco en la lista de medidores con tarifa en alta
				Alta a1,a2;

				a1 = (Alta) traerLectura(m,fecha1.getMonthValue(),fecha1.getYear());
				a2 = (Alta) traerLectura(m,fecha2.getMonthValue(),fecha2.getYear());

				if(fecha1.isAfter(fecha2)) { //SI LA PRIMERA FECHA ES MAYOR (Por ejemplo buscar de Abril 2019 a Enero 2019) 
					consumoPico = consumoPico + (a1.getKwhPico() - a2.getKwhPico());
					consumoResto = consumoResto + (a1.getKwhResto() - a2.getKwhResto());
					consumoValle = consumoValle + (a1.getKwhValle() - a2.getKwhValle());
				}
				else { //SI LA PRIMERA FECHA ES MENOR (Por ejemplo buscar de Enero 2019 a Abril 2019) CAMBIO EL ORDEN DE LOS DATOS
					consumoPico = consumoPico + (a2.getKwhPico() - a1.getKwhPico());
					consumoResto = consumoResto + (a2.getKwhResto() - a1.getKwhResto());
					consumoValle = consumoValle + (a2.getKwhValle() - a1.getKwhValle());
				}

			}
		}
		System.out.println(" El consumo total por banda tarifaria entre " + fecha1 + " y " + fecha2 + " es de: \n" + "\tConsumo baja demanda: " + 
				consumoBaja + " kWh\n\tConsumo Pico: " + consumoPico + " kWh\n\tConsumo Resto: " + consumoResto + " kWh\n\tConsumo Valle: " + consumoValle + " kWh.");
	}

	public void estadisticasFacturacionMes(LocalDate fecha) throws Exception {

		List<Factura> listaFactura2 = new ArrayList<Factura>(); //inicializo segunda lista de facturas y variables auxiliares

		double consumo=0;
		int facturasemitidas=0;
		double dinerofacturado=0;
		for(Factura f : this.listaFactura) { //recorro la lista, poniendo como condicion que se trate del mismo mes
			if(f.getFechaFactura().getMonth() == fecha.getMonth()) {
				listaFactura2.add(f); //añado a la lista secundaria
			}
		}
		for (Factura f : listaFactura2) {
			Medidor m = traerMedidor(f.getNroMedidor());
			if(m.isEsBaja()==true) { //recorro la lista secundaria, busco en los medidores de baja demanda y calculo consumo.
				for (int a=0; a<1; a++) { 
					consumo= consumo + (f.getListaItemFactura().get(a).getCantidad());
				}
			}
			if(m.isEsBaja()==false) { //busco en la lista de medidores de alta demanda y calculo consumo
				for(int a=1; a<4; a++) {
					consumo = consumo + (f.getListaItemFactura().get(a).getCantidad());
				}
			}

			facturasemitidas++; //contador para saber la cantidad de facturas emitidas
			dinerofacturado= dinerofacturado + calcularTotal(f.getListaItemFactura(),m); //calculo total del dinero facturado 

		}

		if(listaFactura2.isEmpty()) {
			throw new Exception ("No existe la factura con el mes: " + fecha.getMonthValue() + "-" + fecha.getYear()); //declaro excepcion, no existe facturas para el mes seleccionado
		}
		//imprimo informacion
		System.out.println("Mes: " + fecha.getMonthValue() + "-" + fecha.getYear() + "\nCantidad de kWh consumidos en el mes: " + consumo +" kWh."+ "\nCantidad de facturas emitidas: " + facturasemitidas + ".\nCantidad total de dinero facturado: $" + dinerofacturado);
	}

	public void mayorConsumoHorarioPico (int limite) throws Exception {
		//declaro variables auxiliares
		List<Factura> listaFactura2 = new ArrayList<Factura>();
		List<Double> listacantidad = new ArrayList<Double>();
		List<ClienteJuridico> listaCj = new ArrayList<ClienteJuridico>();
		for(Factura f : listaFactura) { //entro a toda la lista de facturas y añado en otra lista las que son de alta demanda
			Medidor m;
			m = traerMedidor(f.getNroMedidor()); 
			if(m.isEsBaja() == false) {
				listaFactura2.add(f);
			}
		}
		for (Factura f: listaFactura2) { //entro a las alta demanda y agrego en una lista las cantidades, despues las ordeno de menor a mayor
			double a= f.getListaItemFactura().get(1).getCantidad();
			if(a >= limite) {
				listacantidad.add(a);
			}
			Collections.sort(listacantidad);	
		}
		for (int a=0; a<=listaFactura2.size()-1; a++) { //Entro a la lista cantidad, recorriendo la cantidad de veces necesarias
			for(int i =listacantidad.size()-1; i>=0;  i--) { //recorro la lista ordenada al reves, para que me imprima de mayor a menos
				if(listaFactura2.get(a).getListaItemFactura().get(1).getCantidad()==listacantidad.get(i)) { //si la cantidad de item factura en esa posicion, es igual a la cantidad de lista cliente, entonces saco cliente
					ClienteJuridico cj = traerClienteJuridico(listaFactura2.get(a).getNroCliente());//inicio cliente e imprimo
					if(listaCj.contains(cj) == false) {
						listaCj.add(cj);
						System.out.println("Consumo: " +listacantidad.get(i)+ " Cliente: " + cj.getNombreEmpresa()+ " en el mes: "+listaFactura2.get(a).getFechaDeVencimiento().getMonthValue());
					}
				}
			}
		}
	}

	public double calcularConsumoCliente(Cliente cliente) {
		double consumo=0;
		if(cliente instanceof ClienteFisico) {
			for (Factura f : listaFactura) {
				if(f.getNroCliente()==cliente.getNroCliente()) {
					consumo = f.getListaItemFactura().get(0).getCantidad();
					return consumo;
				}
			}
		}
		if(cliente instanceof ClienteJuridico) {
			for(Factura f : listaFactura) {
				if(f.getNroCliente()==cliente.getNroCliente()) {
					for(int a=1; a<4; a++) {
						consumo = consumo + f.getListaItemFactura().get(a).getCantidad();	
					}
					return consumo;
				}
			}
		}
		return consumo;
	}

	public void diezClientesMayorConsumo() throws Exception {

		List<Double> listaconsumo = new ArrayList<Double>();

		for(Factura f : listaFactura) {
			if(traerMedidor(f.getNroMedidor()).isEsBaja()==true){
				listaconsumo.add(calcularConsumoCliente(traerClienteFisico(f.getNroCliente())));
			}
			else {
				listaconsumo.add(calcularConsumoCliente(traerClienteJuridico(f.getNroCliente())));
			}
		}
		Collections.sort(listaconsumo);
		while(listaconsumo.isEmpty()==false) {
			for(Factura f: listaFactura) {
				if(traerMedidor(f.getNroMedidor()).isEsBaja()==true){
					if(calcularConsumoCliente(traerClienteFisico(f.getNroCliente()))==listaconsumo.get(listaconsumo.size()-1)) {
						System.out.println("El cliente "+f.getNroCliente()+", " + traerClienteFisico(f.getNroCliente()).getDatosPersonales().getNombre()+" "+traerClienteFisico(f.getNroCliente()).getDatosPersonales().getApellido()+" consumio: "+listaconsumo.get(listaconsumo.size()-1));
						listaconsumo.remove(listaconsumo.size()-1);
					}
				}
				if(traerMedidor(f.getNroMedidor()).isEsBaja()==false){
					if(calcularConsumoCliente(traerClienteJuridico(f.getNroCliente()))==listaconsumo.get(listaconsumo.size()-1)) {
						System.out.println("El cliente nro. "+f.getNroCliente()+", "+traerClienteJuridico(f.getNroCliente()).getNombreEmpresa()+" consumió: "+listaconsumo.get(listaconsumo.size()-1) + " kwh.");
						listaconsumo.remove(listaconsumo.size()-1);
					}
				}
			}

		}
	}


	public double calcularSubTotal (Medidor m,ItemFactura item) throws Exception { //calculo sub total

		// -------------- SUBTOTAL BAJA ------------ //

		if (m.isEsBaja() == true) {

			TarifaBaja tb;
			tb = (TarifaBaja) traerTarifa(1); //ingreso en tarifa baja, inicializo la variable

			if(item.getDetalleFactura() == "Cargo Variable") { //entro a cargo variable
				for(DetalleBaja d : tb.getListDetalle()) //recorro lista detalle baja
				{
					double variable = 0; double subtotal = 0; 
					if(d.getDetalleConcepto().contains("Cargo Variable"))
					{
						if(item.getCantidad() >= d.getDesde() && item.getCantidad() <= d.getHasta()) //impongo condiciones de minimo y maximos de kwhs
						{
							variable = d.getValor();
							subtotal = variable * item.getCantidad();
							item.setPrecio(subtotal);
							return subtotal; //calculo subtotal multiplicando la cantidad por el valor variable expresado en detalle baja
						}
					}
				}
			}

			if(item.getDetalleFactura() == "Cargo Fijo") { //entro a cargo fijo
				for(DetalleBaja d : tb.getListDetalle()) //recorro detalle baja
				{
					double fijo = 0; 
					if(d.getDetalleConcepto().contains("Cargo Fijo"))
					{
						if(item.getCantidad() >= d.getDesde() && item.getCantidad() <= d.getHasta())
						{
							fijo = d.getValor();
							item.setPrecio(fijo); //seteo el valor de precio 
							return fijo;
						}
					}
				}
			}
		}


		// -------------- SUBTOTAL ALTA ------------ //

		if (m.isEsBaja() == false) { //ingreso en medidores de alta tension

			if(m.getTarifa().getId()==2) { //tarifa alta de id 2, BT

				// CALCULAR SUBTOTAL DE TARIFA ALTA BAJA TENSION.
				TarifaAlta tarifaAltaBt;
				tarifaAltaBt = (TarifaAlta) traerTarifa(2); //traigo tarifa por id

				for(DetalleAlta d  : tarifaAltaBt.getListDetalle()) { //recorro lista detalle alta

					if(item.getDetalleFactura()=="Cargo Variable Pico") { //busco el item factura correspondiente
						if(item.getCantidad() <= tarifaAltaBt.getLimite())
						{
							if(d.getDetalleConcepto().contains("Cargo Variable Pico"))
							{

								double	variable = d.getValor();
								double subtotal = variable * item.getCantidad();
								item.setPrecio(subtotal); //calculo precio multiplicando variable por cantidad de kwhs gastados
								return subtotal;
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Resto") {
						if(item.getCantidad() <= tarifaAltaBt.getLimite())
						{
							if(d.getDetalleConcepto().contains("Cargo Variable Resto"))
							{

								double	variable = d.getValor();
								double subtotal = variable * item.getCantidad();
								item.setPrecio(subtotal);
								return subtotal;
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Valle") {
						if(item.getCantidad() <= tarifaAltaBt.getLimite()) //reviso limite
						{
							if(d.getDetalleConcepto().contains("Cargo Variable Valle"))
							{

								double	variable = d.getValor();
								double subtotal = variable * item.getCantidad();
								item.setPrecio(subtotal);
								return subtotal;
							}
						}
					}


					if(item.getDetalleFactura()=="Cargo Fijo") { //entro en cargo fijo
						if(item.getCantidad() <= tarifaAltaBt.getLimite()) //reviso limite
						{
							if(d.getDetalleConcepto().contains("Cargo Fijo"))
							{

								double	fijo = d.getValor();
								item.setPrecio(fijo);
								item.setCantidad(1); //seteo precio y cantidad dependiendo de la lista detalle alta
								return fijo;
							}
						}
					}


					if(item.getDetalleFactura()=="Cargo Variable Pico") {
						if(item.getCantidad() > tarifaAltaBt.getLimite())
						{
							if(d.isSuperaLimite()==true) {
								if(d.getDetalleConcepto().contains("Cargo Variable Pico"))
								{
									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}


					if(item.getDetalleFactura()=="Cargo Variable Resto") {
						if(item.getCantidad() > tarifaAltaBt.getLimite())
						{
							if(d.isSuperaLimite()==true) {
								if(d.getDetalleConcepto().contains("Cargo Variable Resto"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Valle") {
						if(item.getCantidad() > tarifaAltaBt.getLimite())
						{
							if(d.isSuperaLimite()==true) {
								if(d.getDetalleConcepto().contains("Cargo Variable Valle"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Fijo") {
						if(item.getCantidad() > tarifaAltaBt.getLimite())
						{
							if(d.isSuperaLimite()==true) {
								if(d.getDetalleConcepto().contains("Cargo Variable Fijo"))
								{

									double	fijo = d.getValor();
									item.setPrecio(fijo);
									item.setCantidad(1);
									return	fijo;
								}
							}
						}

					}
				}
			}
			// CALCULAR SUBTOTAL DE TARIFA ALTA DE MEDIA TENSION.
			if(m.getTarifa().getId()==3) {

				TarifaAlta tarifaAltaMt;
				tarifaAltaMt = (TarifaAlta) traerTarifa(3);

				for(DetalleAlta d  : tarifaAltaMt.getListDetalle()) {

					if(item.getDetalleFactura()=="Cargo Variable Pico") {
						if(item.getCantidad() <= tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Pico"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Resto") {
						if(item.getCantidad() <= tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Resto"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Valle") {
						if(item.getCantidad() <= tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Valle"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}


					if(item.getDetalleFactura()=="Cargo Fijo") {
						if(item.getCantidad() <= tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Fijo"))
								{
									double	fijo = d.getValor();
									item.setPrecio(fijo);
									item.setCantidad(1);
									return	fijo;
								}
							}
						}
					}


					if(item.getDetalleFactura()=="Cargo Variable Pico") {
						if(item.getCantidad() > tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Pico"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Resto") {
						if(item.getCantidad() > tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Resto"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Valle") {
						if(item.getCantidad() > tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Valle"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Fijo") {
						if(item.getCantidad() > tarifaAltaMt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Fijo"))
								{
									double	fijo = d.getValor();
									item.setPrecio(fijo);
									item.setCantidad(1);
									return	fijo;
								}
							}
						}
					}
				}
			}

			// CALCULAR SUBTOTAL DE TARIFA ALTA DE ALTA TENSION.
			if(m.getTarifa().getId()==4) {

				TarifaAlta tarifaAltaAt;
				tarifaAltaAt = (TarifaAlta) traerTarifa(4);

				for(DetalleAlta d  : tarifaAltaAt.getListDetalle()) {

					if(item.getDetalleFactura()=="Cargo Variable Pico") {
						if(item.getCantidad() <= tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Pico"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Resto") {
						if(item.getCantidad() <= tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Resto"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Valle") {
						if(item.getCantidad() <= tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Valle"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}


					if(item.getDetalleFactura()=="Cargo Fijo") {
						if(item.getCantidad() <= tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==false)
							{
								if(d.getDetalleConcepto().contains("Cargo Fijo"))
								{
									double	fijo = d.getValor();
									item.setPrecio(fijo);
									item.setCantidad(1);
									return	fijo;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Pico") {
						if(item.getCantidad() > tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Pico"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Variable Resto") {
						if(item.getCantidad() > tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Resto"))
								{
									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}
					if(item.getDetalleFactura()=="Cargo Variable Valle") {
						if(item.getCantidad() > tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Variable Valle"))
								{

									double	variable = d.getValor();
									double subtotal = variable * item.getCantidad();
									item.setPrecio(subtotal);
									return subtotal;
								}
							}
						}
					}

					if(item.getDetalleFactura()=="Cargo Fijo") {
						if(item.getCantidad() > tarifaAltaAt.getLimite()) {
							if(d.isSuperaLimite()==true)
							{
								if(d.getDetalleConcepto().contains("Cargo Fijo"))
								{
									double fijo = d.getValor();
									item.setPrecio(fijo);
									item.setCantidad(1);
									return	fijo;
								}
							}
						}
					}
				}
			}
		}

		throw new Exception ("No existe medidor o ItemFactura"); //declaro excepcion, no existe el medidor o la factura
	}

	public double calcularTotal (List <ItemFactura> lista, Medidor m) throws Exception { //calculo total con los item facturas y el medidor

		double total = 0;
		for(ItemFactura l : lista)
		{
			total= total + this.calcularSubTotal(m,l); //dependiendo del tamaño de la lista se suma todas las veces que sea necesaria
		}
		return total;
	}

	public double diferencia(Medidor medidor,int mes,int anio) throws Exception //calcula la diferencia de kwhs entre diferentes lecturas
	{
		Baja b1 = null,b2 = null; 
		double kwh1,kwh2,diferencia;

		if (mes%2==0) { //2 4 6 8 10 12

			if (mes >= 4) { //Si es mes es mayor o igual a 4. 4-2019
				b1 = (Baja) traerLectura(medidor,mes,anio); //4-2019
				b2 = (Baja) traerLectura(medidor,(mes-2),anio); //2-2019
			}else if (mes == 2) { //Si mes es 2
				b1 = (Baja) traerLectura(medidor,mes,anio); //2-2019
				b2 = (Baja) traerLectura(medidor,12,anio-1); //12-2018
			}
		}
		if (mes%2!=0) { //1 3 5 7 9 11

			if (mes >= 3) { //Si es mes es mayor o igual a 3. 5-2019
				b1 = (Baja) traerLectura(medidor,(mes+1),anio); //6-2019
				b2 = (Baja) traerLectura(medidor,(mes-1),anio); //4-2019
			}else if (mes == 1) { //Si mes es 1
				b2 = (Baja) traerLectura(medidor,(mes+1),anio); //2-2019
				b1 = (Baja) traerLectura(medidor,12,anio-1); //12-2018	
			}
		}

		kwh1 = b1.getKwh();	//kwh de mes-1
		kwh2 = b2.getKwh();	//kwh de mes-3

		diferencia = kwh1 - kwh2;
		return diferencia;
	}

	public double diferenciaAltaPico (Medidor medidor, int mes, int anio) throws Exception {

		Alta a1 = null,a2 = null; //calcula diferencia entre diferentes lecturas alta del tipo pico
		double kwh1,kwh2,diferencia;


		if (mes%2==0) { //2 4 6 8 10 12

			if (mes >= 4) { //Si es mes es mayor o igual a 4. 4-2019
				a1 = (Alta) traerLectura(medidor,mes,anio); //4-2019
				a2 = (Alta) traerLectura(medidor,(mes-2),anio); //2-2019
			}else if (mes == 2) { //Si mes es 2
				a1 = (Alta) traerLectura(medidor,mes,anio); //2-2019
				a2 = (Alta) traerLectura(medidor,12,anio-1); //12-2018
			}
		}
		if (mes%2!=0) { //1 3 5 7 9 11

			if (mes >= 3) { //Si es mes es mayor o igual a 3. 5-2019
				a1 = (Alta) traerLectura(medidor,(mes+1),anio); //6-2019
				a2 = (Alta) traerLectura(medidor,(mes-1),anio); //4-2019
			}else if (mes == 1) { //Si mes es 1
				a2 = (Alta) traerLectura(medidor,(mes+1),anio); //2-2019
				a1 = (Alta) traerLectura(medidor,12,anio-1); //12-2018	
			}
		}

		kwh1 = a1.getKwhPico();	//kwh de mes-1
		kwh2 = a2.getKwhPico();	//kwh de mes-3

		diferencia = kwh1 - kwh2;
		return diferencia;
	}

	public double diferenciaAltaValle (Medidor medidor, int mes, int anio) throws Exception {

		Alta a1 = null,a2 = null;
		double kwh1,kwh2,diferencia;


		if (mes%2==0) { //2 4 6 8 10 12

			if (mes >= 4) { //Si es mes es mayor o igual a 4. 4-2019
				a1 = (Alta) traerLectura(medidor,mes,anio); //4-2019
				a2 = (Alta) traerLectura(medidor,(mes-2),anio); //2-2019
			}else if (mes == 2) { //Si mes es 2
				a1 = (Alta) traerLectura(medidor,mes,anio); //2-2019
				a2 = (Alta) traerLectura(medidor,12,anio-1); //12-2018
			}
		}
		if (mes%2!=0) { //1 3 5 7 9 11

			if (mes >= 3) { //Si es mes es mayor o igual a 3. 5-2019
				a1 = (Alta) traerLectura(medidor,(mes+1),anio); //6-2019
				a2 = (Alta) traerLectura(medidor,(mes-1),anio); //4-2019
			}else if (mes == 1) { //Si mes es 1
				a2 = (Alta) traerLectura(medidor,(mes+1),anio); //2-2019
				a1 = (Alta) traerLectura(medidor,12,anio-1); //12-2018	
			}
		}

		kwh1 = a1.getKwhValle();	//kwh de mes-1
		kwh2 = a2.getKwhValle();	//kwh de mes-3

		diferencia = kwh1 - kwh2;
		return diferencia;
	}

	public double diferenciaAltaResto (Medidor medidor, int mes, int anio) throws Exception {

		Alta a1 = null,a2 = null;
		double kwh1,kwh2,diferencia;


		if (mes%2==0) { //2 4 6 8 10 12

			if (mes >= 4) { //Si es mes es mayor o igual a 4. 4-2019
				a1 = (Alta) traerLectura(medidor,mes,anio); //4-2019
				a2 = (Alta) traerLectura(medidor,(mes-2),anio); //2-2019
			}else if (mes == 2) { //Si mes es 2
				a1 = (Alta) traerLectura(medidor,mes,anio); //2-2019
				a2 = (Alta) traerLectura(medidor,12,anio-1); //12-2018
			}
		}
		if (mes%2!=0) { //1 3 5 7 9 11

			if (mes >= 3) { //Si es mes es mayor o igual a 3. 5-2019
				a1 = (Alta) traerLectura(medidor,(mes+1),anio); //6-2019
				a2 = (Alta) traerLectura(medidor,(mes-1),anio); //4-2019
			}else if (mes == 1) { //Si mes es 1
				a2 = (Alta) traerLectura(medidor,(mes+1),anio); //2-2019
				a1 = (Alta) traerLectura(medidor,12,anio-1); //12-2018	
			}
		}

		kwh1 = a1.getKwhResto();	//kwh de mes-1
		kwh2 = a2.getKwhResto();	//kwh de mes-3

		diferencia = kwh1 - kwh2;
		return diferencia;
	}

	//////////METODOS FACTURA//////////

	public Factura generarFactura(Medidor medidor, int mes, int anio) throws Exception
	{
		//Si el medidor es baja:
		if(medidor.isEsBaja()==true) //si el medidor es baja
		{	
			double diferencia = diferencia(medidor,mes,anio); //calcula diferencia de lecturas

			ItemFactura uno = new ItemFactura ("Cargo Fijo", "$/mes", diferencia);
			ItemFactura dos = new ItemFactura ("Cargo Variable", "$/kWh", diferencia);
			//calculo los subtotales
			this.calcularSubTotal(medidor,uno);
			this.calcularSubTotal(medidor,dos);

			List <ItemFactura> listaitem = new ArrayList <ItemFactura>();
			listaitem.add(uno);
			listaitem.add(dos);
			//genero fechas
			LocalDate dia1 = LocalDate.of(anio, mes, 10);
			LocalDate dia2 = LocalDate.of(anio, mes, 25);
			//traigo el cliente con el traer
			ClienteFisico cf = traerClienteFisico(medidor.getCliente().getNroCliente());
			//genero factura
			Factura factura = new Factura (contador++, medidor.getCliente().getNroCliente(), (cf.getDatosPersonales().getNombre() +" "+
					cf.getDatosPersonales().getApellido()), medidor.getZona(), medidor.getNroSerie(),dia1, dia2, listaitem, this.calcularTotal(listaitem, medidor));

			this.listaFactura.add(factura);
			return factura;
		}

		if (medidor.isEsBaja()==false) { //el medidor es de tarifa alta
			double diferenciapico = diferenciaAltaPico(medidor, mes, anio);
			double diferenciavalle = diferenciaAltaValle(medidor, mes, anio);
			double diferenciaresto = diferenciaAltaResto(medidor, mes, anio);
			//calculo diferencias

			ItemFactura uno = new ItemFactura ("Cargo Fijo", "$/mes", diferenciapico);
			ItemFactura dos = new ItemFactura ("Cargo Variable Pico", "$/kWh", diferenciapico);
			ItemFactura tres = new ItemFactura ("Cargo Variable Valle", "$/kWh", diferenciavalle);
			ItemFactura cuatro = new ItemFactura ("Cargo Variable Resto", "$/kWh", diferenciaresto);
			//sumo subtotales
			this.calcularSubTotal(medidor,uno);
			this.calcularSubTotal(medidor,dos);
			this.calcularSubTotal(medidor,tres);
			this.calcularSubTotal(medidor,cuatro);

			List <ItemFactura> listaitem = new ArrayList <ItemFactura>();
			listaitem.add(uno);
			listaitem.add(dos);
			listaitem.add(tres);
			listaitem.add(cuatro);
			//declaro fechas
			LocalDate dia1 = LocalDate.of(anio, mes, 05);
			LocalDate dia2 = LocalDate.of(anio, mes, 25);
			//traigo cliente
			ClienteJuridico cj = traerClienteJuridico(medidor.getCliente().getNroCliente());
			//retorno factura
			Factura factura = new Factura (contador++, medidor.getCliente().getNroCliente(), cj.getNombreEmpresa(), medidor.getZona(), medidor.getNroSerie(),dia1, dia2, listaitem, this.calcularTotal(listaitem, medidor));
			this.listaFactura.add(factura);
			return factura;
		}
		return null;
	}	
}