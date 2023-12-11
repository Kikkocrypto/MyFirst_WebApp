package it.francesco.MyEXE_Spring_REST_JPA.Prodotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRProdotto implements CommandLineRunner {
	@Autowired
    private ProdottoRepository prodottoRepository;

    
    @Override
    public void run(String... args) {

       /*Prodotto prodotto1 = new Prodotto("Apple", "Iphone", 999);
        prodottoRepository.save(prodotto1);
        Prodotto prodotto2 = new Prodotto("Samsung", "galaxy", 500);
        prodottoRepository.save(prodotto2);
        Prodotto prodotto3 = new Prodotto("Asus", "Vivobook", 300);
        prodottoRepository.save(prodotto3);
        Prodotto prodotto4 = new Prodotto("MSI", "monitor", 299);
        prodottoRepository.save(prodotto4);
        Prodotto prodotto5 = new Prodotto("Tronsmart", "T6 plus", 60);
        prodottoRepository.save(prodotto5);
        Prodotto prodotto6 = new Prodotto("Huawei", "Lite", 200);
        prodottoRepository.save(prodotto6);
        Prodotto prodotto7 = new Prodotto("Honor", "10X", 400);
        prodottoRepository.save(prodotto7);
        Prodotto prodotto8 = new Prodotto("Apple", "macbook", 2999);
        prodottoRepository.save(prodotto8);
        Prodotto prodotto9 = new Prodotto("tecknet", "mouse", 9);
        prodottoRepository.save(prodotto9);*/
    }
}
