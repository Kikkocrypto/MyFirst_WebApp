package it.francesco.MyEXE_Spring_REST_JPA.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
/*@Component
public class CLRCliente implements CommandLineRunner {
	@Autowired
    private ClienteRepository clienteRepository;

    
    @Override
    public void run(String... args) {

       /* Cliente cliente1 = new Cliente("Nome1", "Cognome1", "cartaDiCredito#1");
        clienteRepository.save(cliente1);
        Cliente cliente2 = new Cliente("Nome2", "Cognome2", "cartaDiCredito#2");
        clienteRepository.save(cliente2);
        Cliente cliente3 = new Cliente("Nome3", "Cognome3", "cartaDiCredito#3");
        clienteRepository.save(cliente3);
        Cliente cliente4 = new Cliente("Nome4", "Cognome4", "cartaDiCredito#4");
        clienteRepository.save(cliente4);
        Cliente cliente5 = new Cliente("Nome5", "Cognome5", "cartaDiCredito#5");
        clienteRepository.save(cliente5);
        Cliente cliente6 = new Cliente("Nome6", "Cognome6", "cartaDiCredito#6");
        clienteRepository.save(cliente6);
        Cliente cliente7 = new Cliente("Nome7", "Cognome7", "cartaDiCredito#7");
        clienteRepository.save(cliente7);
        Cliente cliente8 = new Cliente("Nome8", "Cognome8", "cartaDiCredito#8");
        clienteRepository.save(cliente8);
        Cliente cliente9 = new Cliente("Nome9", "Cognome9", "cartaDiCredito#9");
        clienteRepository.save(cliente9);


    }
}*/