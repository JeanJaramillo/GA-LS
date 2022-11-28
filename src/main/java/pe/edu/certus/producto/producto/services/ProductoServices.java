package pe.edu.certus.producto.producto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.certus.producto.producto.data.Producto;
import pe.edu.certus.producto.producto.data.ProductoRepository;

@Service
public class ProductoServices {
	@Autowired
	ProductoRepository productoRepository;
	
	public Optional<Producto> obtenerProducto(Long id) {
		return this.productoRepository.findById(id);
	}
	
	public void guardarProducto(Producto p) {
		productoRepository.save(p);
	}
	
}
