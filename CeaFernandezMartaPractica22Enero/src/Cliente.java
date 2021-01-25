
public class Cliente {
	
	public static final float MIN_PRESUPUESTO = 1;
	
	private String nombre;
	private Casa casaCliente;
	private float presupuesto;
	
	public Cliente(String nombre, Casa casaCliente, float presupuesto) throws CasaImposibleException {
		this.nombre = nombre;
		this.casaCliente = casaCliente;
		setPresupuesto(presupuesto);
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Casa getCasaCliente() {
		return casaCliente;
	}


	public void setCasaCliente(Casa casaCliente) {
		this.casaCliente = casaCliente;
	}


	public float getPresupuesto() {
		return presupuesto;
	}


	private void setPresupuesto(float presupuesto) throws CasaImposibleException {
		if(presupuesto < MIN_PRESUPUESTO) {
			throw new CasaImposibleException("No se puede calcular el presupuesto");
		}
		this.presupuesto = presupuesto;
	}
	
	/**
	 * M�todo que indica si se puede contruir  la casa del cliente con su presupuesto
	 * 
	 * @return Devuelve la cadena String que se debe mostrar en pantalla.
	 */
	public String veredicto() {
		String res;
		if (this.casaCliente.getPrecio() < this.presupuesto) {
			String casa = "      `'::::.\r\n"
					+ "        _____A_\r\n"
					+ "       /      /\\\r\n"
					+ "    __/__/\\__/  \\___\r\n"
					+ "---/__|\" '' \"| /___/\\----\r\n"
					+ "   |''|\"'||'\"| |' '||\r\n"
					+ "   `\"\"`\"\"))\"\"`\"`\"\"\"\"`";
			res = "Bienvenido a su nueva casa "+this.nombre+"\n\n"+casa+"( "+casaCliente.getPrecio()+"� )";
		} else {
			String puente = "          'x|`\r\n"
					+ "        '|xx| `          '|x|\r\n"
					+ "`   '    |xx|    `   '    |x|`\r\n"
					+ "         |xx|             |x|\r\n"
					+ "============|===============|===--\r\n"
					+ "~~~~~~~~~|xx|~~~~~~~~~~~~~|x|~~~ ~~  ~   ~";
			res = "Con tu presupuesto ("+this.presupuesto+"�) no puedes comprar la casa de tus sue�os ("
					+this.casaCliente.getPrecio()+"�)\n"+puente+
					"\nPero puedes vivir debajo de este bonito puente";
		}
		
		return res;
	}



	
}
