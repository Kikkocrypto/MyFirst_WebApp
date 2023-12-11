package it.francesco.MyEXE_Spring_REST_JPA.Cliente;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // beanizza classe e lavora con repository
public class ServiceCliente {

	@Autowired
	ClienteRepository clienteRepository;
	//SELECT
	public List<Cliente> myFindAllCustomers() {
		return clienteRepository.findAll();
	}
	public List<Cliente> myFindUserById(int id) {
	    return clienteRepository.findById(id); // Puoi gestire il caso in cui il cliente non esista
	}
	//INSERT
	public void myInsertClienteParams(String nome, String cognome, String cartaDiCredito) {
		clienteRepository.save(new Cliente(nome, cognome, cartaDiCredito));
	}
	public Cliente myInsertClienteObj(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	// UPDATE
	public int myUpdateClienteByIdParam(String nome, String cognome, String cartaDiCredito, int id_user) {
		return clienteRepository.myUpdateClienteById(nome, cognome, cartaDiCredito, id_user);
	}
	public int myUpdateClienteById(Cliente cliente) {
		return clienteRepository.myUpdateClienteById(cliente.getNome(), cliente.getCognome(), cliente.getcartaDiCredito(),
				cliente.getId_cliente());
	}
	//DELETE
	public void myDeleteClienteById(int id) {
		clienteRepository.deleteById(id);
	}


}