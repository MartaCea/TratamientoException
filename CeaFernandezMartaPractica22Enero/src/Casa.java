/**
 * @author Jorge "y0rg" Taranc�n
 *
 *	Clase del objeto Casa, definida por los atributos:
 *   � Metros cuadrados: n�mero que indica la cantidad de espacio que se va a construir, m�nimo 1
 *   � Plantas: n�mero de plantas que tendr� la vivienda, m�nimo 1.
 *   � Habitaciones: n�mero de habitaciones que tendr� la vivienda, m�nimo 1.
 *   � Ba�os: n�mero de ba�os que tendr� la vivienda, m�nimo 1.
 *   � Calidades: calidad de los materiales utilizados. Se podr� seleccionar entre �Baja�, �Media� y �Alta�.
 *   � Piscina: si se va a construir tambi�n una piscina.
 *   � Garaje: si se va a construir tambi�n un garaje.
 *
 */
public class Casa {

	public static final String CALIDAD_BAJA = "BAJA";
	public static final String CALIDAD_MEDIA = "MEDIA";
	public static final String CALIDAD_ALTA = "ALTA";
	public static final int PRECIO_BAJA = 700;
	public static final int PRECIO_MEDIA = 800;
	public static final int PRECIO_ALTA = 900;
	public static final int MINIMO_METROS_CUADRADOS = 1;
	public static final int MIN_HAB = 1;
	public static final int MIN_BANNOS = 1;
	public static final int MIN_PLANTAS = 1;

	private int metrosCuadrados, plantas, habitaciones, bannos;
	private String calidades; // Baja, media, alta Constantes
	private boolean piscina, garaje;

	
	/**
	 * Constructor de la clase.
	 * Lanza excepci�n en caso de no tener los valores correctos. (CasaImposibleException)
	 * @throws CasaImposibleException 
	 */
	public Casa(int metrosCuadrados, int plantas, int habitaciones, int bannos, String calidades, boolean piscina, boolean garaje) throws CasaImposibleException {
		
			setMetrosCuadrados(metrosCuadrados);
			setPlantas(plantas);
			setHabitaciones(habitaciones);
			setBannos(bannos);
			this.calidades = calidades;
			this.piscina = piscina;
			this.garaje = garaje;

		
	}

	
	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}


	public void setMetrosCuadrados(int metrosCuadrados) throws CasaImposibleException {
		if(metrosCuadrados < MINIMO_METROS_CUADRADOS) {
			throw new CasaImposibleException("Metros cuadrados introducidos incorrecto");
		}
		this.metrosCuadrados = metrosCuadrados;
	}


	public int getPlantas() {
		return plantas;
	}


	private void setPlantas(int plantas) throws CasaImposibleException {
		if(plantas < MIN_PLANTAS) {
			throw new CasaImposibleException("Numero de plantas incorrecta");
		}
		this.plantas = plantas;
	}


	public int getHabitaciones() {
		return habitaciones;
	}


	private void setHabitaciones(int habitaciones) throws CasaImposibleException {
		if(habitaciones < MIN_HAB) {
			throw new CasaImposibleException("Numeros de habitaciones incorrecta");
		}
		this.habitaciones = habitaciones;
	}


	public int getBannos() {
		return bannos;
	}


	private void setBannos(int bannos) throws CasaImposibleException {
		if(bannos < MIN_BANNOS) {
			throw new CasaImposibleException("Numero de ba�os incorrecto");
		}
		this.bannos = bannos;
	}


	public String getCalidades() {
		return calidades;
	}



	/**
	 * Metodo para calcular el precio de la casa en funci�n de sus caracter�sticas
	 * 
	 * @return el precio en �  de la vivienda
	 */
	public float getPrecio() {
		float precio = 0;

		if(calidades.contentEquals(CALIDAD_BAJA)) {
			precio = (float) precioCalidadBaja();
		}else {
			if(calidades.equals(CALIDAD_MEDIA)) {
				precio = (float) precioCalidadMedia();
			}else {
				if(calidades.equals(CALIDAD_ALTA)) {
					precio = (float) precioCalidadAlta();
				}
			}
		}

		return precio;
	}
	
	/**
	 * Metodo para calcular el precio de las calidades bajas
	 */
	public double precioCalidadBaja() {
		double precio;
		
		precio = (this.metrosCuadrados * PRECIO_BAJA) ;
		precio = (precio * this.plantas )/100 + precio;
		precio = precio + 500 * this.habitaciones;
		precio = precio + 1000 * this.bannos;
		
		if(piscina) {
			precio = precio + 10000;
		}
		if(garaje) {
			precio = precio + 5000;
		}
		
		return precio;
	}
	/**
	 * Metodo para calcular el precio de las calidades medias
	 * @return
	 */
	public double precioCalidadMedia() {
		double precio;
		
		precio = (this.metrosCuadrados * PRECIO_MEDIA) ;
		precio = (precio * this.plantas )/100 + precio;
		precio = precio + 500 * this.habitaciones;
		precio = precio + 1000 * this.bannos;
		
		if(piscina) {
			precio = precio + 10000;
		}
		if(garaje) {
			precio = precio + 5000;
		}
		
		return precio;
	}
	
	/**
	 * Metodo para calcular el precio de las calidades altas
	 * @return
	 */
	public double precioCalidadAlta() {
		double precio;
		
		precio = (this.metrosCuadrados * PRECIO_ALTA) ;
		precio = (precio * this.plantas )/100 + precio;
		precio = precio + 500 * this.habitaciones;
		precio = precio + 1000 * this.bannos;
		
		if(piscina) {
			precio = precio + 10000;
		}
		if(garaje) {
			precio = precio + 5000;
		}
		
		return precio;
	}
}
