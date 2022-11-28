package pe.edu.certus.producto.producto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.producto.producto.data.Cliente;
import pe.edu.certus.producto.producto.data.ClienteRepository;

@Service
public class ClienteServices {
	@Autowired
	ClienteRepository clienteRepository;
	
	public Optional<Cliente> obtenerCliente(Long id){
		return this.clienteRepository.findById(id);
	}
	
	public void guardarCliente(Cliente c) {
		clienteRepository.save(c);
	}
	
	
}
