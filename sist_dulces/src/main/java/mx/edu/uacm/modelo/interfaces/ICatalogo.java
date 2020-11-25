package mx.edu.uacm.modelo.interfaces;


import mx.edu.uacm.modelo.Producto;
import mx.edu.uacm.modelo.excepciones.ExcepcionCatalogo;

public interface ICatalogo {
	public void agregar(Producto p) throws ExcepcionCatalogo;
	public void eliminar(Producto p) throws ExcepcionCatalogo;
	public Producto obtenerProducto(int posicion) throws ExcepcionCatalogo;
}
