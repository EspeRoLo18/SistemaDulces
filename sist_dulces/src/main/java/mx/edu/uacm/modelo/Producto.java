package mx.edu.uacm.modelo;


import mx.edu.uacm.modelo.excepciones.ExcepcionProducto;
import mx.edu.uacm.modelo.interfaces.Vendible;

public abstract class Producto implements Vendible {
	private double precio;
	private static final double IVA = 0.16;
	/**
	 * 
	 * @param precio. Es el precio del producto. 
	 * @throws ExcepcionProducto
	 */
	public Producto(double precio) throws ExcepcionProducto {
		if (precio > 0) {
			this.precio = precio + (precio * IVA);
		} else {
			throw new ExcepcionProducto("El precio es <= 0 ... :(");
		}
	}
	/**
	 * 
	 * @return el precio del producto
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * 
	 * @param precio. Es de tipo double
	 * @throws ExcepcionProducto
	 */

	public void setPrecio(double precio) throws ExcepcionProducto {
		if (precio > 0) {
			this.precio = precio + (precio * IVA);
		} else {
			throw new ExcepcionProducto("El precio es <= 0 ... :(");
		}
	}
	/**
	 * 
	 * @return el nombre del producto
	 */
	public abstract String getNombre();
	
	
}
