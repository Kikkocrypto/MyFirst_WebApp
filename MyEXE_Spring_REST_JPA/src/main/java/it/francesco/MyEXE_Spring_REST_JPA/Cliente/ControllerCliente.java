package it.francesco.MyEXE_Spring_REST_JPA.Cliente;

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
@CrossOrigin("http://localhost:4200")
@RequestMapping("/mycliente")
public class ControllerCliente {

	@Autowired
	 private ServiceCliente myService;
	  
	 /* GET */
	
	 @GetMapping("/mygetallcustomer")
	 public List<Cliente> myGetAllCustomers() {
	  return myService.myFindAllCustomers();
	 }
	  
	 @GetMapping("/mygetcustomerbyid/{id}")
	 public List<Cliente> myGetUserById(@PathVariable int id) {
	  return myService.myFindUserById(id);
	 }
 
	 //POST 
	 @PostMapping(value="/mypostinsertcustomerparams", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	 public void myPostParams(@RequestParam String nome, String cognome, String cartaDiCredito) {
	  myService.myInsertClienteParams(nome, cognome, cartaDiCredito);
	 } 
	 
	 // Post via app (es. Postman, Angular, ecc.): usa @RequestBody e consuma APPLICATION_JSON_VALUE (default)
	 @PostMapping("/mypostinsertcustomerobj")
	 public void myPostObj(@RequestBody Cliente cliente) {
		 myService.myInsertClienteObj(cliente);
		    System.out.println("Cliente inserito con successo!");
	 }
	 
	 
	 //PUT
	 @PutMapping("/myputupdatecustomerobj")
	 public int myPutUpdateObj(@RequestBody Cliente cliente) {  
	  return myService.myUpdateClienteById(cliente); 
	 } 
	 
	 @PutMapping("/myupdatecustomerbyid/{id_cliente}")
	 public int myPostUpdateParams(@RequestParam String nome, String cognome, String cartaDiCredito, @PathVariable int id_cliente) {  
	  return myService.myUpdateClienteByIdParam(nome, cognome, cartaDiCredito, id_cliente); 
	 }
	 
	 //DELETE
	 @DeleteMapping("/deletecustomerbyid/{id}")
	 public void deleteUserById(@PathVariable int id) {
	  myService.myDeleteClienteById(id);  
	 }
}	 