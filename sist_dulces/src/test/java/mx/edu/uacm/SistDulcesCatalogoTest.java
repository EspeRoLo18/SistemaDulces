package mx.edu.uacm;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.modelo.Catalogo;
import mx.edu.uacm.modelo.Dulce;
import mx.edu.uacm.modelo.Producto;
import mx.edu.uacm.modelo.TipoDulce;
import mx.edu.uacm.modelo.interfaces.ICatalogo;

@SpringBootTest
public class SistDulcesCatalogoTest {
	private static final Logger log = LogManager.getLogger(SistDulcesCatalogoTest.class);
	
	private Catalogo catalogo = new Catalogo();;
	
	/**
	 * Prueba de caja negra
	 */
	@Test
	@Order(1)
	public void test_agregar_nulo() {
		try {
			Producto p = null;
			catalogo.agregar(p);
		} catch (Exception e) {
			log.debug(e.getMessage());
//			assertEquals("El producto es nulo :(", e.getMessage());
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba covertura de rama
	 */
	@Test
	@Order(2)
	public void test_agregar_producto() {
		try {
			Producto p;
			p = new Dulce("Picagomas", "Vero", 40, 150, TipoDulce.GOMITA);
			((Dulce)p).setImagen("picagomas.jpeg");
			((Dulce)p).setDescripcion("Es una gomita picosa");
			catalogo.agregar(p);
			
			Producto regresa = catalogo.obtenerProducto(0);
			assertNotNull(regresa);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}
	
	/**
	 * Prueba covertura de rama
	 */
	@Test
	@Order(3)
	public void test_eliminar_nulo() {
		try {
			Producto p = null;
			catalogo.eliminar(p);
		} catch (Exception e) {
			log.debug(e.getMessage());
//			assertEquals("El producto es nulo :(", e.getMessage());
			fail(e.getMessage());
		}
	}
	/**
	 * Prueba de caja negra
	 */
	@Test
	@Order(4)
	public void test_eliminar_producto() {
		try {
			Producto p;
			p = new Dulce("Picagomas", "Vero", 40, 150, TipoDulce.GOMITA);
			((Dulce)p).setImagen("picagomas.jpeg");
			((Dulce)p).setDescripcion("Es una gomita picosa");
			catalogo.agregar(p);
			catalogo.eliminar(p);
			Producto regresa = catalogo.obtenerProducto(0);
		} catch (Exception e) {
			log.debug(e.getMessage());
//			assertEquals("La posicion es > tama\\u00f1o del catalogo :(", e.getMessage());
			fail(e.getMessage());
		}
	}
	/**
	 * Prueba cobertura de rama
	 */
	@Test
	@Order(5)
	public void test_obtener_producto_posicion_menor_a_cero() {
		try {
			Producto p;
			p = new Dulce("Picagomas", "Vero", 40, 150, TipoDulce.GOMITA);
			((Dulce)p).setImagen("picagomas.jpeg");
			((Dulce)p).setDescripcion("Es una gomita picosa");
			catalogo.agregar(p);
			/*
			 * Intentando obtener un producto en una posicion no disponible de 
			 * la lista de productos.
			 */
			Producto regresa = catalogo.obtenerProducto(-1);
		} catch (Exception e) {
			log.debug(e.getMessage());
//			assertEquals("La posicion es < 0 :(", e.getMessage());
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba de cobertura de rama
	 */
	@Test
	@Order(6)
	public void test_obtener_producto_posicion_mayor() {
		try {
			Producto p;
			p = new Dulce("Picagomas", "Vero", 40, 150, TipoDulce.GOMITA);
			((Dulce)p).setImagen("picagomas.jpeg");
			((Dulce)p).setDescripcion("Es una gomita picosa");
			catalogo.agregar(p);
			/*
			 * Intentando obtener un proudcto que no esta en la lista, es decir,
			 * [pruducto_0]  yo intento obtener el pructo en el luigar 11,
			 * lo cual es imposible.
			 */
			Producto regresa = catalogo.obtenerProducto(11);
		} catch (Exception e) {
			log.debug(e.getMessage());
//			assertEquals("La posicion es > tamaño del catalogo :(", e.getMessage());
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba de caja negra
	 */
	@Test
	@Order(7)
	public void test_obtener_producto_correcto() {
		try {
			Producto p;
			p = new Dulce("Picagomas", "Vero", 40, 150, TipoDulce.GOMITA);
			((Dulce)p).setImagen("picagomas.jpeg");
			((Dulce)p).setDescripcion("Es una gomita picosa");
			catalogo.agregar(p);
			Producto regresa = catalogo.obtenerProducto(0);
			assertEquals(p, regresa);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}
	
}
