package it.francesco.MyEXE_Spring_REST_JPA.Prodotto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.francesco.MyEXE_Spring_REST_JPA.Cliente.Cliente;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
	Optional<List<Prodotto>> findByMarca(String marca);
	List<Prodotto> findById(int id);
	 @Modifying
	    @Transactional
	    @Query("UPDATE Prodotto p SET p.marca = ?1, p.nome = ?2, p.prezzo = ?3 WHERE p.id_prodotto = ?4")
	    int myUpdateProdottoById(@Param("marca") String marca, @Param("nome") String nome, @Param("prezzo") double prezzo, int id);	 
}