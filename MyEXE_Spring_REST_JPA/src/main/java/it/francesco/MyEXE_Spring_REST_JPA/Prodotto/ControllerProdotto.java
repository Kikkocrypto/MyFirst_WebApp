package it.francesco.MyEXE_Spring_REST_JPA.Prodotto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/myprodotto")
public class ControllerProdotto {

	@Autowired
	 private ServiceProdotto myService;
	  
	 /* GET */
	 @GetMapping("/mygetallproducts")
	 public List<Prodotto> myGetAllProducts() {
	  return myService.myFindAllProducts();
	 }
	  
	 @GetMapping("/mygetproductbyid/{id}")
	 public List<Prodotto> myGetUserById(@PathVariable int id) {
	  return myService.myFindProductById(id);
	 }
 
	 /* POST 
	 // Post via Form HTML: usa @RequestParam e consuma APPLICATION_FORM_URLENCODED_VALUE
	 @PostMapping(value="/mypostinsertcustomerparams", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	 public void myPostParams(@RequestParam String nome, String cognome, String cartaDiCredito) {
	  myService.myInsertClienteParams(nome, cognome, cartaDiCredito);
	 } */
	 
	 // Post via app (es. Postman, Angular, ecc.): usa @RequestBody e consuma APPLICATION_JSON_VALUE (default)
	 @PostMapping("/mypostinsertproductobj")
	 public void myPostObj(@RequestBody Prodotto prodotto) {
		 myService.myInsertProductObj(prodotto);
		    System.out.println("Prodotto inserito con successo!");
	 }
	 
	 
	 //PUT
	 @PutMapping("/myputupdateproductobj")
	 public int myPutUpdateObj(@RequestBody Prodotto prodotto) {  
	  return myService.myUpdateProductById(prodotto); 
	 } 
	 
	 @PutMapping("/myupdateproductbyid/{id_prodotto}")
	 public int myPostUpdateParams(@RequestParam String marca, String nome, double prezzo, @PathVariable int id_prodotto) {  
	  return myService.myUpdateProductByIdParam(marca, nome, prezzo, id_prodotto); 
	 }
	 
	 //DELETE
	 @DeleteMapping("/deleteproductbyid/{id}")
	 public void deleteUserById(@PathVariable int id) {
	  myService.myDeleteProductById(id);  
	 }
}	 