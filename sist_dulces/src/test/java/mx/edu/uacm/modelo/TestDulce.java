package mx.edu.uacm.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.edu.uacm.modelo.excepciones.ExcepcionProducto;

class TestDulce {
	private Dulce dulce;
	@BeforeEach
	void setUp() throws Exception {
		dulce = new Dulce("Pulparidno", "De La Rosa", 40, 20, TipoDulce.TAMARINDO);
	}
	/**
	 * Prueba con id: 01
	 */
	@Test
	void test01() {
		try {
			Dulce d = new Dulce("Pulparidno", "De La Rosa", 40, 20, TipoDulce.TAMARINDO);
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 01");
		}
	}
	
	@Test
	void test02() {
		try {
			Dulce d = new Dulce("pulparidno", "De La Rosa", 40, 20, TipoDulce.TAMARINDO);
			fail("Fallo la prueba 02");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test03() {
		try {
			Dulce d = new Dulce(null, "De La Rosa", 40, 20, TipoDulce.TAMARINDO);
			fail("Fallo la prueba 03");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test04() {
		try {
			Dulce d = new Dulce("Pulparidno", "de La Rosa", 40, 20, TipoDulce.TAMARINDO);
			fail("Fallo la prueba 04");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test05() {
		try {
			Dulce d = new Dulce("Pulparidno", null, 40, 20, TipoDulce.TAMARINDO);
			fail("Fallo la prueba 05");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test06() {
		try {
			Dulce d = new Dulce("Pulparidno", "De La Rosa", 0, 20, TipoDulce.TAMARINDO);
			fail("Fallo la prueba 06");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test07() {
		try {
			Dulce d = new Dulce("Pulparidno", "De La Rosa", 40, 0, TipoDulce.TAMARINDO);
			fail("Fallo la prueba 07");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test08() {
		try {
			Dulce d = new Dulce("Pulparidno", "De La Rosa", 40, 20, null);
			fail("Fallo la prueba 08");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test09() {
		try {
			dulce.setPrecio(1);
			assertEquals(1.16, dulce.getPrecio());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 09");
		}
	}
	
	@Test
	void test10() {
		try {
			dulce.setPrecio(0);
			fail("Fallo la prueba 10");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test11() {
		try {
			dulce.setCantidad(1);
			assertEquals(1, dulce.getCantidad());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 11");
		}
	}
	
	@Test
	void test12() {
		try {
			dulce.setCantidad(0);
			fail("Fallo la prueba 12");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test13() {
		try {
			dulce.setDescuento(0);
			assertEquals(0, dulce.getDescuento());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 13");
		}
	}
	
	@Test
	void test14() {
		try {
			dulce.setDescuento(70);
			assertEquals(70, dulce.getDescuento());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 14");
		}
	}
	
	@Test
	void test15() {
		try {
			dulce.setDescuento(-1);
			fail("Fallo la prueba 15");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test16() {
		try {
			dulce.setDescuento(71);
			fail("Fallo la prueba 16");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test 
	void test17() {
		try {
			dulce.setPrecio(40);
			dulce.setDescuento(50);
			assertEquals(23.2, dulce.calcularPrecio());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 17");
		}
	}
	
	@Test
	void test18() {
		try {
			dulce.setPrecio(40);
			dulce.setDescuento(0);
			assertEquals(46.4, dulce.calcularPrecio());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 09");
		}
	}
	
	@Test
	void test19() {
		try {
			dulce.setNombre("Pulparindo Dots");
			assertEquals("Pulparindo Dots", dulce.getNombre());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 19");
		}
	}
	
	@Test
	void test20() {
		try {
			dulce.setNombre("Pulparindo dots");
			fail("Fallo la prueba 20");
		} catch (ExcepcionProducto e) {
		}
	}
	
	@Test
	void test21() {
		try {
			dulce.setMarca("Vero");
			assertEquals("Vero", dulce.getMarca());
		} catch (ExcepcionProducto e) {
			fail("Fallo la prueba 21");
		}
	}
	
	@Test
	void test22() {
		try {
			dulce.setNombre("vero");
			fail("Fallo la prueba 22");
		} catch (ExcepcionProducto e) {
		}
	}

}
