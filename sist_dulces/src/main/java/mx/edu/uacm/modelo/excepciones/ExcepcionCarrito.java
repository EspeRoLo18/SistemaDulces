package mx.edu.uacm.modelo.excepciones;

public class ExcepcionCarrito extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExcepcionCarrito(String mensaje) {
		super(mensaje);
	}

}
