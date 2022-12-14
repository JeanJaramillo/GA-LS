package pe.edu.certus.producto.producto.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pe.edu.certus.producto.producto.data.*;

@Component
public class AppStartUpEvent implements ApplicationListener<ApplicationReadyEvent> {

	private final ProductoRepository productoRepository;

	public AppStartUpEvent(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		System.out.println("TODO OK.");
		/*Iterable<Producto> productos = this.productoRepository.findAll();
		productos.forEach(System.out::println);*/
	}

}
