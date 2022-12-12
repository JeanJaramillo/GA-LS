package pe.edu.certus.producto.producto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.certus.producto.producto.entity.ClienteData;
import pe.certus.producto.producto.entity.ProductoData;
import pe.edu.certus.producto.producto.data.*;
import pe.edu.certus.producto.producto.services.ProductoServices;
import pe.edu.certus.producto.producto.services.ClienteServices;

@Controller
public class CertusController {
	@Autowired
	private ProductoServices productoServices;
	
	@Autowired
	private ClienteServices clienteServices;

	
	@GetMapping("/views/consult")
	public String VistaConsula() {
		return "consult";
	}
	
	@GetMapping("/views/solicit")
		public String VistaSolicit() {
			return "solicit";
		}
	
	
	@GetMapping("/views/modificar")
	public String Consulta(@RequestParam(name = "id", required = false, defaultValue = "1") Long id, Model model) {
		
		ProductoData bean = new ProductoData();
		
		Optional<Producto> p = productoServices.obtenerProducto(id);
		

		if (!p.isEmpty()) {
			bean.setId(p.get().getId());
			bean.setName(p.get().getName());
			bean.setStockProduc(p.get().getStockProduc());
			bean.setAlmacenProducto(p.get().getAlmacenProducto());
			/*
			 * model.addAttribute("IDProducto", p.get().getId());
			 * model.addAttribute("Nombre", p.get().getName()); 
			 * model.addAttribute("Stock", p.get().getStockProduc()); 
			 * model.addAttribute("Almacen",p.get().getAlmacenProducto());
			 */
			model.addAttribute("Producto", bean);
			model.addAttribute("mensaje", "OK");
		} else {
			model.addAttribute("mensaje", "No existe Producto con el ID");
		}
		return "Modificar";
	}
	
	@GetMapping("/views/solicitar")
	public String Solicitar(@RequestParam(name = "id", required = false, defaultValue = "1") Long id, Model model) {
		
		ClienteData bean = new ClienteData();
		
		Optional<Cliente> c = clienteServices.obtenerCliente(id);
		

		if (!c.isEmpty()) {
			bean.setIdCliente(c.get().getId());
			bean.setNameCliente(c.get().getNombres());
			bean.setLastNameCliente(c.get().getApellidos());
			bean.setEmailCliente(c.get().getEmail());
			bean.setCountryCliente(c.get().getPais());
			bean.setStateCliente(c.get().getCiudad());
			bean.setPhoneNumberCliente(c.get().getTelefono());
			/*
			 * model.addAttribute("IDProducto", p.get().getId());
			 * model.addAttribute("Nombre", p.get().getName()); 
			 * model.addAttribute("Stock", p.get().getStockProduc()); 
			 * model.addAttribute("Almacen",p.get().getAlmacenProducto());
			 */
			model.addAttribute("Cliente", bean);
			model.addAttribute("mensaje", "OK");
		} else {
			model.addAttribute("mensaje", "No existe Producto con el ID");
		}
		return "Solicitar";
	}
	
	@GetMapping("/views/nuevoCliente")
	public String NuevoCliente(Model model) {
		model.addAttribute("mensaje", "OK");
		model.addAttribute("Cliente", new ClienteData());
		return "NuevoCliente";
	}
	
	@PostMapping("/views/guardarCliente")
	public String SaveCliente(@ModelAttribute ClienteData cliente) {
		System.out.println(cliente);
		Cliente c = new Cliente();
		
		c.setNombres(cliente.getNameCliente());
		c.setApellidos(cliente.getLastNameCliente());
		c.setEmail(cliente.getEmailCliente());
		c.setPais(cliente.getCountryCliente());
		c.setCiudad(cliente.getStateCliente());
		c.setTelefono(cliente.getPhoneNumberCliente());
		
		clienteServices.guardarCliente(c);
		return "redirect:/views/solicitar";
	}
	
	//Ruta de vista
	@GetMapping("/views/nuevoProducto")
	public String NuevoProducto(Model model) {
		model.addAttribute("mensaje", "OK");
		model.addAttribute("Producto", new ProductoData());
		return "NuevoProducto";
	}
	
	//Ruta guarda datos
	@PostMapping("/views/guardar")
	public String SaveProducto(@ModelAttribute ProductoData producto) {
		System.out.println(producto);
		Producto p = new Producto();

		p.setName(producto.getName());
		p.setStockProduc(producto.getStockProduc());
		p.setAlmacenProducto(producto.getAlmacenProducto());

		productoServices.guardarProducto(p);
		return "redirect:/views/consulta";
	}

	@PostMapping("/views/modificar")
	public String ModificarProducto(@ModelAttribute ProductoData producto) {
		System.out.println(producto);
		Producto p = new Producto();

		p.setName(producto.getName());
		p.setStockProduc(producto.getStockProduc());
		p.setAlmacenProducto(producto.getAlmacenProducto());
		p.setId(producto.getId());

		productoServices.guardarProducto(p);
		return "redirect:/views/modificar?id=" + p.getId();
	}
	
	
	
	

}