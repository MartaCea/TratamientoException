import java.util.Scanner;

/**
 * @author Jorge "y0rg" Taranc�n
 * 
 * Clase principal donde se ejecutar� el programa
 * Recoge los datos de la casa por teclado y devuelve un veredicto
 *
 */

/*
 * En la clase �Principal.java� crear un men� que recoja todos los datos: Cliente y Casa y muestre el
veredicto (m�todo veredicto() de la clase Cliente)

 */
public class Principal {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String args[]) {
		Casa casa1;
		Cliente cliente1;
		
		try {
			casa1 = crearCasa();
			cliente1 = crearCliente(casa1);
			
			System.out.println(cliente1.veredicto());
		} catch (CasaImposibleException e) {
			System.out.println(e.getMessage());
		}
		

	}
	public static Casa crearCasa() throws CasaImposibleException {
		Casa casa1;
		int metrosCuad, plantas, bannos, hab;
		boolean piscina, garaje;
		String calidad;
		
		System.out.println("Introduzca los metros cuadrados:");
		metrosCuad = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca el numero de plantas: ");
		plantas = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzcal el numero de habitaciones: ");
		hab = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca el numero de ba�os: ");
		bannos = Integer.parseInt(teclado.nextLine());
		
		System.out.println("¿Quieres piscina?");
		piscina = teclado.nextBoolean(); // nextBoolean() sirve para que el usuario meta por pantalla true o false
		
		
		System.out.println("¿Quieres garaje?");
		garaje = teclado.nextBoolean();
		
		do {
			System.out.println("Introduzca el tipo de calidad (Baja, Media, Alta): ");
			calidad = teclado.nextLine();
			calidad = calidad.toUpperCase();
		}while(calidad != "BAJA" || calidad != "MEDIA" || calidad != "ALTA");
		
		casa1 = new Casa(metrosCuad, plantas, hab, bannos, calidad, piscina, garaje);
		
		return casa1;
	}
	
	public static Cliente crearCliente(Casa casa1) throws CasaImposibleException {
		Cliente cliente1;
		String nombre;
		
		System.out.println("Nombre del cliente:");
		nombre = teclado.nextLine();
		
		cliente1 = new Cliente(nombre, casa1, 100);
		
		return cliente1;
	}
	

}
