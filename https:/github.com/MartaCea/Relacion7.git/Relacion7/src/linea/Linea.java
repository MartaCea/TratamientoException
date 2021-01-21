package linea;

public class Linea {
	private Punto puntoA;
	private Punto puntoB;
	
	public Linea(Punto puntoA, Punto puntoB) {
		setPuntoA(puntoA);
		setPuntoB(puntoB);
	}

	public Punto getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}
	
	public String toString() {
		return "Linea de " + puntoA + " a " + puntoB;
	}
	
	public void moverDerecha(double moverDer) throws LineaException {
		// excepciones
		if(moverDer < 0) {
			throw new LineaException("Los movimientos no pueden ser negativos");
		}
		if(moverDer == 0) {
			throw new LineaException("El movimiento no puede ser 0 porque sino no se mueve la linea");
		}
		// mover la x de los putnos a y b a la derecha
		this.puntoA.setX(this.puntoA.getX() + moverDer);
		this.puntoB.setX(this.puntoB.getX() + moverDer);
		
	}
	
	public void moverIzquierda(double moverIzq) throws LineaException {
		// excepciones
		if(moverIzq < 0) {
			throw new LineaException("Los movimientos no pueden ser negativos");
		}
		if(moverIzq == 0) {
			throw new LineaException("El movimiento no puede ser 0 porque sino no se mueve la linea");
		}
		// mover la x de los puntos a y b a la izquierda
		this.puntoA.setX(this.puntoA.getX() - moverIzq);
		this.puntoB.setX(this.puntoB.getX() - moverIzq);
	}
	
	public void moverArriba(double moverArriba) throws LineaException {
		// excepciones
		if(moverArriba < 0) {
			throw new LineaException("Los movimientos no pueden ser negativos");
		}
		if(moverArriba == 0) {
			throw new LineaException("El movimiento no puede ser 0 porque sino no se mueve la linea");
		}
		// mover la x de los puntos a y b a la izquierda
		this.puntoA.setY(this.puntoA.getY() + moverArriba);
		this.puntoB.setY(this.puntoB.getY() + moverArriba);
	}
	
	public void moverAbajo(double moverAbajo) throws LineaException {
		// excepciones
		if(moverAbajo < 0) {
			throw new LineaException("Los movimientos no pueden ser negativos");
		}
		if(moverAbajo == 0) {
			throw new LineaException("El movimiento no puede ser 0 porque sino no se mueve la linea");
		}
		// mover la x de los puntos a y b a la izquierda
		this.puntoA.setY(this.puntoA.getY() - moverAbajo);
		this.puntoB.setY(this.puntoB.getY() - moverAbajo);
	}
	
}
