package mx.edu.uacm.modelo.interfaces;

import mx.edu.uacm.modelo.excepciones.ExcepcionCarrito;

public interface ICarrito {
	public void agregar(Vendible v) throws ExcepcionCarrito;
	public void eliminar(int posicion) throws ExcepcionCarrito;
	public double dameTotal();
}
