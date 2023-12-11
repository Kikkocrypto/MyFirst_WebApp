package it.francesco.MyEXE_Spring_REST_JPA.Ordine;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.francesco.MyEXE_Spring_REST_JPA.Cliente.Cliente;
import it.francesco.MyEXE_Spring_REST_JPA.Prodotto.Prodotto;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
	List<Ordine> findById(int id);
	@Modifying
    @Transactional
    @Query("UPDATE Ordine o SET o.data = ?1, o.cliente = ?2, o.prodotto = ?3 WHERE o.id_ordine = ?4")
    int myUpdateOrderById(@Param("data") String data, @Param("cliente_id_cliente") Cliente cliente, @Param("prodotto_id_prodotto") Prodotto prodotto, int id_ordine);
}
