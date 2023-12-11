package it.francesco.MyEXE_Spring_REST_JPA.Ordine;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.francesco.MyEXE_Spring_REST_JPA.Cliente.Cliente;
import it.francesco.MyEXE_Spring_REST_JPA.Prodotto.Prodotto;


@Service // beanizza classe e lavora con repository
public class ServiceOrdine {

	@Autowired
	OrdineRepository ordineRepository;
	//SELECT
	public List<Ordine> myFindAllOrders() {
		return ordineRepository.findAll();
	}
	public List<Ordine> myFindOrderById(int id) {
	    return ordineRepository.findById(id); // Puoi gestire il caso in cui il cliente non esista
	}
	//INSERT
	public void myInsertOrderParams(String data, int id_cliente, int id_prodotto) {
		ordineRepository.save(new Ordine());
	}
	public Ordine myInsertOrderObj(Ordine ordine) {
		return ordineRepository.save(ordine);
	}
	// UPDATE
	public int myUpdateOrderByIdParam(String data, Cliente cliente, Prodotto prodotto, int id_ordine) {
	    return ordineRepository.myUpdateOrderById(data, cliente, prodotto, id_ordine);
	}

	public int myUpdateOrderById(Ordine ordine) {
	    return ordineRepository.myUpdateOrderById(ordine.getData(), ordine.getCliente(), ordine.getProdotto(), ordine.getId_ordine());
	}
	//DELETE
	public void myDeleteOrderById(int id_cliente) {
		ordineRepository.deleteById(id_cliente);
	}


}