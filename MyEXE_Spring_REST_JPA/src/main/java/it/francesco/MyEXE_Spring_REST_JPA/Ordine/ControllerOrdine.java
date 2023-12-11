package it.francesco.MyEXE_Spring_REST_JPA.Ordine;

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

import it.francesco.MyEXE_Spring_REST_JPA.Cliente.Cliente;
import it.francesco.MyEXE_Spring_REST_JPA.Prodotto.Prodotto;
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/myordine")
public class ControllerOrdine {

	@Autowired
	 private ServiceOrdine myService;
	  
	 /* GET */
	 @GetMapping("/mygetallorders")
	 public List<Ordine> myGetAllOrders() {
	  return myService.myFindAllOrders();
	 }
	  
	 @GetMapping("/mygetorderbyid/{id}")
	 public List<Ordine> myGetUserById(@PathVariable int id) {
	  return myService.myFindOrderById(id);
	 }
 
	 /* POST 
	 // Post via Form HTML: usa @RequestParam e consuma APPLICATION_FORM_URLENCODED_VALUE
	 @PostMapping(value="/mypostinsertcustomerparams", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	 public void myPostParams(@RequestParam String nome, String cognome, String cartaDiCredito) {
	  myService.myInsertClienteParams(nome, cognome, cartaDiCredito);
	 } */
	 
	 // Post via app (es. Postman, Angular, ecc.): usa @RequestBody e consuma APPLICATION_JSON_VALUE (default)
	 @PostMapping("/mypostinsertorderobj")
	 public void myPostObj(@RequestBody Ordine ordine) {
		 myService.myInsertOrderObj(ordine);
		    System.out.println("Ordine inserito con successo!");
	 }

	 //PUT
	 @PutMapping("/myputupdateorderobj")
	 public int myPutUpdateObj(@RequestBody Ordine ordine) {  
	  return myService.myUpdateOrderById(ordine); 
	 } 
	 //String data, Cliente cliente, Prodotto prodotto, int id_ordine
	 @PutMapping("/myupdateorderbyid/{id_ordine}")
	 public int myPostUpdateParams(@RequestParam String data, Cliente id_cliente, Prodotto id_prodotto, @PathVariable int id_ordine) {  
	  return myService.myUpdateOrderByIdParam(data, id_cliente, id_prodotto, id_ordine); 
	 }
	 
	 //DELETE
	 @DeleteMapping("/deleteorderbyid/{id}")
	 public void deleteUserById(@PathVariable int id) {
	  myService.myDeleteOrderById(id);  
	 }
}	 