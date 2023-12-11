package it.francesco.MyEXE_Spring_REST_JPA.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Optional<List<Cliente>> findByNome(String nome);
	List<Cliente> findById(int id);
	 @Modifying
	    @Transactional
	    @Query("UPDATE Cliente c SET c.nome = ?1, c.cognome = ?2, c.cartaDiCredito = ?3 WHERE c.id_cliente = ?4")
	    int myUpdateClienteById(@Param("nome") String nome, @Param("cognome") String cognome, @Param("cartaDiCredito") String cartaDiCredito, int id);
}
