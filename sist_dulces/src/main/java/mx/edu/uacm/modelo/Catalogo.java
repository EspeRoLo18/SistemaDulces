package mx.edu.uacm.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.uacm.modelo.excepciones.ExcepcionCatalogo;
import mx.edu.uacm.modelo.interfaces.ICatalogo;
@Service
public class Catalogo implements ICatalogo, Iterable<Producto> {
	private List<Producto> productos;
	public Catalogo() {
		productos = new ArrayList<Producto>();
	}
	
	@Override
	public void agregar(Producto p) throws ExcepcionCatalogo {
		if (p != null) {
			productos.add(p);
		} else {
			throw new ExcepcionCatalogo("El producto es nulo :(");
		}
	}
	@Override
	public void eliminar(Producto p) throws ExcepcionCatalogo {
		if (p != null) {
			productos.add(p);
		} else {
			throw new ExcepcionCatalogo("El producto es nulo :(");
		}
	}
	@Override
	public Producto obtenerProducto(int posicion) throws ExcepcionCatalogo {
		Producto p = null;
		if (posicion >= 0) {
			if (posicion < productos.size()) {
				p = productos.get(posicion);
			} else {
				throw new ExcepcionCatalogo("La posicion es > tama\u00f1o del catalogo :(");
			}
		} else {
			throw new ExcepcionCatalogo("La posicion es < 0 :(");
		}
		return p;
	}

	@Override
	public Iterator<Producto> iterator() {
		return productos.iterator();
	}


}
