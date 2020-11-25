package mx.edu.uacm.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mx.edu.uacm.modelo.excepciones.ExcepcionCarrito;
import mx.edu.uacm.modelo.interfaces.ICarrito;
import mx.edu.uacm.modelo.interfaces.Vendible;

public class Carrito implements ICarrito, Iterable<Vendible> {
	private List<Vendible> lista;
	private Double total;
	
	public Carrito() {
		lista = new ArrayList<Vendible>();
		total = 0.0;
	}

	@Override
	public void agregar(Vendible v) throws ExcepcionCarrito {
		if (v != null) {
			lista.add(v);
			total += v.calcularPrecio();
		} else {
			throw new ExcepcionCarrito("El vendible es nulo :(");
		}
	}

	@Override
	public void eliminar(int posicion) throws ExcepcionCarrito {
		if (posicion <= 0) {
			if (posicion < lista.size()) {
				Vendible v = lista.remove(posicion);
				total -= v.calcularPrecio();
			} else {
				throw new ExcepcionCarrito("La posicion sobrepasa el limite :(");
			}
		} else {
			throw new ExcepcionCarrito("La posicion es < 0 :(");
		}
	}

	@Override
	public double dameTotal() {
		return total;
	}

	@Override
	public Iterator<Vendible> iterator() {
		return this.lista.iterator();
	}
	
	public int tamanio() {
		return lista.size();
	}

	



}
