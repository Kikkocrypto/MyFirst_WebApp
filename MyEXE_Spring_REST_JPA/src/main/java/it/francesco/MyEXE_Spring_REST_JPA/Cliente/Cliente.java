package it.francesco.MyEXE_Spring_REST_JPA.Cliente;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT
	private int id_cliente;
	private String nome;
	private String cognome;
	private String cartaDiCredito;
	
	public Cliente() {
      
  }

	public Cliente(String nome, String cognome, String cartaDiCredito) {
		this.nome = nome;
		this.cognome = cognome;
		this.cartaDiCredito = cartaDiCredito;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente= id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getcartaDiCredito() {
		return cartaDiCredito;
	}

	public void setcartaDiCredito(String cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}


	
}