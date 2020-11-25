package mx.edu.uacm.modelo;


import java.util.regex.Pattern;

import mx.edu.uacm.modelo.excepciones.ExcepcionProducto;

public class Dulce extends Producto {
	private Integer id;
	private String nombre;
	private String marca;
	private Integer cantidad;
	private String descripcion;
	private String imagen;
	private double descuento;
	private TipoDulce tipo;
	
	
	
	public Dulce(String nombre, String marca, double precio, 
			int cantidad, TipoDulce tipo) 
			throws ExcepcionProducto {
		super(precio);
		
		if (nombre != null) {
			if (verificarNombre(nombre)) {
				this.nombre = nombre;
			} else {
				throw new ExcepcionProducto("El nombre no cumple con la estructura :(");
			}
		} else {
			throw new ExcepcionProducto("El nombre es nulo :(");
		}
		
		if (marca != null) {
			if (verificarNombre(marca)) {
				this.marca = marca;
			} else {
				throw new ExcepcionProducto("La marca no cumple con la estructura :(");
			}
		} else {
			throw new ExcepcionProducto("La marca se paso como nula :(");
		}
		
		if (cantidad > 0) {
			this.cantidad = cantidad;
		} else {
			throw new ExcepcionProducto("La cantidad es <= 0 :(");
		}
		
		if (tipo != null) {
			this.tipo = tipo;
		} else {
			throw new ExcepcionProducto("El tipo se paso como nulo :(");
		}
		descuento = 0.0;
	}
	
	
	private boolean verificarNombre(String nombre) {
		String expresion = "";
		expresion = "^([A-Z\u00d1\u00c1\u00c9\u00cd\u00da][a-z\u00f1\u00e1\u00e9\u00ed\u00f3\u00fa]+"
				+ "[ ]?)+$";
		return Pattern.matches(expresion, nombre);
	}
	
	
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws ExcepcionProducto {
		if (cantidad > 0) {
			this.cantidad = cantidad;
		} else {
			throw new ExcepcionProducto("La cantidad es <= 0 :(");
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws ExcepcionProducto {
		if (descripcion != null) {
			this.descripcion = descripcion;
		} else {
			throw new ExcepcionProducto("La descripcion se paso como nula :(");
		}
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) throws ExcepcionProducto {
		if (imagen != null) {
			this.imagen = imagen;
		} else {
			throw new ExcepcionProducto("La direccion de la imagen es nula :(");
		}
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) throws ExcepcionProducto {
		if (marca != null) {
			if (verificarNombre(marca)) {
				this.marca = marca;
			} else {
				throw new ExcepcionProducto("La marca no cumple con la estructura :(");
			}
		} else {
			throw new ExcepcionProducto("La parametro de la marca es nulo :(");
		}
	}
	
	public double getDescuento() {
		return descuento * 100;
	}

	public void setDescuento(double descuento) throws ExcepcionProducto {
		if (descuento >= 0) {
			if (descuento <= 70) {
				this.descuento = descuento /= 100; 
			} else {
				throw new ExcepcionProducto("El descuento es mayor al 100% :(");
			}
		} else {
			throw new ExcepcionProducto("El descuento es menor que el 0% :(");
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public TipoDulce getTipo() {
		return tipo;
	}

	public void setNombre(String nombre) throws ExcepcionProducto {
		if(nombre != null) {
			if(verificarNombre(nombre)) {
				this.nombre = nombre;
			} else {
				throw new ExcepcionProducto("El nombre no cumple con la estructura :(");
			}
		} else {
			throw new ExcepcionProducto("El parametro del nombre es nulo :(");
		}
	}


	@Override
	public double calcularPrecio() {
		return getPrecio() - (descuento * getPrecio());
	}
	
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

}
