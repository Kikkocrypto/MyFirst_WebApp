package it.francesco.MyEXE_Spring_REST_JPA.Ordine;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Type;

import it.francesco.MyEXE_Spring_REST_JPA.Cliente.Cliente;
import it.francesco.MyEXE_Spring_REST_JPA.Prodotto.Prodotto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ordine;
    private String data;

    @ManyToOne
    private Prodotto prodotto;

    @ManyToOne
    private Cliente cliente;

    public Ordine() {
    }

    public Ordine(String data, Cliente cliente, Prodotto prodotto) {
        this.data = data;
        this.cliente = cliente;
        this.prodotto = prodotto;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

