package it.francesco.MyEXE_Spring_REST_JPA.Prodotto;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // beanizza classe e lavora con repository
public class ServiceProdotto {

	@Autowired
	ProdottoRepository prodottoRepository;
	//SELECT
	public List<Prodotto> myFindAllProducts() {
		return prodottoRepository.findAll();
	}
	public List<Prodotto> myFindProductById(int id) {
	    return prodottoRepository.findById(id); // Puoi gestire il caso in cui il cliente non esista
	}
	//INSERT
	public void myInsertProductParams(String marca, String nome, double prezzo) {
		prodottoRepository.save(new Prodotto(marca, nome, prezzo));
	}
	public Prodotto myInsertProductObj(Prodotto prodotto) {
		return prodottoRepository.save(prodotto);
	}
	// UPDATE
	public int myUpdateProductByIdParam(String marca, String nome, double prezzo, int id_prodotto) {
		return prodottoRepository.myUpdateProdottoById(marca, nome, prezzo, id_prodotto);
	}
	public int myUpdateProductById(Prodotto prodotto) {
		return prodottoRepository.myUpdateProdottoById(prodotto.getMarca(), prodotto.getNome(), prodotto.getPrezzo(), prodotto.getId_prodotto());
	}
	//DELETE
	public void myDeleteProductById(int id_prodotto) {
		prodottoRepository.deleteById(id_prodotto);
	}


}