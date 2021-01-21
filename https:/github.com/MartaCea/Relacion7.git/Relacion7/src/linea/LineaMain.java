package linea;

import java.util.Scanner;

public class LineaMain {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		boolean terminar = false;
		char answ = 0;
		Linea linea;
		
		try {
			linea = crearLinea();
			do {
				answ = menuLinea();
				answ = Character.toUpperCase(answ);
				terminar = opcionesMenuLinea(answ, linea);
			}while(terminar);
		}catch (LineaException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static Linea crearLinea() {
		Punto puntoA, puntoB;
		Linea linea;
		
		puntoA = crearPunto();
		puntoB = crearPunto();
		
		linea = new Linea(puntoA, puntoB);
		
		return linea;
	}
	
	public static Punto crearPunto() {
		Punto punto;
		double x, y;
		
		System.out.println("Introduzca la X del punto: ");
		x = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduzca la Y del punto: ");
		y = Double.parseDouble(teclado.nextLine());
		punto = new Punto(x, y);
		
		return punto;
	}
	
	public static char menuLinea() {
		char opcion;
		
		System.out.println("1. Mover linea");
		// toString para mostrar linea
		System.out.println("2. Mostrar l�nea");
		System.out.println("3. Salir");
		opcion = teclado.nextLine().charAt(0);
		if(opcion == 1) {
			System.out.println("A(arriba), B(abajo), I(izquierda), D(derecha)");
			opcion = teclado.nextLine().charAt(0);
		}
		
		return opcion;
	}
	
	public static boolean opcionesMenuLinea(char answ, Linea lin) throws LineaException {
		char resp;
		boolean terminar = false;
		
		do {
			switch(answ) {
			case 1: {
				moverLinea(answ, lin);
				break;
			}
			case 2:{
				lin.toString();
				break;
			}
			case 3:{
				System.out.println("Desea salir?");
				resp = teclado.nextLine().charAt(0);
				if(resp == 'S') {
					terminar = true;
				}
			}
			
			}	
		}while(terminar == false);
		
		return terminar;
	}
	
	public static void moverLinea(char opcion, Linea lin) throws LineaException {
		double mover;
		
		
			switch(opcion) {
			case 'A': {
				System.out.println("Cuanto la quieres mover?");
				mover = Double.parseDouble(teclado.nextLine());
				lin.moverArriba(mover);
				break;
			}
			case 'B': {
				System.out.println("Cuanto la quieres mover?");
				mover = Double.parseDouble(teclado.nextLine());
				lin.moverAbajo(mover);
				break;
			}
			case 'I': {
				System.out.println("Cuanto la quieres mover?");
				mover = Double.parseDouble(teclado.nextLine());
				lin.moverIzquierda(mover);
				break;
			}
			case 'D': {
				System.out.println("Cuanto la quieres mover?");
				mover = Double.parseDouble(teclado.nextLine());
				lin.moverDerecha(mover);
				break;
			}
			}
		
		
	}
}
