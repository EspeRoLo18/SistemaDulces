package mx.edu.uacm.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.uacm.modelo.Dulce;
import mx.edu.uacm.modelo.Producto;
import mx.edu.uacm.modelo.TipoDulce;
import mx.edu.uacm.modelo.excepciones.ExcepcionCatalogo;
import mx.edu.uacm.modelo.excepciones.ExcepcionProducto;
import mx.edu.uacm.modelo.interfaces.ICatalogo;

@Controller
@RequestMapping("/home")
public class ControladorVentas {
	@Autowired
	private ICatalogo catalogo;
	
	@GetMapping("/ventas")
	public String inicio(Model model) {
		agregarProductos();
		model.addAttribute("catalogo", this.catalogo);
		return "index";
	}
	
	private void agregarProductos() {
		Producto p;
		try {
			p = new Dulce("Picagomas", "Vero", 40, 150, TipoDulce.GOMITA);
			((Dulce)p).setImagen("/img/picagomas.jpeg");
			((Dulce)p).setDescripcion("Es una gomita picosa");
			catalogo.agregar(p);
			p = new Dulce("Pulparidno", "Rosa", 40, 150, TipoDulce.TAMARINDO);
			((Dulce)p).setImagen("/img/pulparindo.jpeg");
			((Dulce)p).setDescripcion("Es una barra de tamarindo salado");
			catalogo.agregar(p);
			p = new Dulce("Tarugos", "Rosa", 40, 150, TipoDulce.TAMARINDO);
			((Dulce)p).setImagen("/img/tarugos.jpeg");
			((Dulce)p).setDescripcion("Barandillas de tamarindo cubierdas de picante en polvo");
			catalogo.agregar(p);
			p = new Dulce("Ricaleta", "Rosa", 40, 150, TipoDulce.PALETA);
			((Dulce)p).setImagen("/img/ricaleta.jpeg");
			((Dulce)p).setDescripcion("Paleta de miel con relleno de picante");
			catalogo.agregar(p);
			p = new Dulce("Pelonetes", "Lucas", 40, 150, TipoDulce.PICANTE);
			((Dulce)p).setImagen("/img/pelon_pelonetes.jpeg");
			((Dulce)p).setDescripcion("Pequeños dulces rellenos de picante");
			catalogo.agregar(p);
		} catch (ExcepcionProducto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionCatalogo e) {
			e.printStackTrace();
		}
	}
}
