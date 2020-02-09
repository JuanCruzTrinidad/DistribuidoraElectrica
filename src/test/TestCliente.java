package test;
import java.util.ArrayList;
import java.util.List;
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.DatosPersonales;
import modelo.Factura;
import modelo.Lectura;
import modelo.Medidor;
import modelo.Sistema;
import modelo.Tarifa;
import modelo.Zona;

public class TestCliente {

	public static void main(String[] args) throws Exception{

		//Datos Personales para cliente fisico.
		DatosPersonales datos1 = new DatosPersonales("Juancruz","Trinidad",40811021);
		DatosPersonales datos2 = new DatosPersonales("Kevin","Nakandakare",41986557);
		DatosPersonales datos3 = new DatosPersonales("Fernando","Zarate",391444223);
		
		//Lista Cliente Fisico
		List<ClienteFisico> listaCf = new ArrayList<ClienteFisico>();

		//Lista Cliente Juridico
		List<ClienteJuridico> listaCj = new ArrayList<ClienteJuridico>();

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
			//Test para cliente fisico
			System.out.println("Alta:"); //Alta de clientes
			sistema1.agregarClienteFisico("juan@gmail.com", datos1, "27-12345678-6");
			sistema1.agregarClienteFisico("kevin@gmail.com", datos2, "20-41986557-6");
			System.out.println(sistema1.getListaClienteFisico());
			
			System.out.println("Modificacion:"); //Modificacion de clientes
			sistema1.modificarClienteFisico(1, "aeiou@gmail.com", datos3, "11-12345678-22");
			System.out.println(sistema1.getListaClienteFisico());
			
			System.out.println("Eliminar:"); //Eliminar clientes
			sistema1.eliminarClienteFisico(1);
			System.out.println(sistema1.getListaClienteFisico() + "\n\n\n");
			
			
			//Test para cliente juridico
			System.out.println("Alta:");
			sistema1.agregarClienteJuridico("juan@gmail.com", "Trinidad S.A.", "20-88888888-2");
			sistema1.agregarClienteJuridico("tomas@gmail.com", "Silvestre S.A.", "20-34567891-6");
			sistema1.agregarClienteJuridico("luana@gmail.com", "Luana S.A.", "27-12345678-7");
			System.out.println(sistema1.getListaClienteJuridico());
			
			System.out.println("Modificacion:"); //Modifico el mail, nombre de la empresa y cuil del cliente juridico numero 3.
			sistema1.modificarClienteJuridico(3, "aeiou@gmail.com", "Cambiado S.A.", "11-11111111-11");
			System.out.println(sistema1.getListaClienteJuridico());
			
			System.out.println("Eliminar:");
			sistema1.eliminarClienteJuridico(3);
			System.out.println(sistema1.getListaClienteJuridico());
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}


